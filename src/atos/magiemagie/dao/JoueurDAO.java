/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magie.Joueur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrateur
 */
public class JoueurDAO {

    public Joueur rechercherParPseudo(String pseudo) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT j FROM Joueur j WHERE j.pseudo = :lepseudo");
        query.setParameter("lepseudo", pseudo);
        List<Joueur> joueursTrouves = query.getResultList();

        if (joueursTrouves.isEmpty()) {
            return null;
        }

        return joueursTrouves.get(0);
    }

    public long ordrerechercheOrdreNouveauJoueur(long partieId) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT Max(j.ordre) FROM Joueur j WHERE j.partieNow.id =:idPartie");
        query.setParameter("idPartie", partieId);

        Object res = query.getSingleResult();
        if (res == null) {
            return 1;
        }
        return (long) res;
        //return (long)  query.getSingleResult();
    }

    public void ajouter(Joueur joueur) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(joueur);
        em.getTransaction().commit();

    }

    public void modifier(Joueur joueur) {

    }
}
