/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsalunos20191.wsrest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Fagno
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of wsrest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces()
    public String getJson() {
        //TODO return proper representation object
        return "Teste funcionando!";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @GET //para enviar parametro: http://localhost:8080/teste/webresources/generic/ola/kiko
    @Produces() //produzir texto comum
    @Path("ola/{nome}") //inclui o @Path devido haver dois métodos @GET para o "generic"
    public String ola(@PathParam(value = "nome") String nome) { 
        return "Olá "+nome;
    }
    
    
}
