/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "Programme")
@Table(name = "tp_programme")
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @NotNull(message = "Le champs objectif ne peut etre null.")
    @Column(name = "objectif", length = 45, nullable = false)
    private String objectif;

    @NotNull(message = "Le champs dateDeDebut ne peut etre null.")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeDebut;

    @NotNull(message = "Le champs dateDeFin ne peut etre null.")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeFin;

    @NotNull(message = "Le champs budgetPrevisionnel ne peut etre null.")
    @Column(nullable = false)
    private double budgetPrevisionnel;

    @NotNull(message = "Le champs budgetEffectif ne peut etre null.")
    @Column(nullable = false)
    private double budgetEffectif;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programme")
    private List<Projet> projets = new ArrayList<Projet>();

    @NotNull(message = "Le champs indicateurPerformance ne peut etre null.")
    @ManyToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateurPerformance;

    /*
    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "tp_programme_bailleur",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "bailleur_id")
    )
    private List<Bailleur> bailleurs = new ArrayList<Bailleur>();

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "tp_programme_beneficiaire",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "beneficiaire_id")
    )
    private List<Beneficiaire> beneficiaires = new ArrayList<Beneficiaire>();

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "tp_programme_fournisseur",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "fournisseur_id")
    )
    private List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
     */
    @NotNull(message = "Le champs programmeBailleur ne peut etre null.")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgrammeBailleur programmeBailleur;

    @NotNull(message = "Le champs programmeBeneficiaire ne peut etre null.")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgrammeBeneficiaire programmeBeneficiaire;

    @NotNull(message = "Le champs programmeFournisseur ne peut etre null.")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgrammeFournisseur programmeFournisseur;

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
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.Programme[ id=" + id + " ]";
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
     * @return the objectif
     */
    public String getObjectif() {
        return objectif;
    }

    /**
     * @param objectif the objectif to set
     */
    public void setObjectif(String objectif) {
        this.objectif = objectif;
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
     * @return the dateDeFin
     */
    public Date getDateDeFin() {
        return dateDeFin;
    }

    /**
     * @param dateDeFin the dateDeFin to set
     */
    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    /**
     * @return the budgetPrevisionnel
     */
    public double getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    /**
     * @param budgetPrevisionnel the budgetPrevisionnel to set
     */
    public void setBudgetPrevisionnel(double budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    /**
     * @return the budgetEffectif
     */
    public double getBudgetEffectif() {
        return budgetEffectif;
    }

    /**
     * @param budgetEffectif the budgetEffectif to set
     */
    public void setBudgetEffectif(double budgetEffectif) {
        this.budgetEffectif = budgetEffectif;
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
     * @return the programmeBailleur
     */
    public ProgrammeBailleur getProgrammeBailleur() {
        return programmeBailleur;
    }

    /**
     * @param programmeBailleur the programmeBailleur to set
     */
    public void setProgrammeBailleur(ProgrammeBailleur programmeBailleur) {
        this.programmeBailleur = programmeBailleur;
    }

    /**
     * @return the programmeBeneficiaire
     */
    public ProgrammeBeneficiaire getProgrammeBeneficiaire() {
        return programmeBeneficiaire;
    }

    /**
     * @param programmeBeneficiaire the programmeBeneficiaire to set
     */
    public void setProgrammeBeneficiaire(ProgrammeBeneficiaire programmeBeneficiaire) {
        this.programmeBeneficiaire = programmeBeneficiaire;
    }

    /**
     * @return the programmeFournisseur
     */
    public ProgrammeFournisseur getProgrammeFournisseur() {
        return programmeFournisseur;
    }

    /**
     * @param programmeFournisseur the programmeFournisseur to set
     */
    public void setProgrammeFournisseur(ProgrammeFournisseur programmeFournisseur) {
        this.programmeFournisseur = programmeFournisseur;
    }

}
