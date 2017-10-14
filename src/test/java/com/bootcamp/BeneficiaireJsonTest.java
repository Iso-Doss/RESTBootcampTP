/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Beneficiaire;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Iso-Doss
 */
public class BeneficiaireJsonTest {

    //@Test
    public void createBailleurJson() throws IOException {
        List<Beneficiaire> beneficiaires = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Beneficiaire beneficiaire = new Beneficiaire();
            beneficiaire.setNom(nom[i]);
            beneficiaires.add(beneficiaire);
        }

        ObjectMapper mapper = new ObjectMapper();
        File beneficiaireFile = new File("beneficiare.json");

        mapper.writeValue(beneficiaireFile, beneficiaires);
    }
}
