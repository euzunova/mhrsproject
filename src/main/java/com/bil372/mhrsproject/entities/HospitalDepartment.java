package com.bil372.mhrsproject.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "hospital_departments")
@Entity
public class HospitalDepartment {

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Prescriptions> departmentPrescriptions;

    @Id
    @Column(name = "departmentId")
    private int departmentId;

    @Column(name = "branchName")
    private String branchName;
}
