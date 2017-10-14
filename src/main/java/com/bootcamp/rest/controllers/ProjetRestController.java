/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.entities.*;
import javax.ws.rs.core.*;
import javax.ws.rs.*;

/**
 *
 * @author Iso-Doss
 */
@Path("/projet")
public class ProjetRestController {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() {
        Projet projet = new Projet();
        projet.setNom("Projet");
        projet.setObjectif("Obj");
        return Response.status(200).entity(projet).build();
    }

}
