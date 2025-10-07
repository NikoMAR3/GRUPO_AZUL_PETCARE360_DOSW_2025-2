package edu.dosw.taller.petcare360.model.services;

import edu.dosw.taller.petcare360.model.persistence.entities.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    public Appointment scheduleAppointment(Appointment appointment);
    public Optional<Appointment> getAppointment(String id);
    public void cancelAppointment(String id);
    public List<Appointment> getAppointmentsByVeterinarian(String veterinarianId);
    public List<Appointment> getAppointmentsByPet(String petId);
}
