package com.bil372.mhrsproject.DTOs.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.bil372.mhrsproject.DTOs.PrescriptionsDTO;
import com.bil372.mhrsproject.DTOs.PrescriptionDrugDTO;
import com.bil372.mhrsproject.entities.Prescription;
import com.bil372.mhrsproject.entities.PrescriptionDrugs;

public class PrescriptionMapper {

    public static PrescriptionsDTO toDTO(Prescription p) {
        PrescriptionsDTO dto = new PrescriptionsDTO();

        // Basic
        dto.setPrescriptionId(p.getPrescriptionId());
        dto.setPrescriptionDateTime(p.getPrescriptionDateTime());
        dto.setDiagnosis(p.getDiagnosis());
        dto.setNotes(p.getNotes());

        // Doctor
        if (p.getDoctor() != null) {
            dto.setDoctorNationalId(p.getDoctor().getDoctorNationalId());
            dto.setDoctorFirstName(p.getDoctor().getFirstName());
            dto.setDoctorLastName(p.getDoctor().getLastName());
        }

        // Patient
        if (p.getPatient() != null) {
            dto.setPatientNationalId(p.getPatient().getPatientNationalId());
            dto.setPatientFirstName(p.getPatient().getFirstName());
            dto.setPatientLastName(p.getPatient().getLastName());
        }

        // Hospital
        if (p.getHospital() != null) {
            dto.setHospitalId(p.getHospital().getHospitalId());
            dto.setHospitalName(p.getHospital().getName());
            dto.setHospitalCity(p.getHospital().getCity());
        }

        // Department
        if (p.getDepartment() != null) {
            dto.setDepartmentId(p.getDepartment().getDepartmentId());
            dto.setDepartmentName(p.getDepartment().getBranchName());
        }

        // AppointmentSlot
        if (p.getAppointmentSlot() != null) {
            dto.setAppointmentId(p.getAppointmentSlot().getAppointmentId());
            dto.setAppointmentSlotDateTime(p.getAppointmentSlot().getSlotDateTime());
        }

        // Drugs
        if (p.getPrescribedDrugs() != null) {
            dto.setDrugs(
                    p.getPrescribedDrugs().stream()
                            .map(PrescriptionMapper::mapDrug)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    private static PrescriptionDrugDTO mapDrug(PrescriptionDrugs d) {
        PrescriptionDrugDTO dto = new PrescriptionDrugDTO();
        dto.setPrescriptionDrugId(d.getPrescriptionDrugId());
        dto.setDrugName(d.getDrugName());
        dto.setDosage(d.getDosage());
        dto.setRoute(d.getRoute());
        dto.setFrequency(d.getFrequency());
        dto.setDurationDays(d.getDurationDays());
        dto.setInstructions(d.getInstructions());
        return dto;
    }

    public static List<PrescriptionsDTO> toDTOList(List<Prescription> list) {
        return list.stream()
                .map(PrescriptionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
