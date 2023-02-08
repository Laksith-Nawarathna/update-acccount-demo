package com.axiatadigitallabs.telco.app.repository;

import com.axiatadigitallabs.telco.app.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
