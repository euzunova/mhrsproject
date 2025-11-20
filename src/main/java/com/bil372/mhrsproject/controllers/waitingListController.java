package com.bil372.mhrsproject.controllers;

import com.bil372.mhrsproject.entities.waitingList;
import com.bil372.mhrsproject.services.waitingListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController //rest api oldugunu ve json donecegini belirtir
@RequestMapping("/api/waiting-list") //donecek her seyin urlsi /api/waiting-list/... olur
public class waitingListController {
    private final waitingListService waitingListService;

    public waitingListController(waitingListService waitingListService){
        this.waitingListService = waitingListService;
    }

    @GetMapping("/doctor/{doctorId}") //GET istegi httpden
    public List<waitingList> getDoctorWaitingList(@PathVariable long doctorId) {
        return waitingListService.getDoctorWaitingList(doctorId);
    }
    
    @GetMapping("/patient/{tc}")
    public List<waitingList> getPatientWaitingList(@PathVariable long tc) {
        return waitingListService.getPatientWaitingList(tc);
    }
}
