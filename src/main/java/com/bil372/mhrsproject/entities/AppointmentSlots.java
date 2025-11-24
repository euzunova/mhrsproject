package com.bil372.mhrsproject.entities;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "appointment_slots")
@Entity
public class AppointmentSlots {
    @Id
    @Column(name="appointmendId")
    private int appointmendId;

    @Column(name = "doctorNationalId")
    private long doctorNationalId;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @Column(name = "departmentId")
    private int departmentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime slotDateTime;

    @Column(name = "patientNationalId")
    private long patientNationalId;

    @Column(name = "status")
    private String status;

}
