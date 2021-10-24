package ru.gusenkovegor.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gusenkovegor.bank.domain.BankAccount;
import ru.gusenkovegor.bank.repos.BankAccountRepo;
import ru.gusenkovegor.bank.service.Withdrawal;

import javax.validation.constraints.Size;
import java.util.NoSuchElementException;

@Service
public class WithdrawalBankAccount implements Withdrawal {
    @Autowired
    BankAccountRepo bankAccountRepo;

    @Autowired
    CommissionForWithdrawal commissionForWithdrawal;

    @Override
    public void withdraw(Long bankAccountId, @Size(min = 0, max = 50000) double sum) {
        BankAccount bankAccount = bankAccountRepo.findById(bankAccountId)
                .orElseThrow(() -> new NoSuchElementException("bank account with ID: " + bankAccountId + "not found"));
        bankAccount.setSum(bankAccount.getSum() - commissionForWithdrawal.rob(sum));
        bankAccountRepo.save(bankAccount);
    }
}
