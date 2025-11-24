package com.bil372.mhrsproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bil372.mhrsproject.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //doctoru id ile bulmak
    Optional<Doctor> findByDoctorNationalId(long doctorNationalId);

    // Hastaneye göre doktor listesi
    List<Doctor> findByHospitalId(int hospitalId);

    // Departmana göre doktor listesi
    List<Doctor> findByHospitalAndDepartmentId(int hospitalId,int departmentId);
}

