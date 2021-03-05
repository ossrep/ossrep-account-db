package com.ossrep.account;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class MigrationTest {

    @Test
    public void migrate() {
        try (PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(System.getProperty("postgresql.image"))) {
            postgres.start();
            Flyway flyway = Flyway.configure().dataSource(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword()).load();
            flyway.migrate();
        }
    }

}
