/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrateur
 */
public class MagieTest {
    
    @Test
    public void testMagie(){
    
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
}}
