package com.bil372.mhrsproject.DTOs;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PrescriptionsDTO {

    // Prescription basic info
    private int prescriptionId;
    private LocalDateTime prescriptionDateTime;
    private String diagnosis;
    private String notes;

    // Doctor
    private long doctorNationalId;
    private String doctorFirstName;
    private String doctorLastName;

    // Patient
    private long patientNationalId;
    private String patientFirstName;
    private String patientLastName;

    // Hospital
    private int hospitalId;
    private String hospitalName;
    private String hospitalCity;

    // Department
    private int departmentId;
    private String departmentName;

    // AppointmentSlot
    private int appointmentId;
    private LocalDateTime appointmentSlotDateTime;

    // Prescribed drugs
    private List<PrescriptionDrugDTO> drugs;
}
