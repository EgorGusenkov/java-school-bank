package ru.gusenkovegor.bank.service;

public interface Replenishment {
    public void deposit(Long bankAccountId, double sum);
}
