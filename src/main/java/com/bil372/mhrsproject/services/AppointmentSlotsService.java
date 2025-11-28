package com.bil372.mhrsproject.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bil372.mhrsproject.entities.AppointmentSlot;
import com.bil372.mhrsproject.entities.Hospital;
import com.bil372.mhrsproject.entities.HospitalDepartment;
import com.bil372.mhrsproject.repositories.AppointmentSlotsRepository;

@Service
public class AppointmentSlotsService {
    
    private final AppointmentSlotsRepository aSlotsRepository;

    public AppointmentSlotsService(AppointmentSlotsRepository aSlotsRepository){
        this.aSlotsRepository = aSlotsRepository;
    }

    public List<AppointmentSlot> getDoctorAppointmentSlots(long doctorNationalId){
        List<AppointmentSlot> aSlots = aSlotsRepository.findByDoctor_DoctorNationalId(doctorNationalId);
        return aSlots;
    }
    
    public List<AppointmentSlot> getPatientAppointmentSlots(long patientNationalId){
        List<AppointmentSlot> aSlots = aSlotsRepository.findByPatient_PatientNationalId(patientNationalId);
        return aSlots;
    }

    public List<AppointmentSlot> getHospitalAndDepartmentSlots(Hospital hospital, HospitalDepartment hospitalDepartment){
        List<AppointmentSlot> aSlots = aSlotsRepository.findByHospitalAndDepartment(hospital, hospitalDepartment);
        return aSlots;
    }

    public List<AppointmentSlot> getHospitalAndDepartmentAndSlotDateTime(Hospital hospital,  HospitalDepartment hospitalDepartment, LocalDateTime dateTime){
        List<AppointmentSlot> aSlots = aSlotsRepository.findByHospitalAndDepartmentAndSlotDateTime(hospital, hospitalDepartment, dateTime);
        return aSlots;
    }
}
