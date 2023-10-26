package com.netourism.recomendationservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit créerProduit(String nom, double prix) {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setPrix(prix);
        return produitRepository.save(produit);
    }

    public Produit trouverProduitParNom(String nom) {
        return produitRepository.findByNom(nom);
    }

    public Iterable<Produit> tousLesProduits() {
        return produitRepository.findAll();
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }

    // Ajoutez d'autres méthodes de service pour les opérations de mise à jour si nécessaire
}
