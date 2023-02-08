package com.axiatadigitallabs.telco.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements SuperEntity{

    @Id
    @Column(name = "account_number")
    private int accountNumber;
    @Column(nullable = false, name = "customer_name")
    private String customerName;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private BigDecimal balance;

}
