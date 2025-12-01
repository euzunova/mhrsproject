package com.bil372.mhrsproject.services.security;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        // Token yoksa devam
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = authHeader.substring(7);

        // Zaten auth set edilmişse ya da token expired ise elleme
        Authentication existingAuth = SecurityContextHolder.getContext().getAuthentication();
        if (existingAuth != null || jwtService.isTokenExpired(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String subject = jwtService.extractUsername(token); // PAT/DR: nationalId, ADMIN: username
        String role    = jwtService.extractRole(token);     // "PATIENT" / "DOCTOR" / "ADMIN"

        if (role == null) {
            filterChain.doFilter(request, response);
            return;
        }

        Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));

        UsernamePasswordAuthenticationToken authToken = null;

        try {
            if ("PATIENT".equalsIgnoreCase(role) || "DOCTOR".equalsIgnoreCase(role)) {
                // subject = nationalId (string), MyUserDetails long istiyor
                long nationalId = Long.parseLong(subject);

                // password'ü burada kullanmadığın için boş string geçiyoruz
                MyUserDetails userDetails = new MyUserDetails(
                        nationalId,
                        "",
                        authorities
                );

                authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
            } else if ("ADMIN".equalsIgnoreCase(role)) {
                // Admin username'i string, MyUserDetails'e uymuyor → normal User kullan
                UserDetails adminUser = new User(
                        subject,   // username
                        "",
                        authorities
                );

                authToken = new UsernamePasswordAuthenticationToken(
                        adminUser,
                        null,
                        adminUser.getAuthorities()
                );
            }
        } catch (NumberFormatException e) {
            // subject long'a çevrilemiyorsa (yanlış token vs.)
            filterChain.doFilter(request, response);
            return;
        }

        if (authToken != null) {
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        // login vb. auth endpointlerini muaf tut
        return path.startsWith("/api/auth");
    }
}
