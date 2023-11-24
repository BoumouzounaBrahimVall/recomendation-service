package com.netourism.recomendationservice.Repositories;

import com.netourism.recomendationservice.Models.Hobby;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface HobbyRepository extends Neo4jRepository<Hobby,Long> {
    Hobby findByTitle(String title);
    Boolean existsByTitle(String title);
    @Query("MATCH (u:User {userId: $userId})-[:practice]->(h:Hobby) RETURN h")
    List<Hobby> findHobbiesByUserId(Long userId);
}
