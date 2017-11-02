/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.repositories.*;
import com.bootcamp.jpa.entities.*;
import java.beans.*;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.*;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import io.swagger.annotations.*;

/**
 *
 * @author Iso-Doss
 */
@Path("/bailleurs")
@Api(value = "/bailleurs", description = "Api gérant  les bailleurs ")
public class BailleurRestController {

    private final BailleurRepository derby = new BailleurRepository("tpJpa");

    /**
     * Méthode qui récupère et retourne la liste des Bailleurs Status code 200
     * en cas de success et status code 404 en cas d'echec
     *
     * @return @throws SQLException
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Liste",
            notes = "Liste des Bailleurs",
            response = void.class,
            responseContainer = "Bailleur"
    )
    @ApiResponses({
        @ApiResponse(code = 20, message = "Bailleurs trouvé")
        ,
     @ApiResponse(code = 404, message = "Aucun bailleurs trouvé")
    })
    public Response getList() throws SQLException {
        List<Bailleur> bailleurs = derby.findAll();
        if (bailleurs == null) {
            return Response.status(404).entity(bailleurs).build();
        } else {
            return Response.status(200).entity(bailleurs).build();
        }
    }

    /**
     * Méthode qui récupère et retourne un Bailleur grace a son id passé en
     * paramètre Status code 200 en cas de success et status code 404 en cas
     * d'echec
     *
     * @param id
     * @return
     * @throws SQLException
     */
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

    /**
     * Méthode qui récupère et retourne un Bailleur grace a un de ces champs et
     * sa valeur passé en parametre Status code 200 en cas de success et status
     * code 404 en cas d'echec
     *
     * @param champs
     * @param valeur
     * @return
     * @throws SQLException
     */
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

    /**
     * Méthode qui permet de supprimer un Bailleur grace a son id passé en
     * paramètre Status code 200 en cas de success et status code 404 en cas
     * d'echec
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) throws SQLException {
        Bailleur bailleur = derby.findById("id", id);
        if (bailleur == null) {
            return Response.status(404).entity(bailleur).build();
        } else {
            derby.delete(bailleur);
            return Response.status(200).entity(bailleur).build();
        }
    }

    /**
     * Méthode qui créer, récupère et retourne un Bailleur Status code 200 en
     * cas de success et status code 404 en cas d'echec
     *
     * @param bailleur
     * @return
     * @throws SQLException
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Bailleur bailleur) throws SQLException {
        derby.create(bailleur);
        Bailleur findBailleur = derby.findById("id", bailleur.getId());
        if (findBailleur == null) {
            return Response.status(404).entity(findBailleur).build();
        } else {
            return Response.status(201).entity(findBailleur).build();
        }
    }

    /**
     * Méthode qui permet de mettre à jour un Bailleur grace a son id passé en
     * paramètre Status code 200 en cas de success et status code 404 en cas
     * d'echec
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id) throws SQLException {
        Bailleur bailleur = derby.findById("id", id);
        if (bailleur == null) {
            return Response.status(404).entity(bailleur).build();
        } else {
            derby.update(bailleur);
            return Response.status(201).entity(bailleur).build();
        }
    }

    /**
     * Méthode qui récupère et retourne une reponse partielle un Bailleur (en
     * fonction des fields, champs preciser en parametre) grace a son id passé
     * en paramètre Status code 200 en cas de success et status code 404 en cas
     * d'echec
     *
     * @param id
     * @param fields
     * @return
     * @throws SQLException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    @GET
    @Path("/reponse_partielle/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdParam(@PathParam("id") int id, @QueryParam("fields") String fields) throws SQLException, IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String[] fieldArray = fields.split(",");
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

    /**
     * Méthode qui récupère et retourne la liste des Bailleurs et applique une
     * pagination sur le resultat retourner Status code 200 en cas de success et
     * status code 404 en cas d'echec
     *
     * @return @throws SQLException
     */
    @GET
    @Path("/reponse_paginer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListPaginer() throws SQLException {
        List<Bailleur> bailleurs = derby.findAll();
        if (bailleurs == null) {
            return Response.status(404).entity(bailleurs).build();
        } else {
            return Response.status(200).entity(bailleurs).build();
        }
    }

    /**
     * Méthode qui récupère et les Bailleurs correspondant aux filtres passer en
     * parametresStatus code 200 en cas de success et status code 404 en cas
     * d'echec
     *
     * @param fields
     * @return
     * @throws SQLException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    @GET
    @Path("/reponse_filtrer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListFiltrer(@QueryParam("fields") String[] fields) throws SQLException, IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        /*String[] fieldArray = fields.split(",");
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
         */
        return null;
    }

    /**
     * Méthode qui récupère et les Bailleurs trier grace aux filtres passer en
     * parametres Status code 200 en cas de success et status code 404 en cas
     * d'echec
     *
     * @param fields
     * @return
     * @throws SQLException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    @GET
    @Path("/reponse_trier")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListTrier(@QueryParam("fields") String[] fields) throws SQLException, IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        /*String[] fieldArray = fields.split(",");
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
         */
        return null;
    }

    /**
     * Méthode qui verifie l'existant d'une chaine de caractere dans un tableau
     * de chaine de caractere La chaine et le tableau etant passe en parametre a
     * la fonction
     *
     */
    private boolean check(String[] fields, String field) {
        for (String field1 : fields) {
            if (field.equals(field1)) {
                return true;
            }
        }
        return false;
    }
}
