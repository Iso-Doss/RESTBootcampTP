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
public class IndicateurQualitatifTest {

    private IndicateurQualitatifRepository mysql = new IndicateurQualitatifRepository("com.bootcamp_TpJPA");
    private IndicateurQualitatifRepository derby = new IndicateurQualitatifRepository("tpJpa");

    //@Test
    public void createIndicateurQualitatifMysql() throws SQLException {
        List<IndicateurQualitatif> indicateurQualitatifs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String propriete[] = {"Iso", "Doss", "Ros"};
        String valeur[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            IndicateurQualitatif indicateurQualitatif = new IndicateurQualitatif();
            indicateurQualitatif.setNom(nom[i]);
            indicateurQualitatif.setPropriete(propriete[i]);
            indicateurQualitatif.setValeur(valeur[i]);
            indicateurQualitatifs.add(indicateurQualitatif);
        }

        for (Object element : indicateurQualitatifs) {
            mysql.create((IndicateurQualitatif) element);
        }

    }

    //@Test
    public void createIndicateurQualitatifDerby() throws SQLException {
        List<IndicateurQualitatif> indicateurQualitatifs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String propriete[] = {"Iso", "Doss", "Ros"};
        String valeur[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            IndicateurQualitatif indicateurQualitatif = new IndicateurQualitatif();
            indicateurQualitatif.setNom(nom[i]);
            indicateurQualitatif.setPropriete(propriete[i]);
            indicateurQualitatif.setValeur(valeur[i]);
            indicateurQualitatifs.add(indicateurQualitatif);
        }

        for (Object element : indicateurQualitatifs) {
            derby.create((IndicateurQualitatif) element);
        }
    }

    //@Test
    public void readAllIndicateurQualitatifMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllIndicateurQualitatifDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readIndicateurQualitatifMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readIndicateurQualitatifDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateIndicateurQualitatifMysql() throws SQLException {
        IndicateurQualitatif indicateurQualitatif = mysql.findByProperty("nom", "Iso");
        indicateurQualitatif.setNom("zozo");
        mysql.update(indicateurQualitatif);
    }

    //@Test
    public void updateeIndicateurQualitatifDerby() throws SQLException {
        IndicateurQualitatif indicateurQualitatif = derby.findByProperty("nom", "Iso");
        indicateurQualitatif.setNom("zozo");
        derby.update(indicateurQualitatif);
    }

    //@Test
    public void deleteIndicateurQualitatifMysql() throws SQLException {
        IndicateurQualitatif indicateurQualitatif = mysql.findByProperty("nom", "Doss");
        mysql.delete(indicateurQualitatif);
    }

    //@Test
    public void deleteIndicateurQualitatifDerby() throws SQLException {
        IndicateurQualitatif indicateurQualitatif = derby.findByProperty("nom", "Doss");

        derby.delete(indicateurQualitatif);
    }

    /**
     * @return the mysql
     */
    public IndicateurQualitatifRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(IndicateurQualitatifRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public IndicateurQualitatifRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(IndicateurQualitatifRepository derby) {
        this.derby = derby;
    }
}
