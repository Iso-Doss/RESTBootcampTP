/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.repositories.*;
import com.bootcamp.jpa.entities.*;
import io.swagger.annotations.Api;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Iso-Doss
 */
@Path("/bailleurs")
@Api(value = "/livrab", description = "Api gérant  les livrables ")
public class BailleurRestController {

    private BailleurRepository derby = new BailleurRepository("tpJpa");

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Liste",
            notes = "Liste des Bailleurs",
            response = void.class,
            responseContainer = "Bailleur"
    )
    /**
     * @ApiResponses({
     * @ApiResponse(code = 201, message = "Ajout avec succès") ,
     * @ApiResponse(code = 404, message = "impossible d'ajouter ce livrable")
    })*
     */
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
    @Path("/parametre/{champs}/{valeur}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByParam(@PathParam("champs") String champs, @PathParam("valeur") String valeur) throws SQLException {
        List<Bailleur> bailleurs = (List<Bailleur>) derby.findByProperty(champs, valeur);

        if (bailleurs == null) {
            return Response.status(404).entity(bailleurs).build();
        } else {
            return Response.status(200).entity(bailleurs).build();
        }
    }

    @DELETE
    @Path("/")
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

    @GET
    @Path("/reponse_partiel/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdParam(@PathParam("id") int id, @QueryParam("fields") String fields) throws SQLException, IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String[] fieldArray = fields.split(",");
        //BailleurRepository bailleurRepository = new BailleurRepository("punit-mysql");
        Bailleur bailleur = derby.findById("id", id);
        Map<String, Object> responseMap = new HashMap<>();
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(Bailleur.class).getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

            Method method = propertyDescriptor.getReadMethod();
            if (check(fieldArray, propertyDescriptor.getName())) {
                responseMap.put(propertyDescriptor.getName(), method.invoke(bailleur));
            }
            System.out.println(method.invoke(bailleur));
        }
        return Response.status(200).entity(responseMap).build();
    }

    private boolean check(String[] fields, String field) {

        for (String field1 : fields) {
            if (field.equals(field1)) {
                return true;
            }
        }
        return false;
    }
}
