package net.codejava.tp6.metier;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import net.codejava.tp6.metier.ICatalogueLocal;
import net.codejava.tp6.metier.Produit;

import java.io.Serializable;
import java.util.List;

@Named("produitBean")
@SessionScoped
public class ProduitBean implements Serializable {

    @EJB(beanName = "CATAL")
    private ICatalogueLocal catalogue;

    private Produit produit = new Produit();
    private List<Produit> produits;
    private String motCle;
    private Long selectedId;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public List<Produit> getProduits() {
        if (produits == null) {
            produits = catalogue.getAllProduits();
        }
        return produits;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public String addProduit() {
        try {
            catalogue.addProduit(produit);
            produits = null;
            produit = new Produit();
            addMessage("Success", "Product added successfully!");
            return "listProduits?faces-redirect=true";
        } catch (Exception e) {
            addMessage("Error", "Failed to add product: " + e.getMessage());
            return null;
        }
    }

    public String editProduit(Produit p) {
        this.produit = p;
        return "editProduit?faces-redirect=true";
    }

    public String updateProduit() {
        try {
            catalogue.updateProduit(produit);
            produits = null;
            produit = new Produit();
            addMessage("Success", "Product updated successfully!");
            return "listProduits?faces-redirect=true";
        } catch (Exception e) {
            addMessage("Error", "Failed to update product: " + e.getMessage());
            return null;
        }
    }

    public void deleteProduit(Long id) {
        try {
            catalogue.removeProduit(id);
            produits = null; // Force refresh
            addMessage("Success", "Product deleted successfully!");
        } catch (Exception e) {
            addMessage("Error", "Failed to delete product: " + e.getMessage());
        }
    }

    public void searchProduits() {
        if (motCle != null && !motCle.trim().isEmpty()) {
            produits = catalogue.getProduitsParMotCle(motCle);
        } else {
            produits = catalogue.getAllProduits();
        }
    }

    public String resetSearch() {
        motCle = "";
        produits = null;
        return "listProduits?faces-redirect=true";
    }

    public String goToAddForm() {
        produit = new Produit();
        return "addProduit?faces-redirect=true";
    }

    private void addMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(summary, detail));
    }
}