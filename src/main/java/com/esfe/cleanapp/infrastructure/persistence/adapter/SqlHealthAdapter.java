package com.esfe.cleanapp.infrastructure.persistence.adapter;

import com.esfe.cleanapp.domain.port.out.SqlHealthPort;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class SqlHealthAdapter implements SqlHealthPort {
    private final DataSource dataSource;
    public SqlHealthAdapter(DataSource ds){ this.dataSource = ds; }
    @Override public boolean ping() throws Exception {
        try (Connection c = dataSource.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT 1")) {
            return rs.next() && rs.getInt(1) == 1;
        }
    }
}
