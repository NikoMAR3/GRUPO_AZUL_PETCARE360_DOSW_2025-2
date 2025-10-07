package edu.dosw.taller.petcare360.model.services;

import edu.dosw.taller.petcare360.controller.dtos.AppointmentRequestDTO;
import edu.dosw.taller.petcare360.controller.dtos.AppointmentResponseDTO;
import edu.dosw.taller.petcare360.model.persistence.entities.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    AppointmentResponseDTO scheduleAppointment(AppointmentRequestDTO dto);
    Optional<AppointmentResponseDTO> getAppointment(String id);
    void cancelAppointment(String id);
    List<AppointmentResponseDTO> getAppointmentsByVeterinarian(String veterinarianId);
    List<AppointmentResponseDTO> getAppointmentsByPet(String petId);
}