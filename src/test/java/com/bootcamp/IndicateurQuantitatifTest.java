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
public class IndicateurQuantitatifTest {

    private IndicateurQuantitatifRepository mysql = new IndicateurQuantitatifRepository("com.bootcamp_TpJPA");
    private IndicateurQuantitatifRepository derby = new IndicateurQuantitatifRepository("tpJpa");

    //@Test
    public void createIndicateurQuantitatifMysql() throws SQLException {
        List<IndicateurQuantitatif> indicateurQuantitatifs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String propriete[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            IndicateurQuantitatif indicateurQuantitatif = new IndicateurQuantitatif();
            indicateurQuantitatif.setNom(nom[i]);
            indicateurQuantitatif.setPropriete(propriete[i]);
            indicateurQuantitatif.setValeur(12);
            indicateurQuantitatifs.add(indicateurQuantitatif);
        }

        for (Object element : indicateurQuantitatifs) {
            mysql.create((IndicateurQuantitatif) element);
        }

    }

    //@Test
    public void createIndicateurQuantitatifDerby() throws SQLException {
        List<IndicateurQuantitatif> indicateurQuantitatifs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String propriete[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            IndicateurQuantitatif indicateurQuantitatif = new IndicateurQuantitatif();
            indicateurQuantitatif.setNom(nom[i]);
            indicateurQuantitatif.setPropriete(propriete[i]);
            indicateurQuantitatif.setValeur(12);
            indicateurQuantitatifs.add(indicateurQuantitatif);
        }

        for (Object element : indicateurQuantitatifs) {
            derby.create((IndicateurQuantitatif) element);
        }
    }

    ////@Test
    public void readAllIndicateurQuantitatifMysql() throws SQLException {
        mysql.findAll();

    }

    ////@Test
    public void readAllIndicateurQuantitatifDerby() throws SQLException {
        derby.findAll();
    }

    ////@Test
    public void readIndicateurQuantitatifMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    ////@Test
    public void readIndicateurQuantitatifDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    ////@Test
    public void updateIndicateurQuantitatifMysql() throws SQLException {
        IndicateurQuantitatif indicateurQuantitatif = mysql.findByProperty("nom", "Iso");
        indicateurQuantitatif.setNom("zozo");
        mysql.update(indicateurQuantitatif);
    }

    ////@Test
    public void updateeIndicateurQuantitatifDerby() throws SQLException {
        IndicateurQuantitatif indicateurQuantitatif = derby.findByProperty("nom", "Iso");
        indicateurQuantitatif.setNom("zozo");
        derby.update(indicateurQuantitatif);
    }

    ////@Test
    public void deleteIndicateurQuantitatifMysql() throws SQLException {
        IndicateurQuantitatif indicateurQuantitatif = mysql.findByProperty("nom", "Doss");
        mysql.delete(indicateurQuantitatif);
    }

    ////@Test
    public void deleteIndicateurQuantitatifDerby() throws SQLException {
        IndicateurQuantitatif indicateurQuantitatif = derby.findByProperty("nom", "Doss");

        derby.delete(indicateurQuantitatif);
    }

    /**
     * @return the mysql
     */
    public IndicateurQuantitatifRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(IndicateurQuantitatifRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public IndicateurQuantitatifRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(IndicateurQuantitatifRepository derby) {
        this.derby = derby;
    }
}
