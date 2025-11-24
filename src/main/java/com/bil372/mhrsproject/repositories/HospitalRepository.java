package com.bil372.mhrsproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bil372.mhrsproject.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    //hastaneyi id ile bulmak
    Optional<Hospital> findByHospitalId(int hospitalId);

    //o sehirdeki tum hastaneler
    List<Hospital> findByCity(String city);

    //o sehirdeki ve ilcedeki tum hastaneler
    List<Hospital> findByCityAndDistrict(String city, String district);

}