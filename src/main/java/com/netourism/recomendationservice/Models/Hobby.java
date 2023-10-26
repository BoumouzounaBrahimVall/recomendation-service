package com.netourism.recomendationservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hobby {
    @Id
    @GeneratedValue
    private Long Id;
    private String title;
    @Relationship(type="practice",direction = Relationship.Direction.INCOMING)
    //users with the hobby
    private List<User> practicers;
}
