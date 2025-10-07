package edu.dosw.taller.petcare360.controller.dtos;

import edu.dosw.taller.petcare360.model.persistence.entities.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDTO {
    private String id;
    private String petName;
    private String veterinarianName;
    private LocalDateTime dateTime;
    private String reason;
    private AppointmentStatus status;
}