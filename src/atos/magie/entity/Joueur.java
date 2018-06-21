/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magie.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "joueurProprio")
    private List<Carte> cartes = new ArrayList<>();
    
    private long ordre;

    public long getOrdre() {
        return ordre;
    }

    public void setOrdre(long ordre) {
        this.ordre = ordre;
    }
    @Column(unique = true)
    private String pseudo;

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getNbrPartieGagne() {
        return nbrPartieGagne;
    }

    public void setNbrPartieGagne(Long nbrPartieGagne) {
        this.nbrPartieGagne = nbrPartieGagne;
    }

    public Long getNbrPartieJouee() {
        return nbrPartieJouee;
    }

    public void setNbrPartieJouee(Long nbrPartieJouee) {
        this.nbrPartieJouee = nbrPartieJouee;
    }

    public EtatJoueur getEtat() {
        return etat;
    }

    public void setEtat(EtatJoueur etat) {
        this.etat = etat;
    }

    public Partie getPartieNow() {
        return partieNow;
    }

    public void setPartieNow(Partie partieNow) {
        this.partieNow = partieNow;
    }


    public void setCarte(List<Carte> carte) {
        this.carte = carte;
    }
    private String avatar;
    @Column(nullable = false)
    private Long nbrPartieGagne;
    @Column(nullable = false)
    private Long nbrPartieJouee;

    
    public enum EtatJoueur {
        napaLaMain, aLamain, SommeilProfond, perdu, gagné
    }
    @Enumerated(EnumType.STRING)   // STOKER DANS LA BASE EN TEMPS QUE STRING
    @Column(nullable = false)
    private EtatJoueur etat;
    
    @JoinColumn
    @ManyToOne
    private Partie partieNow;
    
    @OneToMany(mappedBy = "joueurProprio")
    private List<Carte> carte = new ArrayList<>();

    public Long getId() {
        return id;
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
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atos.magie.Joueur[ id=" + id + " ]";
    }
}
