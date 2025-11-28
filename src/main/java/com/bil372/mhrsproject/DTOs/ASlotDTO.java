package com.bil372.mhrsproject.DTOs;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ASlotDTO {

    // AppointmentSlot
    private int appointmentId;
    private LocalDateTime slotDateTime;
    private String status;

    // Doctor
    private long doctorNationalId;
    private String doctorFirstName;
    private String doctorLastName;

    // Hospital
    private int hospitalId;
    private String hospitalName;
    private String hospitalCity;

    // Department
    private int departmentId;
    private String departmentName; // branchName

    // Patient
    private Long patientNationalId;
    private String patientFirstName;
    private String patientLastName;
}
