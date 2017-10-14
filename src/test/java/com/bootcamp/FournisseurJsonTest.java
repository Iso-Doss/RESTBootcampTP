/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Fournisseur;
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
public class FournisseurJsonTest {

    //@Test
    public void createBailleurJson() throws IOException {
        List<Fournisseur> fournisseurs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setNom(nom[i]);
            fournisseurs.add(fournisseur);
        }

        ObjectMapper mapper = new ObjectMapper();
        File fournisseurFile = new File("fournisseur.json");

        mapper.writeValue(fournisseurFile, fournisseurs);
    }
}
