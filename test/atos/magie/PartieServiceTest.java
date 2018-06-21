/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie;


import atos.magie.service.JoueurService;
import atos.magie.service.PartieService;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrateur
 */
public class PartieServiceTest {
    
      
    private PartieService servicePartie = new PartieService();
    private JoueurService serviceJOueur = new JoueurService();
//    
//    @Test
//    public void creerNouvellePartieTestOK() {
//
//        Partie partie = servicePartie.creerNouvellePartie("patrieDuMardi");
//        joueurServiceTest joueur1 = new joueurServiceTest();
//      
//        // joueur1.rejoindrePartieOK();    //  cette ligne creer une partie partie 1 
//        assertNotNull(partie.getId());
//        
//    }
//   
    
    @Test public void rejoindreParti(){
        
        //servicePartie.creerNouvellePartie("partie du mardi");
        
//       serviceJOueur.rejoindrePartie("joueur1","avatar", 1);
//        serviceJOueur.rejoindrePartie("joueur2","ava", 1);
//       serviceJOueur.rejoindrePartie("joueur18","tar", 1);
//       
       servicePartie.demarrerPartie(1);
               

    }
    
}
