package edu.dosw.taller.petcare360.model.services;

import edu.dosw.taller.petcare360.model.persistence.entities.Appointment;
import edu.dosw.taller.petcare360.model.persistence.entities.AppointmentStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();
    private long sequenceId = 1L; //como todavia no podemos usar persistencia como tal pipipipipi

    @Override
    public Appointment scheduleAppointment(Appointment appointment) {
        for (Appointment a : appointments.values()) {
            if (a.getVeterinarian().getId().equals(appointment.getVeterinarian().getId())
                    && a.getDateTime().equals(appointment.getDateTime())
                    && a.getStatus() == AppointmentStatus.SCHEDULED) {
                throw new IllegalStateException("Veterinarian is not available at this time");
            }
        }
        appointment.setId(String.valueOf(sequenceId++));
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    @Override
    public Optional<Appointment> getAppointment(String id) {
        return Optional.ofNullable(appointments.get(id));
    }

    @Override
    public void cancelAppointment(String id) {
        Appointment appointment = appointments.get(id);
        if (appointment != null) {
            appointment.setStatus(AppointmentStatus.CANCELLED);
        }
    }

    @Override
    public List<Appointment> getAppointmentsByVeterinarian(String veterinarianId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments.values()) {
            if (a.getVeterinarian().getId().equals(veterinarianId)) {
                result.add(a);
            }
        }
        return result;
    }

    @Override
    public List<Appointment> getAppointmentsByPet(String petId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments.values()) {
            if (a.getPet().getId().equals(petId)) {
                result.add(a);
            }
        }
        return result;
    }
}