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
public class ImpactTest {

    private ImpactRepository mysql = new ImpactRepository("com.bootcamp_TpJPA");
    private ImpactRepository derby = new ImpactRepository("tpJpa");

    @Test
    public void createImpactMysql() throws SQLException {
        List<Impact> impacts = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Impact impact = new Impact();
            impact.setNom(nom[i]);
            impact.setTypeImapct(TypeImapct.social);
            impacts.add(impact);
        }

        for (Object element : impacts) {
            mysql.create((Impact) element);
        }

    }

    @Test
    public void createImpactDerby() throws SQLException {
        List<Impact> impacts = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Impact impact = new Impact();
            impact.setNom(nom[i]);
            impact.setTypeImapct(TypeImapct.social);
            impacts.add(impact);
        }

        for (Object element : impacts) {
            derby.create((Impact) element);
        }
    }

    //@Test
    public void readAllImpactMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllImpactDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readImpactMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readImpactDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateImpactMysql() throws SQLException {
        Impact impact = mysql.findByProperty("nom", "Iso");
        impact.setNom("zozo");
        mysql.update(impact);
    }

    //@Test
    public void updateeImpactDerby() throws SQLException {
        Impact impact = derby.findByProperty("nom", "Iso");
        impact.setNom("zozo");
        derby.update(impact);
    }

    //@Test
    public void deleteImpactMysql() throws SQLException {
        Impact impact = mysql.findByProperty("nom", "Doss");
        mysql.delete(impact);
    }

    //@Test
    public void deleteImpactDerby() throws SQLException {
        Impact impact = derby.findByProperty("nom", "Doss");

        derby.delete(impact);
    }

    /**
     * @return the mysql
     */
    public ImpactRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(ImpactRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public ImpactRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(ImpactRepository derby) {
        this.derby = derby;
    }
}
