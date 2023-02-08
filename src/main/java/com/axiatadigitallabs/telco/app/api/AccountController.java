package com.axiatadigitallabs.telco.app.api;

import com.axiatadigitallabs.telco.app.dto.AccountDTO;
import com.axiatadigitallabs.telco.app.dto.TransactionDTO;
import com.axiatadigitallabs.telco.app.service.custom.AccountService;
import com.axiatadigitallabs.telco.app.util.ValidationGroups;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@CrossOrigin
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerAccount(@Validated(ValidationGroups.Create.class)
                                      @RequestBody AccountDTO accountDTO){
        accountService.createNewCustomerAccount(accountDTO);
    }

}
