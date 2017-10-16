/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.repositories.*;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Iso-Doss
 */
@Path("/programme")
public class ProgrammeRestController {

    private ProgrammeRepository derby = new ProgrammeRepository("tpJpa");

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Programme> programmes = derby.findAll();
        return Response.status(200).entity(programmes).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListById(@PathParam("id") int id) throws SQLException {
        Programme programme = derby.findById("id", id);

        if (programme == null) {
            return Response.status(404).entity(programme).build();
        } else {
            return Response.status(200).entity(programme).build();
        }
    }

    @GET
    @Path("/list/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByParam(@PathParam("param") String param) throws SQLException {
        List<Programme> programmes = (List<Programme>) derby.findByProperty("nom", param);

        if (programmes == null) {
            return Response.status(404).entity(programmes).build();
        } else {
            return Response.status(200).entity(programmes).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeleteListByParam(@PathParam("id") int id) throws SQLException {
        Programme programme = derby.findById("id", id);
        derby.delete(programme);
        return Response.status(200).entity(programme).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Programme programme) throws SQLException {
        derby.create(programme);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Programme programme) throws SQLException {
        derby.create(programme);
    }
}
