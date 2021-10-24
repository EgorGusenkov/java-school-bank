package ru.gusenkovegor.bank.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(0)
    private double sum;

    public BankAccount(Owner owner, double sum) {
        this.owner = owner;
        this.sum = sum;
    }

    public String getLastName() {
        return owner != null ? owner.getLastName() : "<none>";
    }

    public Long getOwnerId() {
        return owner != null ? owner.getId() : 0;
    }
}
