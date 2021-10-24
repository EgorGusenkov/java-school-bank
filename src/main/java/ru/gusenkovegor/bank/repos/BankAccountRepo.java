package ru.gusenkovegor.bank.repos;

import org.springframework.data.repository.CrudRepository;
import ru.gusenkovegor.bank.domain.BankAccount;

public interface BankAccountRepo extends CrudRepository<BankAccount, Long> {
}
