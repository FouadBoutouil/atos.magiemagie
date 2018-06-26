/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.main;

import atos.magie.entity.Partie;
import atos.magie.service.JoueurService;
import atos.magie.service.PartieService;
import atos.magiemagie.dao.PartieDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class PointEntree {

    private PartieService partieService = new PartieService();
    private JoueurService joueurService = new JoueurService();
    private PartieDAO daoPartie = new PartieDAO();
    private Partie myPartie = new Partie();

    public void menuPrincipal() {

        Scanner scan = new Scanner(System.in);   // pour utiliser les entrée clavier
        String choix;
        String nomPartierentreeClavier;
        do {
            System.out.println("Menu principal");
            System.out.println("---------------");
            System.out.println(" 1 - Liste parties non-démarées");
            System.out.println(" 2 - Creer partie");
            System.out.println(" 3 - Rejoindre partie");
            System.out.println(" 4 - Démarer partie ET afficher table");
            //System.out.println(" 5 - afficher table");
            System.out.println(" Q - Quitter");
            System.out.print("Votre choix > ");

            choix = scan.nextLine();   // attends que l'utilisateur entre un caractere au clavier
            switch (choix) {
                case "1":
                    List<Partie> parties = partieService.listePartiesNonDemaree();
                    System.out.println("Voici les parties diponibles : ");
                    List<Partie> partieDispo = daoPartie.listePartiesNonDemaree();
                    for (Partie partie : partieDispo) {
                        System.out.print(partie.toString());
                        System.out.print(" OKOKOOOOoooooooooooooooooooooooooooooooooooooookokokok1");
                    }

                    break;
                case "2":
                    System.out.println("Veuillez entrez le nom de la partie :");
                    nomPartierentreeClavier = scan.nextLine();
                    partieService.creerNouvellePartie(nomPartierentreeClavier);
                    break;
                case "3":
                    System.out.print("Veuillez entrez votre pseudo :");
                    String pseudoClavier = scan.nextLine();
                    System.out.print("Veuillez entrez votre avatar :");
                    String avatarClavier = scan.nextLine();
                    System.out.print("Veuillez entrez l'id de la partie a laquelle vous voulez rejoindre :");
                    long idPartieClavier = scan.nextLong();
                    joueurService.rejoindrePartie(pseudoClavier, avatarClavier, idPartieClavier);
                    System.out.println("Bienvennue dans la partie   (^__^) !!");
                    ecranJeux(idPartieClavier, pseudoClavier);
                    break;
                case "4":
                    System.out.print("Veuillez entrez  le numero de la partie :");
                    long numDemClavier = scan.nextLong();
                    partieService.demarrerPartie(numDemClavier);
                    System.out.print("//////111111111111/////");
                    //partieService.demarrerPartie(1);
                    System.out.println("*-*-*-*-*-*-/////Démarage réussie/////**-*-*-*-*-*-*-*-*-");
                    // AFFICHAGE DE LA TABLE
                    //case "5":

//                    System.out.println("Veuillez entrez le nom de la table (partie)5:");
//                    Scanner aff = new Scanner(System.in);
//                    long idPartieClavierr = aff.nextLong();
//                    partieService.listerJoueuretLeurCarte(idPartieClavierr);
                    partieService.listerJoueuretLeurCarte(numDemClavier);
                    
                    System.out.println("Clique sur [+] pour attaquer , [-] pour passer ");
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("choix pas disponible");

            }
        } while (choix.equals("Q") == false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PointEntree m = new PointEntree();
        m.menuPrincipal();
    }

    private void ecranJeux(long idPartieClavier, String pseudoClavier) {
        // recup id de moi meme
        long monid = 1L;
        while (true) {
            // recherche l'id joueur qui a la main                  
        }
    }
}
