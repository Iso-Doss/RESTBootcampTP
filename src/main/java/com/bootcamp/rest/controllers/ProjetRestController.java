/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.repositories.*;
import com.bootcamp.jpa.entities.*;
import java.sql.SQLException;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ws.rs.*;

/**
 *
 * @author Iso-Doss
 */
@Path("/projet")
public class ProjetRestController {

    private ProjetRepository derby = new ProjetRepository("tpJpa");

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Projet> projets = derby.findAll();
        return Response.status(200).entity(projets).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListById(@PathParam("id") int id) throws SQLException {
        Projet projet = derby.findById("id", id);

        if (projet == null) {
            return Response.status(404).entity(projet).build();
        } else {
            return Response.status(200).entity(projet).build();
        }
    }

    @GET
    @Path("/list/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByParam(@PathParam("param") String param) throws SQLException {
        List<Projet> projets = (List<Projet>) derby.findByProperty("nom", param);

        if (projets == null) {
            return Response.status(404).entity(projets).build();
        } else {
            return Response.status(200).entity(projets).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeleteListByParam(@PathParam("id") int id) throws SQLException {
        Projet projet = derby.findById("id", id);
        derby.delete(projet);
        return Response.status(200).entity(projet).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Projet projet) throws SQLException {
        derby.create(projet);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Projet projet) throws SQLException {
        derby.create(projet);
    }
}
