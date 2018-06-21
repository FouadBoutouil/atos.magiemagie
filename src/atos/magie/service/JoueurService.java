/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.service;

import atos.magie.entity.Carte;
import atos.magie.entity.Joueur;
import atos.magie.entity.Partie;
import atos.magiemagie.dao.CarteDAO;
import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.PartieDAO;
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
public class JoueurService  {

    private JoueurDAO dao = new JoueurDAO();
    private PartieDAO daoPartie = new PartieDAO();
 
    
    public void distribuerCarte(long idJoueur, long nbrCarte) {

        Joueur joueurActuel = dao.rechercheJoueurParID(idJoueur); /// §§§§§§§§§§§§§§§§§
          Carte carteActuelle = new Carte();
          CarteDAO daoCarte = new CarteDAO();
        //on rajoute la carte generée a chaque fois
        for (int i = 0; i < nbrCarte-1; i++) {
            //joueur.setCartes();
          

            Random r = new Random();
            int numeroCarte = r.nextInt(5);

            switch (numeroCarte) {
                case 0:
                    carteActuelle.setIngredient(Carte.Ingredient.CRAPAUD);
                    break;
                    
                case 1:
                    carteActuelle.setIngredient(Carte.Ingredient.CHAUVESOURIS);
                    break;
                    
                case 2:
                    carteActuelle.setIngredient(Carte.Ingredient.LICORNE);
                    break;
                
                case 3:
                    carteActuelle.setIngredient(Carte.Ingredient.LAPISLAZULI);
                    break;
                    
                case 4:
                    carteActuelle.setIngredient(Carte.Ingredient.MANDRAGORE);
                    break;
                default:
                    throw new RuntimeException("Invalid grade");
            }
            // on ajoute la carte genereé aléatoirement dans une liste qu'on affectera a la fin a joueur, cette list
            // represente sa main
            
            
            carteActuelle.setJoueurProprio(joueurActuel);
        }
            List<Carte> cartes =  joueurActuel.getCartes();
            cartes.add(carteActuelle);
//            carteActuelle.setJoueurProprio(joueurActuel);
//            joueurActuel.setCarte(cartes);
            dao.modifier(joueurActuel);
            daoCarte.ajouterCarte(carteActuelle);
            // 
            
            daoCarte.modifierCarte(carteActuelle);
        }
        // on affecte la liste finale generé aux joueurs
    
    
    public Joueur rejoindrePartie(String pseudo, String avatar, long idPartie) {
        // recherche si le joueur exsiste deja 
        Joueur joueur = dao.rechercherParPseudo(pseudo);
        if (joueur == null) {
            // le joueur n'exsiste pas encore
            joueur = new Joueur();
            joueur.setPseudo(pseudo);
            joueur.setNbrPartieGagne(0l);
            joueur.setNbrPartieJouee(0l);
        }
        joueur.setAvatar(avatar);
        joueur.setEtat(Joueur.EtatJoueur.napaLaMain);
        long ordre = dao.ordrerechercheOrdreNouveauJoueur(idPartie);
        joueur.setOrdre(ordre);

        Partie partie = daoPartie.rechercherPartieParID(idPartie);
        joueur.setPartieNow(partie);  // renvoi la partie actuelle
        List<Joueur> listeJoueurs = partie.getJoueurs();
        listeJoueurs.add(joueur);

        if (joueur.getId() == null) {
            dao.ajouter(joueur);
        } else {
            dao.modifier(joueur);
        }
        return joueur;
    }

}
