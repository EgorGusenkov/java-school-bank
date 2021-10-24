package ru.gusenkovegor.bank.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Configuration
@ConfigurationProperties(prefix = "commission")
@Validated
@Getter
@Setter
public class CommissionProperties {
    @Size(min = 0, max = 100)
    float replenishment;
    @Size(min = 0, max = 100)
    float withdrawal;
}
