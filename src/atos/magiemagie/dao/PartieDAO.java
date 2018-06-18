/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magie.Joueur;
import static atos.magie.Joueur_.id;
import atos.magie.Partie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static javax.swing.text.html.HTML.Tag.SELECT;
import static org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLLexer.FROM;
import static org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.FROM;
import static org.eclipse.persistence.jpa.jpql.parser.Expression.FROM;
import static sun.misc.MessageUtils.where;

/**
 *
 * @author Administrateur
 */
public class PartieDAO {

    public List<Partie> listePartiesNonDemaree() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT p FROM Partie p "
                + "EXCEPT select P FROM Partie p JOIN p.joueur jp.etat=:etat_gagné "
                + "EXCEPT SELECT p FROM Partie p JOIN p.joueurs WHERE j.etat=:alamain" );
        query.setParameter("etat_gagné", Joueur.EtatJoueur.aLamain);
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
    
   
}
    