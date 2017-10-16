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
@Path("/fournisseur")
public class FournisseurRestController {

    private FournisseurRepository derby = new FournisseurRepository("tpJpa");

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Fournisseur> fournisseurs = derby.findAll();
        return Response.status(200).entity(fournisseurs).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListById(@PathParam("id") int id) throws SQLException {
        Fournisseur fournisseur = derby.findById("id", id);

        if (fournisseur == null) {
            return Response.status(404).entity(fournisseur).build();
        } else {
            return Response.status(200).entity(fournisseur).build();
        }
    }

    @GET
    @Path("/list/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByParam(@PathParam("param") String param) throws SQLException {
        List<Fournisseur> fournisseurs = (List<Fournisseur>) derby.findByProperty("nom", param);

        if (fournisseurs == null) {
            return Response.status(404).entity(fournisseurs).build();
        } else {
            return Response.status(200).entity(fournisseurs).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeleteListByParam(@PathParam("id") int id) throws SQLException {
        Fournisseur fournisseur = derby.findById("id", id);
        derby.delete(fournisseur);
        return Response.status(200).entity(fournisseur).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Fournisseur fournisseur) throws SQLException {
        derby.create(fournisseur);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Fournisseur fournisseur) throws SQLException {
        derby.create(fournisseur);
    }
}
