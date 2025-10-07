package edu.dosw.taller.petcare360.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDTO {
    private String petId;
    private String veterinarianId;
    private LocalDateTime dateTime;
    private String reason;
}
