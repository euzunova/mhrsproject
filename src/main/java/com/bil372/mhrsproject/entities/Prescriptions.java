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
@Table(name = "prescriptions")
@Entity
public class Prescriptions {

    @Id
    @Column(name = "prescriptionId")
    private int prescriptionId;

    @Column(name="appointmendId")
    private int appointmendId;

    @Column(name = "doctorNationalId")
    private long doctorNationalId;

    @Column(name = "patientNationalId")
    private long patientNationalId;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private HospitalDepartment department;

    @Column(name = "prescriptionDateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime prescriptionDateTime;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "notes")
    private String notes;
}
