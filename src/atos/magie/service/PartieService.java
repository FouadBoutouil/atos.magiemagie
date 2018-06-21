
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.service;

import atos.magie.entity.Joueur;
import atos.magie.entity.Partie;
import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.PartieDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrateur
 */
public class PartieService {

    private PartieDAO dao = new PartieDAO();
    private JoueurDAO daoJoueur = new JoueurDAO();
    Joueur joueur = new Joueur();   // pour l'utiliser dans passer joiueur suivant

    public List<Partie> listePartiesNonDemaree() {  
        return dao.listePartiesNonDemaree(); //         
    }

    public Partie creerNouvellePartie(String nom) {
        Partie p = new Partie();
        p.setNom(nom);
        dao.ajouter(p);
        return p;

    }

    // fonction qui teste le nombre de jolueur qui sont a nonPerdu sil est seperieur a un la pertie n'est pas finie encore
    //  si cette fonction renvoi vrai c a d que le joueur a gagné c a d la partie estg fini ( théoriquement )
    public Boolean siTousLesAutreJoueurOntPerdu(long idPartie) {
        List<Joueur> list = dao.siTousLesAutreJoueurOntPerduDAOOOOOOOOOOOO(idPartie);
        // on verefi le nombre de joueur a letat perdu sil est egale ou superieur a joueur -1  
        if (list.size() == dao.nbrJoueurPartie(idPartie) - 1) {
            return true;
        }
        return false;
    }

    public Partie demarrerPartie(long idPartie) {

        // recherche la partier par son id
        Partie p = dao.rechercherPartieParID(idPartie);
        JoueurService joueurService = new JoueurService();
        //Joueur joueurAct = new Joueur();

        // erreur si moins de deux joueurs dans la partie
        // le teste recuper la liste des joueurs d'une partie et compare le size a deux
        if (3 < 2) {         // remettre la condition 3 < 2 ct juste un test 

            throw new RuntimeException("il faut au moins deux joueurs");
        }

        //    passe le joueur d'ordre un a a la main 
        Joueur monJoueur = dao.retourneJoueurDordreParametreDansPartie(idPartie, 1);
        monJoueur.setEtat(Joueur.EtatJoueur.aLamain);
        daoJoueur.modifier(monJoueur);

        // distribuer sept cartes au nhazard au joueurs
        
        for (Joueur joueur : p.getJoueurs()) {
            joueurService.distribuerCarte(joueur.getId(), 7);
        }
        
        
        return p;
    }

    public void passeJoueurSuivant(long idPartie) {
        // recupere le joueur qui a la main   creer une fonction joueurquialamain
        Joueur joueurQuiAlaMain = daoJoueur.rechercheJoueurQuiAlaMain(idPartie);

        // la partie n'est pas terminée
        // boucle qui teste si tous les autres joueurs ont perdu --> passe le joueur 
        // a l'état gagné
        //---------------------------------------------------------------------------//   CAS 1 :  joueur dans partie > 1
        if (!dao.rechercheSiPlusDunJoueurDansUnePartie(idPartie)) {
            // on passe l'état du joueur a gagné
            joueurQuiAlaMain.setEtat(Joueur.EtatJoueur.gagné);
            // on persiste dans la base de donnée
            daoJoueur.modifier(joueurQuiAlaMain);
            return;                                            // le return c'est pour sortir de la boucle
        }
        //--------------------------------------------------------------------------// CAS 2 : joueur dans partie < 1                                                                

        // recupere lordre max de la partie et on le stock dans une variable pour ne pas le calculer a chaque fois
        long ordreMax = dao.joueurOrdreMaxDansLaPartie(idPartie);
        Joueur joueurEvalue = joueurQuiAlaMain;

        // on fait une boucle qui permet de determiner le nouveau joueur qui (attrape) la main
        if (joueurEvalue.getOrdre() >= ordreMax) {
            // si c'est le dernier joueur ---> on test le premier joueur dans la partie donc ordre 1----ver1
            // dans cette boucle on a un if si joueur evaluer est le dernioer joueur alors on evalura le premier -----ver2

            joueurEvalue = daoJoueur.retournePremierJoueurDordreUnDansPartie(idPartie, 1L);
            // sinon ndans le cas normal le joueur suivant est le joueur ordre +1
            joueurEvalue = daoJoueur.retournePremierJoueurDordreUnDansPartie(idPartie, joueurEvalue.getOrdre() + 1);
            //--------------------------------------------------------------------------------
            // on test le joueur dordre +1 sil peur prendre la main ---> n'a pas perdue et non someil profond  
            //  si sommeil profond on le reveil !!!
            if (joueurEvalue.getEtat() == Joueur.EtatJoueur.SommeilProfond) {
                joueurEvalue.setEtat(Joueur.EtatJoueur.napaLaMain);
                daoJoueur.modifier(joueurEvalue);

                // le cas ou il a perdu ????????????????????????????
                //--------------------------------------------------------- le cas ou il n'est pas en someil profond 
            } else {
                if (joueurEvalue.getEtat() == Joueur.EtatJoueur.napaLaMain) {   //// partie copier a revoir !?§?§.?§§?§?§?§?§§??§

                    // *-*-*-*--**-*-*-
                    joueurEvalue.setEtat(Joueur.EtatJoueur.aLamain);
                    daoJoueur.modifier(joueurEvalue);
                    joueurQuiAlaMain.setEtat(Joueur.EtatJoueur.napaLaMain);
                    daoJoueur.modifier(joueurQuiAlaMain);
                }
            }
            return;

        }

        //
    }

}
