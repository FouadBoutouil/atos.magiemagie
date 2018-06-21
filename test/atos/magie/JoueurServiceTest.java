package atos.magie;

import atos.magie.entity.Partie;
import atos.magie.entity.Joueur;
import atos.magie.service.JoueurService;
import atos.magie.service.PartieService;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoueurServiceTest {
    
    private JoueurService service = new JoueurService();
    private PartieService partiService = new PartieService();
    
    @Test 
    public void ordreJoueurOK(){
        Partie nouvellePartie = partiService.creerNouvellePartie("ordreJoueurOK");
        service.rejoindrePartie("joueur1", "avatar1",nouvellePartie.getId() );
        service.rejoindrePartie("joueur2", "avatar2",nouvellePartie.getId() );

        Joueur j = service.rejoindrePartie("c","c",nouvellePartie.getId());
        assertEquals(3L, (long) j.getOrdre());
    }
    @Test
    public void rejoindrePartieOK(){
        
        Partie particree = partiService.creerNouvellePartie("partie 1");
        service.rejoindrePartie("thomas", "blabla", particree.getId() );
    
    }       
}
