package com.bil372.mhrsproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "hospital_departments")
@Entity
public class HospitalDepartment {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @Id
    @Column(name = "departmentId")
    private int departmentId;

    @Column(name = "branchName")
    private String branchName;
}
