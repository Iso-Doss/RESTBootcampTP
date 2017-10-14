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
public class ProgrammeTest {

    private ProgrammeRepository mysql = new ProgrammeRepository("com.bootcamp_TpJPA");
    private ProgrammeRepository derby = new ProgrammeRepository("tpJpa");

    //@Test
    public void createProgrammeMysql() throws SQLException {
        List<Programme> programmes = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String objectif[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Programme programme = new Programme();
            programme.setNom(nom[i]);
            programme.setObjectif(objectif[i]);
            programme.setDateDeDebut(Date.from(Instant.MIN));
            programme.setDateDeFin(Date.from(Instant.MIN));
            programme.setBudgetEffectif(1220);
            programme.setBudgetPrevisionnel(1220);
            programme.setNom(nom[i]);
            programmes.add(programme);
        }

        for (Object element : programmes) {
            mysql.create((Programme) element);
        }

    }

    //@Test
    public void createProgrammeDerby() throws SQLException {
        List<Programme> programmes = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        String objectif[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Programme programme = new Programme();
            programme.setNom(nom[i]);
            programme.setObjectif(objectif[i]);
            programme.setDateDeDebut(Date.from(Instant.MIN));
            programme.setDateDeFin(Date.from(Instant.MIN));
            programme.setBudgetEffectif(1220);
            programme.setBudgetPrevisionnel(1220);
            programme.setNom(nom[i]);
            programmes.add(programme);
        }

        for (Object element : programmes) {
            derby.create((Programme) element);
        }
    }

    //@Test
    public void readAllProgrammeMysql() throws SQLException {
        mysql.findAll();

    }

    //@Test
    public void readAllProgrammeDerby() throws SQLException {
        derby.findAll();
    }

    //@Test
    public void readProgrammeMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    //@Test
    public void readProgrammeDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    //@Test
    public void updateProgrammeMysql() throws SQLException {
        Programme programme = mysql.findByProperty("nom", "Iso");
        programme.setNom("zozo");
        mysql.update(programme);
    }

    //@Test
    public void updateeProgrammeDerby() throws SQLException {
        Programme programme = derby.findByProperty("nom", "Iso");
        programme.setNom("zozo");
        derby.update(programme);
    }

    //@Test
    public void deleteProgrammeMysql() throws SQLException {
        Programme programme = mysql.findByProperty("nom", "Doss");
        mysql.delete(programme);
    }

    //@Test
    public void deleteProgrammeDerby() throws SQLException {
        Programme programme = derby.findByProperty("nom", "Doss");

        derby.delete(programme);
    }

    /**
     * @return the mysql
     */
    public ProgrammeRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(ProgrammeRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public ProgrammeRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(ProgrammeRepository derby) {
        this.derby = derby;
    }
}
