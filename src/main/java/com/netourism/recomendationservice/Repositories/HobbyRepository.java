package com.netourism.recomendationservice.Repositories;

import com.netourism.recomendationservice.Models.Hobby;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HobbyRepository extends Neo4jRepository<Hobby,Long> {
}
