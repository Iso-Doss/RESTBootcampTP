/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeDeBailleur;
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
public class BailleurJsonTest {

    //@Test
    public void createBailleurJson() throws IOException {
        List<Bailleur> bailleurs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Bailleur bailleur = new Bailleur();
            bailleur.setNom(nom[i]);
            bailleur.setTypeDeBailleur(TypeDeBailleur.privé);
            bailleurs.add(bailleur);
        }

        ObjectMapper mapper = new ObjectMapper();
        File bailleurFile = new File("bailleur.json");

        mapper.writeValue(bailleurFile, bailleurs);
    }
}
