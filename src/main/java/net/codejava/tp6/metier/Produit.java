package net.codejava.tp6.metier;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PRODUIT")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomProduit;
    private double prix;
    private String designation;

    public Produit() {
        super();
    }

    public Produit(String nomProduit, double prix) {
        super();
        this.nomProduit = nomProduit;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nomProduit='" + nomProduit + '\'' +
                ", prix=" + prix +
                ", designation='" + designation + '\'' +
                '}';
    }
}