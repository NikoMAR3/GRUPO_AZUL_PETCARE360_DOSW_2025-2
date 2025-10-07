package edu.dosw.taller.petcare360.model.services;

import edu.dosw.taller.petcare360.controller.dtos.AppointmentRequestDTO;
import edu.dosw.taller.petcare360.controller.dtos.AppointmentResponseDTO;
import edu.dosw.taller.petcare360.model.persistence.entities.Appointment;
import edu.dosw.taller.petcare360.model.persistence.entities.AppointmentStatus;
import edu.dosw.taller.petcare360.model.persistence.entities.Pet;
import edu.dosw.taller.petcare360.model.persistence.entities.Veterinarian;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final Map<String, Appointment> appointments = new HashMap<>();
    private long sequenceId = 1L;
    private final Map<String, Pet> pets = new HashMap<>();
    private final Map<String, Veterinarian> veterinarians = new HashMap<>();

    @Override
    public AppointmentResponseDTO scheduleAppointment(AppointmentRequestDTO dto) {
        Pet pet = pets.get(dto.getPetId());
        if (pet == null) throw new IllegalArgumentException("Pet not found");

        Veterinarian vet = veterinarians.get(dto.getVeterinarianId());
        if (vet == null) throw new IllegalArgumentException("Veterinarian not found");

        // validate vet availability
        for (Appointment a : appointments.values()) {
            if (a.getVeterinarian().getId().equals(vet.getId())
                    && a.getDateTime().equals(dto.getDateTime())
                    && a.getStatus() == AppointmentStatus.SCHEDULED) {
                throw new IllegalStateException("Veterinarian not available at this time");
            }
        }

        Appointment appointment = new Appointment();
        appointment.setId(String.valueOf(sequenceId++));
        appointment.setPet(pet);
        appointment.setVeterinarian(vet);
        appointment.setDateTime(dto.getDateTime());
        appointment.setReason(dto.getReason());
        appointment.setStatus(AppointmentStatus.SCHEDULED);

        appointments.put(appointment.getId(), appointment);

        return toResponseDTO(appointment);
    }

    @Override
    public Optional<AppointmentResponseDTO> getAppointment(String id) {
        return Optional.ofNullable(appointments.get(id)).map(this::toResponseDTO);
    }

    @Override
    public void cancelAppointment(String id) {
        Appointment appointment = appointments.get(id);
        if (appointment != null) {
            appointment.setStatus(AppointmentStatus.CANCELLED);
        }
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByVeterinarian(String veterinarianId) {
        List<AppointmentResponseDTO> result = new ArrayList<>();
        for (Appointment a : appointments.values()) {
            if (a.getVeterinarian().getId().equals(veterinarianId)) {
                result.add(toResponseDTO(a));
            }
        }
        return result;
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPet(String petId) {
        List<AppointmentResponseDTO> result = new ArrayList<>();
        for (Appointment a : appointments.values()) {
            if (a.getPet().getId().equals(petId)) {
                result.add(toResponseDTO(a));
            }
        }
        return result;
    }

    private AppointmentResponseDTO toResponseDTO(Appointment appointment) {
        return new AppointmentResponseDTO(
                appointment.getId(),
                appointment.getPet().getName(),
                appointment.getVeterinarian().getName(),
                appointment.getDateTime(),
                appointment.getReason(),
                appointment.getStatus()
        );
    }
}
