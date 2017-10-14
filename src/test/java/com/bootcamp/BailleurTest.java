/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.enums.*;
import com.bootcamp.jpa.repositories.*;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Iso-Doss
 */
public class BailleurTest {

    private BailleurRepository mysql = new BailleurRepository("com.bootcamp_TpJPA");
    private BailleurRepository derby = new BailleurRepository("tpJpa");

    //@Test
    public void createBailleurMysql() throws SQLException {
        List<Bailleur> bailleurs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Bailleur bailleur = new Bailleur();
            bailleur.setNom(nom[i]);
            bailleur.setTypeDeBailleur(TypeDeBailleur.privé);
            bailleurs.add(bailleur);
        }

        for (Object element : bailleurs) {
            mysql.create((Bailleur) element);
        }

    }

    //@Test
    public void createBailleurDerby() throws SQLException {
        List<Bailleur> bailleurs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Bailleur bailleur = new Bailleur();
            bailleur.setNom(nom[i]);
            bailleur.setTypeDeBailleur(TypeDeBailleur.privé);
            bailleurs.add(bailleur);
        }

        for (Object element : bailleurs) {
            derby.create((Bailleur) element);
        }
    }

    //@Test
    public void readAllBailleurMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllBailleurDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readBailleurMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readBailleurDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateBailleurMysql() throws SQLException {
        Bailleur bailleur = mysql.findByProperty("nom", "Iso");
        bailleur.setNom("zozo");
        mysql.update(bailleur);
    }

    //@Test
    public void updateeBailleurDerby() throws SQLException {
        Bailleur bailleur = derby.findByProperty("nom", "Iso");
        bailleur.setNom("zozo");
        derby.update(bailleur);
    }

    //@Test
    public void deleteBailleurMysql() throws SQLException {
        Bailleur bailleur = mysql.findByProperty("nom", "Doss");
        mysql.delete(bailleur);
    }

    //@Test
    public void deleteBailleurDerby() throws SQLException {
        Bailleur bailleur = derby.findByProperty("nom", "Doss");

        derby.delete(bailleur);
    }

    /**
     * @return the mysql
     */
    public BailleurRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(BailleurRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public BailleurRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(BailleurRepository derby) {
        this.derby = derby;
    }
}
