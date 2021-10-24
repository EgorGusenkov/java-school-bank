package ru.gusenkovegor.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gusenkovegor.bank.config.properties.CommissionProperties;
import ru.gusenkovegor.bank.service.Commission;

@Service
public class CommissionForWithdrawal implements Commission {
    @Autowired
    CommissionProperties commissionProperties;

    @Override
    public double rob(double sum) {
        if (sum > 10000) {
            return sum * (100 - commissionProperties.getWithdrawal()) / 100;
        }
        return sum;
    }
}
