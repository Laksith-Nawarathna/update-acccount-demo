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
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "password", allowSetters = true)
public class AccountDTO implements Serializable {

    @Null(groups = ValidationGroups.Create.class, message = "Account number cannot be specified")
    private Integer accountNumber;
    @NotBlank(message = "Customer name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid customer name")
    private String customerName;
    @NotBlank(message = "username cannot be empty or null")
    private String username;
    @NotEmpty(message = "password cannot be empty or null")
    @Length(min = 5, message = "Password must contain at least 5 characters")
    private String password;
//    @NotBlank(message = "Account balance cannot be null or empty")
    private BigDecimal balance;

}
