/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Impact;

/**
 *
 * @author Iso-Doss
 */
public class ImpactRepository extends BaseRepository<Impact> {

    public ImpactRepository(String unitPersistence) {
        super(unitPersistence, Impact.class);
    }
}
