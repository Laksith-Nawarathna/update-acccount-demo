package com.axiatadigitallabs.telco.app.dto;

import com.axiatadigitallabs.telco.app.util.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO implements Serializable {

    @Null(groups = ValidationGroups.Create.class, message = "Account number cannot be specified")
    private Integer accountNumber;
    @NotBlank(message = "Transaction type cannot be empty or null")
    private String type;
//    @NotBlank(message = "Transaction amount cannot be null or empty")
    private BigDecimal amount;

}
