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
@Path("/bailleurs")
public class BailleurRestController {

    private BailleurRepository derby = new BailleurRepository("tpJpa");

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Bailleur> bailleurs = derby.findAll();
        return Response.status(200).entity(bailleurs).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
        Bailleur bailleur = derby.findById("id", id);

        if (bailleur == null) {
            return Response.status(404).entity(bailleur).build();
        } else {
            return Response.status(200).entity(bailleur).build();
        }
    }

    @GET
    @Path("/param/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByParam(@PathParam("param") String param) throws SQLException {
        List<Bailleur> bailleurs = (List<Bailleur>) derby.findByProperty("nom", param);

        if (bailleurs == null) {
            return Response.status(404).entity(bailleurs).build();
        } else {
            return Response.status(200).entity(bailleurs).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Bailleur bailleur) throws SQLException {
        derby.delete(bailleur);
        return Response.status(200).entity(bailleur).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Bailleur bailleur) throws SQLException {
        derby.create(bailleur);
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Bailleur bailleur) throws SQLException {
        derby.create(bailleur);
    }
}
