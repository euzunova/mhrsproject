package com.bil372.mhrsproject.services;

import com.bil372.mhrsproject.entities.waitingList;
import com.bil372.mhrsproject.repositories.waitingListRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class waitingListService {
    //buyuk harfli W olan obje, digeri class
    private final waitingListRepository WaitingListRepository;

    public waitingListService(waitingListRepository waitingListRepository){
        this.WaitingListRepository = waitingListRepository;
    }

    public List<waitingList> getDoctorWaitingList(long doctorNationalId){
        System.out.println("Doctor ID = " + doctorNationalId);
        List<waitingList> result = WaitingListRepository.findBydoctorNationalId(doctorNationalId);
        System.out.println("Result size = " + (result == null ? "null" : result.size()));
        return result;
    }

    public List<waitingList> getPatientWaitingList(long patientNationalId){
        return WaitingListRepository.findBypatientNationalId(patientNationalId);
    }

}
