package com.axiatadigitallabs.telco.app.repository;

import com.axiatadigitallabs.telco.app.entity.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

//    @Query(value = "update Account set balance = balance + ?1 where a=?2")
    @Modifying
    @Query(value = "update Account set balance = balance + ?1 where accountNumber=?2")
    void depositUpdate(BigDecimal amount, Integer accountNUmber);

    @Modifying
    @Query(value = "update Account set balance = balance - ?1 where accountNumber=?2")
    void withdrawUpdate(BigDecimal amount, Integer accountNUmber);

}
