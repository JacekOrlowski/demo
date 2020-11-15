package com.apress.cems.impl.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class JdbcDbConfig {

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder           // builder pattern
                .setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .addScript("db/schema.sql")
                .addScript("db/test-data.sql")
                .build();

        return db;
    }

    @Bean
    public JdbcTemplate jdbTemplate() throws ClassNotFoundException {
        return new JdbcTemplate(dataSource());
    }
}
