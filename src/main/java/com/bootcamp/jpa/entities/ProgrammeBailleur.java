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

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "ProgrammeBailleur")
@Table(name = "tp_progamme_tp_bailleur")
public class ProgrammeBailleur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programmeBailleur")
    private List<Programme> programmes = new ArrayList<Programme>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programmeBailleur")
    private List<Bailleur> bailleurs = new ArrayList<Bailleur>();
    
    @Column(name="nombre", nullable = false)
    private int nombre;

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
        if (!(object instanceof ProgrammeBailleur)) {
            return false;
        }
        ProgrammeBailleur other = (ProgrammeBailleur) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.ProgrammeBailleur[ id=" + id + " ]";
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
     * @return the bailleurs
     */
    public List<Bailleur> getBailleurs() {
        return bailleurs;
    }

    /**
     * @param bailleurs the bailleurs to set
     */
    public void setBailleurs(List<Bailleur> bailleurs) {
        this.bailleurs = bailleurs;
    }

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
