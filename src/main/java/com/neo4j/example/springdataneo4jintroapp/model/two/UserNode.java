package com.neo4j.example.springdataneo4jintroapp.model.two;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NodeEntity
@SuperBuilder
@NoArgsConstructor
public class UserNode extends BaseNode {
    private String name;
}
