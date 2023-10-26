package com.netourism.recomendationservice.Repositories;

import com.netourism.recomendationservice.Models.Produit;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends Neo4jRepository<Produit, Long> {
    Produit findByNom(String nom);
    // Ajoutez d'autres méthodes de requête si nécessaire
}
