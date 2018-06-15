/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie;

import atos.magiemagie.JoueurService;
import atos.magiemagie.PartieService;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrateur
 */
public class JoueurServiceTest {
    
    private JoueurService service = new JoueurService();
    private PartieService partiService = new PartieService();
    
    @Test
    public void rejoindrePartieOK(){
        
        partiService.creerNouvellePartie("partie 1");
        service.rejoindrePartie("thomas", "blabla", 0);
    
    }
       
}
