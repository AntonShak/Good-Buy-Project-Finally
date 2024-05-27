package com.shakov.goodbuyproject.integrartion;

import com.shakov.goodbuyproject.integrartion.annotation.IT;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@IT
@Testcontainers
@Sql({
        "classpath:sql/data.sql"
})
public class IntegrationTestBase {

    @Container
    private static final PostgreSQLContainer<?>
            container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.3"));

    @BeforeAll
    static void containerRun() {
        container.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }
}