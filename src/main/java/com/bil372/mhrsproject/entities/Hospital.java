package com.bil372.mhrsproject.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "hospitals")
@Entity
public class Hospital {
    @JsonManagedReference
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<HospitalDepartment> hospitalDepartments;

    @Id
    @Column(name = "hospitalId")
    private int hospitalId;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "phoneNumber")
    private String phoneNumber;
}
