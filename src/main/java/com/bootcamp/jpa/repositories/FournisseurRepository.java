/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Fournisseur;

/**
 *
 * @author Iso-Doss
 */
public class FournisseurRepository extends BaseRepository<Fournisseur> {

    public FournisseurRepository(String UnitPersistence) {
        super(UnitPersistence, Fournisseur.class);
    }
}
