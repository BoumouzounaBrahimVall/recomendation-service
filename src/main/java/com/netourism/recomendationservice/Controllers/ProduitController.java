package com.netourism.recomendationservice.Controllers;

import com.netourism.recomendationservice.Models.Produit;
import com.netourism.recomendationservice.Repositories.ProduitRepository;
import com.netourism.recomendationservice.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendations")

public class ProduitController {
    @Autowired
    private  ProduitRepository produitService;

    @GetMapping("/all")
    public Iterable<Produit> listerProduits() {
        return produitService.findAll();
    }
    @PostMapping("/add")
    public Produit addProduit(@RequestBody Produit prod){
        produitService.save(prod);
        return prod;
    }
}
