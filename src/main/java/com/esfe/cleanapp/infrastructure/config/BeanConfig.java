package com.esfe.cleanapp.infrastructure.config;

import com.esfe.cleanapp.application.usercase.CheckDbHealthService;
import com.esfe.cleanapp.domain.port.in.CheckDbHealthUseCase;
import com.esfe.cleanapp.domain.port.out.SqlHealthPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    CheckDbHealthUseCase checkDbHealthUseCase(SqlHealthPort port){
        return new CheckDbHealthService(port);
    }
}
