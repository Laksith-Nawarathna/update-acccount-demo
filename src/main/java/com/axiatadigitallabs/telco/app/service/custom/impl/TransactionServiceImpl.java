package com.axiatadigitallabs.telco.app.service.custom.impl;

import com.axiatadigitallabs.telco.app.dto.TransactionDTO;
import com.axiatadigitallabs.telco.app.repository.AccountRepository;
import com.axiatadigitallabs.telco.app.repository.TransactionRepository;
import com.axiatadigitallabs.telco.app.service.custom.TransactionService;
import com.axiatadigitallabs.telco.app.util.Transformer;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final Transformer transformer;
    private final BigDecimal minimumBalance = new BigDecimal(100);

    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository, Transformer transformer) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.transformer = transformer;
    }

    @Override
    public void updateAccountBalance(TransactionDTO transactionDTO) {
        if(transactionDTO.getType().equalsIgnoreCase("deposit")){
            transactionRepository.depositUpdate(transactionDTO.getAmount(), transactionDTO.getAccountNumber());
        } else if (transactionDTO.getType().equalsIgnoreCase("withdraw")) {
            if(transactionDTO.getAmount().compareTo(minimumBalance) < 0){
                throw new RuntimeException("Insufficient account balance");
            }
            transactionRepository.withdrawUpdate(transactionDTO.getAmount(), transactionDTO.getAccountNumber());
        }else{
            throw new RuntimeException("Invalid Transaction Type");
        }
    }

}
