package com.bil372.mhrsproject.DTOs;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class DoctorPastAppointmentDTO {

    private int id;                       // appointmentId
    private LocalDateTime dateTime;       // slotDateTime
    private String patientFirstName;      
    private String patientLastName;
    private String prescriptionText;      // nullable, prescription yoksa ""
}
