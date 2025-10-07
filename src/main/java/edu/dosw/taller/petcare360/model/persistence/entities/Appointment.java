package edu.dosw.taller.petcare360.model.persistence.entities;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends Service{
    private String id;
    private Pet pet;
    private Veterinarian veterinarian;
    private LocalDateTime dateTime;
    private String reason;
    private AppointmentStatus status;

    @Override
    public ReceiptItem generateReceiptItem() {
        return new ReceiptItem(
                "Appointment with Dr. " + veterinarian.getName() + " for " + pet.getName(),
                getPrice()
        );
    }
}

