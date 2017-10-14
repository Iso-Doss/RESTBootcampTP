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
public class LivrableTest {

    private LivrableRepository mysql = new LivrableRepository("com.bootcamp_TpJPA");
    private LivrableRepository derby = new LivrableRepository("tpJpa");

    //@Test
    public void createLivrableMysql() throws SQLException {
        List<Livrable> livrables = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Livrable livrable = new Livrable();
            livrable.setNom(nom[i]);
            livrable.setDateDeDebut(Date.from(Instant.MIN));
            livrable.setDateDeLivraison(Date.from(Instant.MIN));
            livrable.setNom(nom[i]);
            livrables.add(livrable);
        }

        for (Object element : livrables) {
            mysql.create((Livrable) element);
        }

    }

    //@Test
    public void createLivrableDerby() throws SQLException {
        List<Livrable> livrables = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Livrable livrable = new Livrable();
            livrable.setNom(nom[i]);
            livrable.setDateDeDebut(Date.from(Instant.MIN));
            livrable.setDateDeLivraison(Date.from(Instant.MIN));
            livrables.add(livrable);
        }

        for (Object element : livrables) {
            derby.create((Livrable) element);
        }
    }

    //@Test
    public void readAllLivrableMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllLivrableDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readLivrableMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readLivrableDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateLivrableMysql() throws SQLException {
        Livrable livrable = mysql.findByProperty("nom", "Iso");
        livrable.setNom("zozo");
        mysql.update(livrable);
    }

    //@Test
    public void updateeLivrableDerby() throws SQLException {
        Livrable livrable = derby.findByProperty("nom", "Iso");
        livrable.setNom("zozo");
        derby.update(livrable);
    }

    //@Test
    public void deleteLivrableMysql() throws SQLException {
        Livrable livrable = mysql.findByProperty("nom", "Doss");
        mysql.delete(livrable);
    }

    //@Test
    public void deleteLivrableDerby() throws SQLException {
        Livrable livrable = derby.findByProperty("nom", "Doss");

        derby.delete(livrable);
    }

    /**
     * @return the mysql
     */
    public LivrableRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(LivrableRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public LivrableRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(LivrableRepository derby) {
        this.derby = derby;
    }
}
