package com.bil372.mhrsproject.DTOs;

import lombok.Data;

@Data
public class PrescriptionDrugDTO {

    private int prescriptionDrugId;
    private String drugName;
    private String dosage;
    private String route;
    private String frequency;
    private int durationDays;
    private String instructions;
}
