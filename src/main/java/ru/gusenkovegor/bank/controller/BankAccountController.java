package ru.gusenkovegor.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gusenkovegor.bank.domain.BankAccount;
import ru.gusenkovegor.bank.domain.Owner;
import ru.gusenkovegor.bank.repos.BankAccountRepo;
import ru.gusenkovegor.bank.repos.OwnerRepo;
import ru.gusenkovegor.bank.service.Replenishment;
import ru.gusenkovegor.bank.service.Withdrawal;

import java.util.Map;

@Controller
public class BankAccountController {
    @Autowired
    BankAccountRepo bankAccountRepo;

    @Autowired
    OwnerRepo ownerRepo;

    @Autowired
    Replenishment replenishment;

    @Autowired
    Withdrawal withdrawal;

    @GetMapping("/bankAccounts")
    public String bankAccounts(Map<String, Object> model) {
        Iterable<Owner> owners = ownerRepo.findAll();
        model.put("owners", owners);

        Iterable<BankAccount> bankAccounts = bankAccountRepo.findAll();
        model.put("bankAccounts", bankAccounts);
        return "bankAccounts";
    }

    @PostMapping("add_owner")
    public String addOwner(
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String middleName) {
        Owner owner = new Owner(lastName, firstName, middleName);

        ownerRepo.save(owner);

        return "redirect:/bankAccounts";
    }

    @PostMapping("add_bank_account")
    public String addBankAccount(
            @RequestParam double sum,
            @RequestParam Long ownerId) {
        BankAccount bankAccount = new BankAccount(ownerRepo.findById(ownerId).get(), sum);

        bankAccountRepo.save(bankAccount);

        return "redirect:/bankAccounts";
    }

    @PostMapping("replenishment_bank_account")
    public String ReplenishmentBankAccount(
            @RequestParam Long bankAccountId,
            @RequestParam double sum) {

        replenishment.deposit(bankAccountId, sum);

        return "redirect:/bankAccounts";
    }

    @PostMapping("withdrawal_bank_account")
    public String WithdrawalBankAccount(
            @RequestParam Long bankAccountId,
            @RequestParam double sum) {

        withdrawal.withdraw(bankAccountId, sum);

        return "redirect:/bankAccounts";
    }
}
