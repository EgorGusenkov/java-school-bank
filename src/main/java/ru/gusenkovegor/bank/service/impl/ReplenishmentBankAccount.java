package ru.gusenkovegor.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gusenkovegor.bank.domain.BankAccount;
import ru.gusenkovegor.bank.repos.BankAccountRepo;
import ru.gusenkovegor.bank.service.Replenishment;

import javax.validation.constraints.Size;
import java.util.NoSuchElementException;

@Service
public class ReplenishmentBankAccount implements Replenishment {
    @Autowired
    BankAccountRepo bankAccountRepo;

    @Autowired
    CommissionForReplenishment commissionForReplenishment;

    @Override
    public void deposit(Long bankAccountId, @Size(min = 0, max = 50000) double sum) {
        BankAccount bankAccount = bankAccountRepo.findById(bankAccountId)
                .orElseThrow(() -> new NoSuchElementException("bank account with ID: " + bankAccountId + "not found"));
        bankAccount.setSum(bankAccount.getSum() + commissionForReplenishment.rob(sum));
        bankAccountRepo.save(bankAccount);
    }
}
