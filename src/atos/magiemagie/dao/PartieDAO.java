/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magie.entity.Joueur;
import atos.magie.entity.Partie;
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
        Query query = em.createQuery("SELECT P FROM Partie P JOIN P.joueurs j WHERE j.etat = :etat1"
                                     + " EXCEPT     "
                                     + " SELECT P FROM Partie P JOIN P.joueurs j WHERE j.etat=:etat2");
        query.setParameter("etat1", Joueur.EtatJoueur.gagné);
        query.setParameter("etat2", Joueur.EtatJoueur.aLamain);
        // mezme requete gagné
        return query.getResultList();
    }

    public Partie rechercherPartieParID(long idPartie) {
        EntityManager em =Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Partie.class, idPartie); // c'est comme une requete mais en plus simple 
    }
    
    public void ajouter(Partie p) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    public long nbrJoueurPartie(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT Count(j) "
                + "FROM Joueur j Join Partie p "
                + "where p.partienow_id=:idPartie"); 
        query.setParameter("idPartie", id);
        Object res = query.getSingleResult();
        return (long) res;
        
    }
    // on recupere tous les joueur de la partie puis on selectiuonne le max ( entity manager )
    public Boolean rechercheSiPlusDunJoueurDansUnePartie(long partieID){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query requet = em.createQuery(" select j from Joueur j join j.partie p where p.id=:idPartie "
                + "                    except"
                + "                    select j from Joueur j join j.partie p "
                + "                    where p.id=:idPartie and j.etatjoueur=:etatPerdu");
        requet.setParameter("idPartie", partieID);
        requet.setParameter("etatPerdu",Joueur.EtatJoueur.perdu);
        
        return (Boolean) requet.getSingleResult();
    }
    
    //  renvoi le joueur de laq partie id qui a lordre ordre 
    public Joueur retourneJoueurDordreParametreDansPartie(long idPartie, long ordre){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query q = em.createQuery("SELECT j FROM Joueur j JOIN j.partieNow p WHERE p.id=:partieID and j.ordre =:param3 ");
        q.setParameter("partieID", idPartie);
        q.setParameter("param3", ordre);
        return (Joueur) q.getSingleResult();
        
    }
        public List<Joueur> siTousLesAutreJoueurOntPerduDAOOOOOOOOOOOO(long idPartie){
             EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
             Query requete = em.createQuery("SELECT j FROM Joueur j Join j.partieNow p WHER j.etat=:etat and p.id:=idPartie ");
             requete.setParameter("etat", Joueur.EtatJoueur.perdu);
             requete.setParameter("idPartie", idPartie);
             List<Joueur> list = requete.getResultList();
             return list;
             
        }

    
    
    public long joueurOrdreMaxDansLaPartie(long idPartie) {
            
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query requete = em.createQuery("SELECT Max(j.ordre) FROM Joueur j join j.partie p"
                +                       "WHERE p.id=:id");
        requete.setParameter("id", idPartie);
        return (long) requete.getSingleResult();
  
    }
    
   
}
    