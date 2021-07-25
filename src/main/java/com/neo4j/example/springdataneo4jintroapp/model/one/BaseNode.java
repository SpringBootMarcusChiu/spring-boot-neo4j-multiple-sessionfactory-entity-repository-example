package com.neo4j.example.springdataneo4jintroapp.model.one;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.id.UuidStrategy;

@Data
@NodeEntity
@SuperBuilder
@NoArgsConstructor
public class BaseNode {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String uuid;
}
