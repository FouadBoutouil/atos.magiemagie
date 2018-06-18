/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magie.Carte;
import atos.magie.Joueur;
import static atos.magie.Joueur_.carte;
import static atos.magie.Joueur_.cartes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        Query query = em.createQuery("SELECT Max(j.ordre)+1 FROM Joueur j WHERE j.partieNow.id =:idPartie");
        query.setParameter("idPartie", partieId);

        Object res = query.getSingleResult();
        if (res == null) {
            return 1;
        }
        return (long) res;
        //return (long)  query.getSingleResult();
    }

    public Joueur retournePremierJoueurDordreUnDansPartie(long idartie) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT J from Joueur J Join Partie p WHERE J.ordre=1 AND p.id =:variable");
        query.setParameter("variable", idartie);

        Joueur res = (Joueur) query.getSingleResult();

        return res;
    }

    public void ajouter(Joueur joueur) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(joueur);
        em.getTransaction().commit();

    }

    public void modifier(Joueur joueur) {

    }

   
    public Joueur rechercheJoueurParID(int idJoueur) {
            
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Joueur.class,idJoueur);
           
    }

}
