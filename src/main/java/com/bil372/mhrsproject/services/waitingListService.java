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

    public List<waitingList> getDoctorWaitingList(long docId){
        return WaitingListRepository.findByDoctorId(docId);
    }

    public List<waitingList> getPatientWaitingList(long patientId){
        return WaitingListRepository.findByPatientId(patientId);
    }

}
