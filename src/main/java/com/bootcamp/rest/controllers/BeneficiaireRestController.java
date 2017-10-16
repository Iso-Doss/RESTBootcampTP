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
@Path("/beneficiaire")
public class BeneficiaireRestController {

    private BeneficiaireRepository derby = new BeneficiaireRepository("tpJpa");

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Beneficiaire> beneficiaires = derby.findAll();
        return Response.status(200).entity(beneficiaires).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListById(@PathParam("id") int id) throws SQLException {
        Beneficiaire beneficiaire = derby.findById("id", id);

        if (beneficiaire == null) {
            return Response.status(404).entity(beneficiaire).build();
        } else {
            return Response.status(200).entity(beneficiaire).build();
        }
    }

    @GET
    @Path("/list/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByParam(@PathParam("param") String param) throws SQLException {
        List<Beneficiaire> beneficiaires = (List<Beneficiaire>) derby.findByProperty("nom", param);

        if (beneficiaires == null) {
            return Response.status(404).entity(beneficiaires).build();
        } else {
            return Response.status(200).entity(beneficiaires).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeleteListByParam(@PathParam("id") int id) throws SQLException {
        Beneficiaire beneficiaire = derby.findById("id", id);
        derby.delete(beneficiaire);
        return Response.status(200).entity(beneficiaire).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Beneficiaire beneficiaire) throws SQLException {
        derby.create(beneficiaire);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Beneficiaire beneficiaire) throws SQLException {
        derby.create(beneficiaire);
    }
}
