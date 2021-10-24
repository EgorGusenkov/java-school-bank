package ru.gusenkovegor.bank.repos;

import org.springframework.data.repository.CrudRepository;
import ru.gusenkovegor.bank.domain.Owner;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
}
