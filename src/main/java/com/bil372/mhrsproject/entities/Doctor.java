package com.bil372.mhrsproject.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("unused")
@Data
@Table(name= "doctors")
@Entity
public class Doctor {
    @Id
    @Column(name = "doctorNationalId")
    private long doctorNationalId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @Column(name = "departmentId")
    private int departmentId;
    
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<WaitingList> waitingLists;
}
