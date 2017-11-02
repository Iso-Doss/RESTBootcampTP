/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.repositories.BailleurRepository;
import javax.ws.rs.Path;

/**
 *
 * @author Iso-Doss
 */
@Path("/test_base")
public class TestBaseRestController extends BaseRestController<Bailleur, BailleurRepository> {

    public TestBaseRestController(BailleurRepository instanceOfClassRepository) {
        super(instanceOfClassRepository);
    }


}
