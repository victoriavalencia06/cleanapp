package com.esfe.cleanapp.application.usercase;

import com.esfe.cleanapp.domain.port.in.CheckDbHealthUseCase;
import com.esfe.cleanapp.domain.port.out.SqlHealthPort;

public class CheckDbHealthService implements CheckDbHealthUseCase {
    private final SqlHealthPort sql;
    public CheckDbHealthService(SqlHealthPort sql){
        this.sql = sql;
    }

    @Override
    public boolean isHealthy()
    {
        try {
            return sql.ping();
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
