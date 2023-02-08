package com.axiatadigitallabs.telco.app.api;

import com.axiatadigitallabs.telco.app.dto.AccountDTO;
import com.axiatadigitallabs.telco.app.dto.TransactionDTO;
import com.axiatadigitallabs.telco.app.service.custom.TransactionService;
import com.axiatadigitallabs.telco.app.util.ValidationGroups;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PatchMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccountBalance(
//            @AuthenticationPrincipal(expression = "username")String username,
            @RequestBody @Validated(ValidationGroups.Update.class) TransactionDTO transactionDTO
    ){
        transactionService.updateAccountBalance(transactionDTO);
    }
}
