/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.repositories.*;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.time.Instant;
import java.util.*;

/**
 *
 * @author Iso-Doss
 */
public class ProjetTest {

    private ProjetRepository mysql = new ProjetRepository("com.bootcamp_TpJPA");
    private ProjetRepository derby = new ProjetRepository("tpJpa");

    //@Test
    public void createProjetMysql() throws SQLException {
        List<Projet> projets = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String objectif[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
            projet.setObjectif(objectif[i]);
            projet.setDateDeDebut(Date.from(Instant.MIN));
            projet.setDateDeFin(Date.from(Instant.MIN));
            projet.setBudgetEffectif(1220);
            projet.setBudgetPrevisionnel(1220);
            projet.setNom(nom[i]);
            projets.add(projet);
        }

        for (Object element : projets) {
            mysql.create((Projet) element);
        }

    }

    //@Test
    public void createProjetDerby() throws SQLException {
        List<Projet> projets = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String objectif[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
            projet.setObjectif(objectif[i]);
            projet.setDateDeDebut(Date.from(Instant.MIN));
            projet.setDateDeFin(Date.from(Instant.MIN));
            projet.setBudgetEffectif(1220);
            projet.setBudgetPrevisionnel(1220);
            projet.setNom(nom[i]);
            projets.add(projet);
        }

        for (Object element : projets) {
            derby.create((Projet) element);
        }
    }

    //@Test
    public void readAllProjetMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllProjetDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readProjetMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readProjetDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateProjetMysql() throws SQLException {
        Projet projet = mysql.findByProperty("nom", "Iso");
        projet.setNom("zozo");
        mysql.update(projet);
    }

    //@Test
    public void updateeProjetDerby() throws SQLException {
        Projet projet = derby.findByProperty("nom", "Iso");
        projet.setNom("zozo");
        derby.update(projet);
    }

    //@Test
    public void deleteProjetMysql() throws SQLException {
        Projet projet = mysql.findByProperty("nom", "Doss");
        mysql.delete(projet);
    }

    //@Test
    public void deleteProjetDerby() throws SQLException {
        Projet projet = derby.findByProperty("nom", "Doss");

        derby.delete(projet);
    }

    /**
     * @return the mysql
     */
    public ProjetRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(ProjetRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public ProjetRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(ProjetRepository derby) {
        this.derby = derby;
    }
}
