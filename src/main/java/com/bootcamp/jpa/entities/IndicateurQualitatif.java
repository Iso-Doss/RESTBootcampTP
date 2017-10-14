/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "IndicateurQualitatif")
@Table(name = "tp_indicateur_qualitatif")
public class IndicateurQualitatif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @NotNull(message = "Le champs propriete ne peut etre null.")
    @Column(name = "propriete", length = 45, nullable = false)
    private String propriete;

    @NotNull(message = "Le champs valeur ne peut etre null.")
    @Column(name = "valeur", length = 45, nullable = false)
    private String valeur;

    @ManyToOne
    @NotNull(message = "Le champs indicateurPerformance ne peut etre null.")
    @JoinColumn(name = "indicateurPerformance", referencedColumnName = "id")
    private IndicateurPerformance indicateurPerformance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicateurQualitatif)) {
            return false;
        }
        IndicateurQualitatif other = (IndicateurQualitatif) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.IndicateurQualitatif[ id=" + id + " ]";
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the propriete
     */
    public String getPropriete() {
        return propriete;
    }

    /**
     * @param propriete the propriete to set
     */
    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }

    /**
     * @return the valeur
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    /**
     * @return the indicateurPerformance
     */
    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    /**
     * @param indicateurPerformance the indicateurPerformance to set
     */
    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }

}
