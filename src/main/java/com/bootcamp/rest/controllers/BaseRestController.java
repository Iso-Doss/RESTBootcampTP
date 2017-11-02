/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Iso-Doss
 * @param <CR>
 */
public abstract class BaseRestController<C, CR> {

    private CR instanceOfClassRepository;

    public BaseRestController(CR instanceOfClassRepository) {
        this.instanceOfClassRepository = instanceOfClassRepository;
    }

    /**
     * @return the instanceOfClassRepository
     */
    public CR getInstanceOfClassRepository() {
        return instanceOfClassRepository;
    }

    /**
     * @param instanceOfClassRepository the instanceOfClassRepository to set
     */
    public void setInstanceOfClassRepository(CR instanceOfClassRepository) {
        this.instanceOfClassRepository = instanceOfClassRepository;
    }

    /*    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException, NoSuchMethodException {
        Method method = getInstanceOfClassRepository().getClass().getMethod("findAll");
        method.invoke(C);
        
        if (cs == null) {
            return Response.status(404).entity(cs).build();
        } else {
            return Response.status(200).entity(cs).build();
        }
    }
     */
}
