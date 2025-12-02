package net.codejava.tp6.metier;

import java.util.List;

public interface ICatalogueRemote {
    public void addProduit(Produit p);
    public List<Produit> getAllProduits();
    public List<Produit> getProduitsParMotCle(String mc);
    public Produit getProduitById(Long idP);
    public void removeProduit(Long idP);
    public void updateProduit(Produit p);
}
