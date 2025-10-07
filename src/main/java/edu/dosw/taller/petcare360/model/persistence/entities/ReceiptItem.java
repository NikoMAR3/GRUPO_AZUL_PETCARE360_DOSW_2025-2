package edu.dosw.taller.petcare360.model.persistence.entities;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptItem {
    private String description;
    private BigDecimal subtotal;
}