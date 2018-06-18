/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie;

import atos.magie.Joueur;
import atos.magie.Partie;
import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.PartieDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Administrateur
 */
public class PartieService {

    private PartieDAO dao = new PartieDAO();
    private JoueurDAO daoJoueur = new JoueurDAO();

    public List<Partie> listePartiesNonDemaree() {
        return dao.listePartiesNonDemaree(); //         
    }

    public Partie creerNouvellePartie(String nom) {
        Partie p = new Partie();
        p.setNom(nom);
        dao.ajouter(p);
        return p;

    }

    public Partie demarrerPartie(long idPartie) {

        // recherche la partier par son id
        Partie p = dao.rechercherPartieParID(idPartie);
        
        // erreur si moins de deux joueurs dans la partie
        if (dao.nbrJoueurPartie(p.getId()) < 2) {
            throw  new RuntimeException("il faut au moins deux joueurs");
        }
    
        //    passe le joueur d'ordre un a a la main 
        Joueur monJoueur = daoJoueur.retournePremierJoueurDordreUnDansPartie(idPartie);
        monJoueur.setEtat(Joueur.EtatJoueur.aLamain);
    
        // distribuer sept cartes au nhazard au joueurs
       
        for( int i=0; i< p.getJoueurs().size(); i++ ){
          daoJoueur.distribuerCarte 
        } 
        
        

        return p;
    }

    
    
}
