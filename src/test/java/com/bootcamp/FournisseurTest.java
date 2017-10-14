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
import java.util.*;

/**
 *
 * @author Iso-Doss
 */
public class FournisseurTest {

    private FournisseurRepository mysql = new FournisseurRepository("com.bootcamp_TpJPA");
    private FournisseurRepository derby = new FournisseurRepository("tpJpa");

    //@Test
    public void createFournisseurMysql() throws SQLException {
        List<Fournisseur> fournisseurs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setNom(nom[i]);
            fournisseurs.add(fournisseur);
        }

        for (Object element : fournisseurs) {
            mysql.create((Fournisseur) element);
        }

    }

    //@Test
    public void createFournisseurDerby() throws SQLException {
        List<Fournisseur> fournisseurs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setNom(nom[i]);
            fournisseurs.add(fournisseur);
        }

        for (Object element : fournisseurs) {
            derby.create((Fournisseur) element);
        }
    }

    //@Test
    public void readAllFournisseurMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllFournisseurDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readFournisseurMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readFournisseurDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateFournisseurMysql() throws SQLException {
        Fournisseur fournisseur = mysql.findByProperty("nom", "Iso");
        fournisseur.setNom("zozo");
        mysql.update(fournisseur);
    }

    //@Test
    public void updateeFournisseurDerby() throws SQLException {
        Fournisseur fournisseur = derby.findByProperty("nom", "Iso");
        fournisseur.setNom("zozo");
        derby.update(fournisseur);
    }

    //@Test
    public void deleteFournisseurMysql() throws SQLException {
        Fournisseur fournisseur = mysql.findByProperty("nom", "Doss");
        mysql.delete(fournisseur);
    }

    //@Test
    public void deleteFournisseurDerby() throws SQLException {
        Fournisseur fournisseur = derby.findByProperty("nom", "Doss");

        derby.delete(fournisseur);
    }

    /**
     * @return the mysql
     */
    public FournisseurRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(FournisseurRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public FournisseurRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(FournisseurRepository derby) {
        this.derby = derby;
    }
}
