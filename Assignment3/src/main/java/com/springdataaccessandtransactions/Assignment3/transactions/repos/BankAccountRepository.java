package com.springdataaccessandtransactions.Assignment3.transactions.repos;

import com.springdataaccessandtransactions.Assignment3.transactions.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount,Integer> {
}
