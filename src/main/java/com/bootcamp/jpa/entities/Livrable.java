/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "Livrable")
@Table(name = "tp_livrable")
public class Livrable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @NotNull(message = "Le champs dateDeDebut ne peut etre null.")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeDebut;

    @NotNull(message = "Le champs dateDeLivraison ne peut etre null.")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeLivraison;

    @NotNull(message = "Le champs indicateurPerformance ne peut etre null.")
    @ManyToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateurPerformance;

    @ManyToOne
    @NotNull(message = "Le champs projet ne peut etre null.")
    @JoinColumn(name = "projet", referencedColumnName = "id")
    private Projet projet;

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
        if (!(object instanceof Livrable)) {
            return false;
        }
        Livrable other = (Livrable) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.Livrable[ id=" + id + " ]";
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
     * @return the dateDeDebut
     */
    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    /**
     * @param dateDeDebut the dateDeDebut to set
     */
    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    /**
     * @return the dateDeLivraison
     */
    public Date getDateDeLivraison() {
        return dateDeLivraison;
    }

    /**
     * @param dateDeLivraison the dateDeLivraison to set
     */
    public void setDateDeLivraison(Date dateDeLivraison) {
        this.dateDeLivraison = dateDeLivraison;
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

    /**
     * @return the projet
     */
    public Projet getProjet() {
        return projet;
    }

    /**
     * @param projet the projet to set
     */
    public void setProjet(Projet projet) {
        this.projet = projet;
    }

}
