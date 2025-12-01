package com.bil372.mhrsproject.DTOs.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.bil372.mhrsproject.DTOs.DoctorPastAppointmentDTO;
import com.bil372.mhrsproject.entities.AppointmentSlot;
import com.bil372.mhrsproject.entities.Patient;
import com.bil372.mhrsproject.entities.Prescription;

public class DoctorPastAppointmentMapper {

    public static DoctorPastAppointmentDTO toPastDTO(AppointmentSlot slot) {
        DoctorPastAppointmentDTO dto = new DoctorPastAppointmentDTO();

        // appointment basic
        dto.setId(slot.getAppointmentId());
        dto.setDateTime(slot.getSlotDateTime());

        // patient
        Patient patient = slot.getPatient();
        if (patient != null) {
            dto.setPatientFirstName(patient.getFirstName());
            dto.setPatientLastName(patient.getLastName());
        }

        // prescription (one-to-many -> take first)
        List<Prescription> prescriptions = slot.getAppointmentPrescriptions();
        if (prescriptions != null && !prescriptions.isEmpty()) {
            Prescription p = prescriptions.get(0);
            dto.setPrescriptionText(p.getDiagnosis() + "\n" + p.getNotes());  // field name neyse onu yaz
        } else {
            dto.setPrescriptionText("");
        }

        return dto;
    }

    public static List<DoctorPastAppointmentDTO> toPastDTOList(List<AppointmentSlot> slots) {
        return slots.stream()
                .map(DoctorPastAppointmentMapper::toPastDTO)
                .collect(Collectors.toList());
    }
}
