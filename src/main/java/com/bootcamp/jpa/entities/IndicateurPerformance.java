/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "IndicateurPerformance")
@Table(name = "tp_indicateur_performance")
public class IndicateurPerformance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @OneToMany(mappedBy = "indicateurPerformance")
    private List<Programme> programmes = new ArrayList<Programme>();

    @OneToMany(mappedBy = "indicateurPerformance")
    private List<Projet> projets = new ArrayList<Projet>();

    @OneToMany(mappedBy = "indicateurPerformance")
    private List<Livrable> livrables = new ArrayList<Livrable>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicateurPerformance")
    private List<IndicateurQualitatif> indicateurQualitatifs = new ArrayList<IndicateurQualitatif>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicateurPerformance")
    private List<IndicateurQuantitatif> indicateurQuantitatifs = new ArrayList<IndicateurQuantitatif>();

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
        if (!(object instanceof IndicateurPerformance)) {
            return false;
        }
        IndicateurPerformance other = (IndicateurPerformance) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.IndicaterPerformance[ id=" + id + " ]";
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the libelle to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the programmes
     */
    public List<Programme> getProgrammes() {
        return programmes;
    }

    /**
     * @param programmes the programmes to set
     */
    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

    /**
     * @return the projets
     */
    public List<Projet> getProjets() {
        return projets;
    }

    /**
     * @param projets the projets to set
     */
    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    /**
     * @return the livrables
     */
    public List<Livrable> getLivrables() {
        return livrables;
    }

    /**
     * @param livrables the livrables to set
     */
    public void setLivrables(List<Livrable> livrables) {
        this.livrables = livrables;
    }

    /**
     * @return the indicateurQualitatifs
     */
    public List<IndicateurQualitatif> getIndicateurQualitatifs() {
        return indicateurQualitatifs;
    }

    /**
     * @param indicateurQualitatifs the indicateurQualitatifs to set
     */
    public void setIndicateurQualitatifs(List<IndicateurQualitatif> indicateurQualitatifs) {
        this.indicateurQualitatifs = indicateurQualitatifs;
    }

    /**
     * @return the indicateurQuantitatifs
     */
    public List<IndicateurQuantitatif> getIndicateurQuantitatifs() {
        return indicateurQuantitatifs;
    }

    /**
     * @param indicateurQuantitatifs the indicateurQuantitatifs to set
     */
    public void setIndicateurQuantitatifs(List<IndicateurQuantitatif> indicateurQuantitatifs) {
        this.indicateurQuantitatifs = indicateurQuantitatifs;
    }

}
