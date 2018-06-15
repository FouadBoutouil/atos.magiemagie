/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie;


import atos.magiemagie.PartieService;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrateur
 */
public class PartieServiceTest {
    
      
    private PartieService servicePartie = new PartieService();
    private JoueurServiceTest serviceJOueur = new JoueurServiceTest();
    
    @Test
    public void creerNouvellePartieTestOK() {

        Partie partie = servicePartie.creerNouvellePartie("nom");
        assertNotNull(partie.getId());    
    }
    
}
