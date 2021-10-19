package com.springdataaccessandtransactions.Assignment3.transactions.services;

import com.springdataaccessandtransactions.Assignment3.transactions.entities.BankAccount;
import com.springdataaccessandtransactions.Assignment3.transactions.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    @Transactional    //if exception occurs, everything will be rollbacked, nothing will be committed
    public void transfer(int amount) {
        BankAccount vaishaliAccount = bankAccountRepository.findById(1).get();
        vaishaliAccount.setBal(vaishaliAccount.getBal() - amount);
        bankAccountRepository.save(vaishaliAccount);

       if (true){
            throw new RuntimeException();
        }

        BankAccount nidhiAccount = bankAccountRepository.findById(2).get();
        nidhiAccount.setBal(nidhiAccount.getBal() + amount);
        bankAccountRepository.save(nidhiAccount);
    }
}
