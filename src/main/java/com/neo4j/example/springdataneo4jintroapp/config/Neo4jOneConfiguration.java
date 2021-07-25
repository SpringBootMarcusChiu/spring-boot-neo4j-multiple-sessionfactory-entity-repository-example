package com.neo4j.example.springdataneo4jintroapp.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@EnableNeo4jRepositories(
        transactionManagerRef = "transactionManagerOne",
        sessionFactoryRef = "sessionFactoryOne",
        basePackages = "com.neo4j.example.springdataneo4jintroapp.repo.one")
@EntityScan(basePackages = Neo4jOneConfiguration.MODEL_PACKAGE)
@org.springframework.context.annotation.Configuration
public class Neo4jOneConfiguration {

    protected static final String MODEL_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.model.one";

    @Primary
    @Bean
    @ConfigurationProperties("spring.data.neo4j")
    public Neo4jProperties myNeo4jProperties() {
        return new Neo4jProperties();
    }

    @Primary
    @Bean
    public org.neo4j.ogm.config.Configuration configurationOne() {
        return myNeo4jProperties().createConfiguration();
    }

    @Primary
    @Bean
    public SessionFactory sessionFactoryOne() {
        return new SessionFactory(configurationOne(), MODEL_PACKAGE);
    }

    @Bean
    public Neo4jTransactionManager transactionManagerOne() {
        return new Neo4jTransactionManager(sessionFactoryOne());
    }
}
