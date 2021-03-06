/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrateur
 */
@Entity
public class Carte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //private Ingredient typeCarte;
    
    public enum Ingredient{
            CRAPAUD, CHAUVESOURIS,LICORNE,LAPISLAZULI,MANDRAGORE
    }
    
    
    @JoinColumn
    @ManyToOne
    private Joueur joueurProprio;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ingredient ingredient;
    
    public Long getId() {
        return id;
    }
    
    public void setIngredient( Ingredient ing){
        this.ingredient= ing;
    }

    public Joueur getJoueurProprio() {
        return joueurProprio;
    }

    public void setJoueurProprio(Joueur joueurProprio) {
        this.joueurProprio = joueurProprio;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carte)) {
            return false;
        }
        Carte other = (Carte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atos.magie.Carte[ id=" + id + " ]";
    }
    
}
