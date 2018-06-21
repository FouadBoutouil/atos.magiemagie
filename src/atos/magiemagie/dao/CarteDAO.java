/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magie.entity.Carte;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 *
 * @author Administrateur
 */
public class CarteDAO{

//
//    @Override
//    public String toString() {
//        return "atos.magiemagie.dao.CarteDAO[ id=" + id + " ]";
//    }

    public void modifierCarte(Carte carte) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(carte);
        em.getTransaction().commit();
    }
    
     public void ajouterCarte(Carte cartem) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(cartem);
        em.getTransaction().commit();
    }
    
}
