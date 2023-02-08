package com.axiatadigitallabs.telco.app.service.custom;

import com.axiatadigitallabs.telco.app.dto.TransactionDTO;
import com.axiatadigitallabs.telco.app.service.SuperService;

public interface TransactionService extends SuperService {

    void updateAccountBalance(TransactionDTO transactionDTO);

}
