package edu.dosw.taller.petcare360.model.persistence.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Veterinarian {
    private String id;
    private String name;
    private String specialty;
}