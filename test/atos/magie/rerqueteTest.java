/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie;

import atos.magie.service.JoueurService;
import atos.magie.service.PartieService;
import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.PartieDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrateur
 */
public class rerqueteTest {

    private JoueurService joueurSer = new JoueurService();
    private PartieService partieTe = new PartieService();

//    @Test
//    public void rerqueteTest() {
//        PartieDAO daoPartie = new PartieDAO();
//        JoueurDAO daoJoueur = new JoueurDAO();
//
//        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
//        Query requete = em.createQuery("SELECT P FROM Partie P JOIN P.joueurs j WHERE j.etat=:etat1"
//                + " EXCEPT     "
//                + " SELECT P FROM Partie P JOIN P.joueurs j WHERE j.etat=:etat2");
//        requete.setParameter("etat1", Joueur.EtatJoueur.gagné);
//        requete.setParameter("etat2", Joueur.EtatJoueur.napaLaMain);
//        List<Partie> tableauPartie = requete.getResultList();
//        for (Partie partie : tableauPartie) {
//            System.out.println(partie);
//        }
    @Test
    public void rerqueteTest() {

//        partieTe.creerNouvellePartie("nouvellePartie");
//        joueurSer.rejoindrePartie("premierJoueur","sonAvatar", 1);
//        joueurSer.rejoindrePartie("deuxiemJoueur","sonAva", 1);
//        joueurSer.rejoindrePartie("troisiempremierJoueur","atar", 1);
//        partieTe.demarrerPartie(1);

    }

}
