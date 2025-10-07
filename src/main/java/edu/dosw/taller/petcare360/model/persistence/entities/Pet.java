package edu.dosw.taller.petcare360.model.persistence.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String id;
    private String name;
    private String breed;
    private int age;
    private MedicalHistory medicalHistory;
    private Client owner;
}