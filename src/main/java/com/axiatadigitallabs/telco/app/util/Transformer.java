package com.axiatadigitallabs.telco.app.util;

import com.axiatadigitallabs.telco.app.dto.AccountDTO;
import com.axiatadigitallabs.telco.app.dto.TransactionDTO;
import com.axiatadigitallabs.telco.app.entity.Account;
import com.axiatadigitallabs.telco.app.entity.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Transaction toTransaction(TransactionDTO transactionDTO){
        return mapper.map(transactionDTO, Transaction.class);
    }

    public TransactionDTO toTransactionDTO(Transaction transaction){
        return mapper.map(transaction, TransactionDTO.class);
    }

    public Account toAccount(AccountDTO accountDTO){
        return mapper.map(accountDTO, Account.class);
    }

    public AccountDTO toAccountDTO(Account account){
        return mapper.map(account, AccountDTO.class);
    }
}
