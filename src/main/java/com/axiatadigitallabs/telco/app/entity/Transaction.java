package com.axiatadigitallabs.telco.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements SuperEntity{

    @Id
    @Column(name = "account_number")
    private int accountNumber;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private BigDecimal amount;
}
