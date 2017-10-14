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
public class BeneficiaireTest {

    private BeneficiaireRepository mysql = new BeneficiaireRepository("com.bootcamp_TpJPA");
    private BeneficiaireRepository derby = new BeneficiaireRepository("tpJpa");

    //@Test
    public void createBeneficiaireMysql() throws SQLException {
        List<Beneficiaire> beneficiaires = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Beneficiaire beneficiaire = new Beneficiaire();
            beneficiaire.setNom(nom[i]);
            beneficiaires.add(beneficiaire);
        }

        for (Object element : beneficiaires) {
            mysql.create((Beneficiaire) element);
        }

    }

    //@Test
    public void createBeneficiaireDerby() throws SQLException {
        List<Beneficiaire> beneficiaires = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Beneficiaire beneficiaire = new Beneficiaire();
            beneficiaire.setNom(nom[i]);
            beneficiaires.add(beneficiaire);
        }

        for (Object element : beneficiaires) {
            derby.create((Beneficiaire) element);
        }
    }

    //@Test
    public void readAllBeneficiaireMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllBeneficiaireDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readBeneficiaireMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readBeneficiaireDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateBeneficiaireMysql() throws SQLException {
        Beneficiaire beneficiaire = mysql.findByProperty("nom", "Iso");
        beneficiaire.setNom("zozo");
        mysql.update(beneficiaire);
    }

    //@Test
    public void updateeBeneficiaireDerby() throws SQLException {
        Beneficiaire beneficiaire = derby.findByProperty("nom", "Iso");
        beneficiaire.setNom("zozo");
        derby.update(beneficiaire);
    }

    //@Test
    public void deleteBeneficiaireMysql() throws SQLException {
        Beneficiaire beneficiaire = mysql.findByProperty("nom", "Doss");
        mysql.delete(beneficiaire);
    }

    //@Test
    public void deleteBeneficiaireDerby() throws SQLException {
        Beneficiaire beneficiaire = derby.findByProperty("nom", "Doss");

        derby.delete(beneficiaire);
    }

    /**
     * @return the mysql
     */
    public BeneficiaireRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(BeneficiaireRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public BeneficiaireRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(BeneficiaireRepository derby) {
        this.derby = derby;
    }
}
