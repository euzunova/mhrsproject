package com.bil372.mhrsproject.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bil372.mhrsproject.DTOs.AdminDashboardSummaryDTO;
import com.bil372.mhrsproject.DTOs.WaitingListDTO;
import com.bil372.mhrsproject.services.AdminDashboardService;
import com.bil372.mhrsproject.services.WaitingListService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final WaitingListService waitingListService;
    private final AdminDashboardService adminDashboardService;

    public AdminController(WaitingListService waitingListService, AdminDashboardService adminDashboardService) {
        this.waitingListService = waitingListService;
        this.adminDashboardService = adminDashboardService;
    }

    @GetMapping("/waiting-list")
    public List<WaitingListDTO> getMyWaitingList(Authentication authentication) {
        return waitingListService.getAdminWaitingList();
    }

    @GetMapping("/dashboardSummary")
    @PreAuthorize("hasRole('ADMIN')")
    public AdminDashboardSummaryDTO getAdminDashboardSummaryDTO(Authentication authentication) {
        return adminDashboardService.getSummary();
    }
    
    
}

