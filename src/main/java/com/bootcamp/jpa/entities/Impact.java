/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import com.bootcamp.jpa.enums.TypeImapct;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "Impact")
@Table(name = "tp_impact")
public class Impact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull(message = "Le champ type d'impact ne peut etre null.")
    @Column(name = "typeDeImpact", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeImapct typeImapct;

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
        if (!(object instanceof Impact)) {
            return false;
        }
        Impact other = (Impact) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.Impact[ id=" + id + " ]";
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
     * @return the typeImapct
     */
    public TypeImapct getTypeImapct() {
        return typeImapct;
    }

    /**
     * @param typeImapct the typeImapct to set
     */
    public void setTypeImapct(TypeImapct typeImapct) {
        this.typeImapct = typeImapct;
    }

}
