package ru.gusenkovegor.bank.service;

public interface Withdrawal {
    public void withdraw(Long bankAccountId, double sum);
}
