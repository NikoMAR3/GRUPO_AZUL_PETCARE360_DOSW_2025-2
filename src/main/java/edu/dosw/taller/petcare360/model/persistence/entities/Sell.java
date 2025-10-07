package edu.dosw.taller.petcare360.model.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Sell {
    protected String name;
    protected BigDecimal price;

    public abstract ReceiptItem generateReceiptItem();
}