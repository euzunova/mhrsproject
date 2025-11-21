package com.bil372.mhrsproject.DTOs;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaitingListDTO {
    private int waitingId;
    private String level;
    private String doctorName;
    private String hospitalName;
    private String departmentName;
    private String patientName;
    private LocalDateTime requestDateTime;
}
