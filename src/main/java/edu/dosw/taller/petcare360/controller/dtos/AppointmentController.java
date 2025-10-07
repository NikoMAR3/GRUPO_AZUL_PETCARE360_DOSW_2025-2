package edu.dosw.taller.petcare360.controller.dtos;

import edu.dosw.taller.petcare360.model.services.AppointmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // POST
    @PostMapping
    public AppointmentResponseDTO schedule(@RequestBody AppointmentRequestDTO dto) {
        return appointmentService.scheduleAppointment(dto);
    }

    // GET
    @GetMapping("/{id}")
    public AppointmentResponseDTO get(@PathVariable String id) {
        Optional<AppointmentResponseDTO> opt = appointmentService.getAppointment(id);
        return opt.orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void cancel(@PathVariable String id) {
        appointmentService.cancelAppointment(id);
    }

    // GET
    @GetMapping("/veterinarios/{id}")
    public List<AppointmentResponseDTO> getByVeterinarian(@PathVariable String id) {
        return appointmentService.getAppointmentsByVeterinarian(id);
    }

    // GET
    @GetMapping("/mascotas/{id}")
    public List<AppointmentResponseDTO> getByPet(@PathVariable String id) {
        return appointmentService.getAppointmentsByPet(id);
    }
}