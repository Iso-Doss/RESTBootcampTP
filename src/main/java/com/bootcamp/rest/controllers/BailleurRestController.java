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
@Path("/bailleur")
public class BailleurRestController {

    private BailleurRepository derby = new BailleurRepository("tpJpa");

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Bailleur> bailleurs = derby.findAll();
        return Response.status(200).entity(bailleurs).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListById(@PathParam("id") int id) throws SQLException {
        Bailleur bailleur = derby.findById("id", id);

        if (bailleur == null) {
            return Response.status(404).entity(bailleur).build();
        } else {
            return Response.status(200).entity(bailleur).build();
        }
    }

    @GET
    @Path("/list/{param}")
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
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeleteListByParam(@PathParam("id") int id) throws SQLException {
        Bailleur bailleur = derby.findById("id", id);
        derby.delete(bailleur);
        return Response.status(200).entity(bailleur).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Bailleur bailleur) throws SQLException {
        derby.create(bailleur);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Bailleur bailleur) throws SQLException {
        derby.create(bailleur);
    }
}
