/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "Fournisseur")
@Table(name = "tp_fournisseur")
@DiscriminatorValue("TP_FOURNISSEUR")
public class Fournisseur extends Personne {

    @NotNull(message = "Le champs programmeFournisseur ne peut etre null.")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgrammeFournisseur programmeFournisseur;

    @ManyToMany(mappedBy = "fournisseurs")
    private List<Projet> projets = new ArrayList<Projet>();

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
