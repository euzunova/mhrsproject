package com.bil372.mhrsproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bil372.mhrsproject.entities.waitingList;

public interface waitingListRepository extends JpaRepository<waitingList,Integer>{

    List<waitingList> findByDoctorId(long doctorNationalId);

    List<waitingList> findByPatientId(long patientNationalId);
}
