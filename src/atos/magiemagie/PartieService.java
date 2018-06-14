/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie;

import atos.magie.Partie;
import atos.magiemagie.dao.PartieDAO;
import java.util.List;

/**
 *
 * @author Administrateur
 */


public class PartieService {
    
    private PartieDAO dao = new PartieDAO();
    
    public List<Partie> listePartiesNonDemaree(){
        return dao.listePartiesNonDemaree();
        
    }   
}
