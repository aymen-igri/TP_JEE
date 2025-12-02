package net.codejava.tp6.metier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless(name="CATAL")
public class CatalogueEJBImp implements ICatalogueRemote, ICatalogueLocal {

    @PersistenceContext(unitName = "CatalogueEJB")
    private EntityManager em;

    @Override
    public void addProduit(Produit p) {
        em.persist(p);
    }

    @Override
    public List<Produit> getAllProduits() {
        Query query = em.createQuery("SELECT p FROM Produit p");
        return query.getResultList();
    }

    @Override
    public List<Produit> getProduitsParMotCle(String mc) {
        Query query = em.createQuery("SELECT p FROM Produit p WHERE p.designation LIKE :mc");
        query.setParameter("mc", "%" + mc + "%");
        return query.getResultList();
    }

    @Override
    public Produit getProduitById(Long idP) {
        return em.find(Produit.class, idP);
    }

    @Override
    public void removeProduit(Long idP) {
        Produit p = em.find(Produit.class, idP);
        if (p != null) {
            em.remove(p);
        }
    }

    @Override
    public void updateProduit(Produit p) {
        em.merge(p);
    }
}