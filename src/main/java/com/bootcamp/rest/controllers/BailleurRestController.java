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
        Bailleur bailleur = derby.findByProperty("id", id);

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
        Bailleur bailleur = derby.findByProperty("nom", param);

        if (bailleur == null) {
            return Response.status(404).entity(bailleur).build();
        } else {
            return Response.status(200).entity(bailleur).build();
        }
    }

    /*
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeleteListByParam(@QueryParam("id") String msg) throws SQLException {
        Bailleur bailleur = derby.delete();
        return Response.status(200).entity(bailleur).build();
    }
     */
}
