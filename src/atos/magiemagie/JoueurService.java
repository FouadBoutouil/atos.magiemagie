/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie;

import atos.magie.Joueur;
import static atos.magie.Joueur_.pseudo;
import atos.magie.Partie;
import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.PartieDAO;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class JoueurService {

    
    private JoueurDAO dao = new JoueurDAO();
    private PartieDAO daoPartie = new PartieDAO();

    public void rejoindrePartie(String pseudo, String avatar, long idPartie) {
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

        Partie partie = daoPartie.rechercherPartieId(idPartie);
        joueur.setPartieNow(partie);  // renvoi la partie actuelle
        List<Joueur> listeJoueurs = partie.getJoueurs();
        listeJoueurs.add(joueur);
        
        if (joueur.getId()== null) {
            dao.ajouter(joueur);  
        }else{
            dao.modifier(joueur);
        }
    }
}
