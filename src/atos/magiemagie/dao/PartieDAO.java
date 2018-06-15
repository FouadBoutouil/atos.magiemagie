/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magie.Joueur;
import atos.magie.Partie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrateur
 */
public class PartieDAO {

    public List<Partie> listePartiesNonDemaree() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT p FROM Partie EXCEPT select P FROM Partie p JOIN p.joueur jp.etat=gagne EXCEPT SELECT p FROM Partie p JOIN p.joueurs WHERE j.etat=alamain" );
        query.setParameter("etat_gagné", Joueur.EtatJoueur.aLamain);
        // mezme requete gagné
        return query.getResultList();
    }

    public Partie rechercherPartieId(long idPartie) {
        EntityManager em =Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Partie.class, idPartie); // c'est comme une requete mais en plus simple 
    }
    
    public void ajouter(Partie p) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

}
    