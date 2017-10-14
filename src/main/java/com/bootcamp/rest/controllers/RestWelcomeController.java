/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author Iso-Doss
 */
@Path("/hello")
public class RestWelcomeController {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = " get Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    //QueryParam
    @GET
    @Path("/test")
    public Response getQMsg(@QueryParam("param") String msg, @QueryParam("param2") String msg2) {
        String output = " QueryParam Jersey say : " + msg + " et " + msg2;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{param}/{param2}")
    public Response get3Msg(@PathParam("param") String msg, @PathParam("param2") String msg2) {
        String output = " get Jersey say : " + msg + " et " + msg2;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{param}/bootcamp/{param2}")
    public Response get2Msg(@PathParam("param") String msg, @PathParam("param2") String msg2) {
        String output = " get Jersey say : " + msg + " et " + msg2;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/")
    public Response home() {
        String output = " index ";
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/{param}")
    public Response postMsg(@PathParam("param") String msg) {
        String output = "Post Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @DELETE
    @Path("/{param}")
    public Response deleteMsg(@PathParam("param") String msg) {
        String output = "delete Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @PUT
    @Path("/{param}")
    public Response putMsg(@PathParam("param") String msg) {
        String output = "put Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }


    /*@GET
    @Path("/")
    public Response getMsgHome() {

        String output = "index";

        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/{param}")
    public Response getMsgPost(@PathParam("param") String msg) {

        String output = "Jersey say Post: " + msg;

        return Response.status(200).entity(output).build();

    }

    @PUT
    @Path("/{param}")
    public Response getMsgPut(@PathParam("param") String msg) {

        String output = "Jersey say Put: " + msg;

        return Response.status(200).entity(output).build();

    }

    @DELETE
    @Path("/{param}")
    public Response getMsgDelete(@PathParam("param") String msg) {

        String output = "Jersey say Delete: " + msg;

        return Response.status(200).entity(output).build();

    }*/
}
