package com.axiatadigitallabs.telco.app.service.custom;

import com.axiatadigitallabs.telco.app.dto.AccountDTO;
import com.axiatadigitallabs.telco.app.service.SuperService;

public interface AccountService extends SuperService {

    void createNewCustomerAccount(AccountDTO accountDTO);

}
