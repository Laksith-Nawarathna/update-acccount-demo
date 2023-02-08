package com.axiatadigitallabs.telco.app.service.custom.impl;

import com.axiatadigitallabs.telco.app.dto.AccountDTO;
import com.axiatadigitallabs.telco.app.repository.AccountRepository;
import com.axiatadigitallabs.telco.app.service.custom.AccountService;
import com.axiatadigitallabs.telco.app.util.Transformer;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final Transformer transformer;

    public AccountServiceImpl(AccountRepository accountRepository, Transformer transformer) {
        this.accountRepository = accountRepository;
        this.transformer = transformer;
    }

    @Override
    public void createNewCustomerAccount(AccountDTO accountDTO) {
        accountDTO.setPassword(DigestUtils.sha256Hex(accountDTO.getPassword()));
        accountRepository.save(transformer.toAccount(accountDTO));
    }
}
