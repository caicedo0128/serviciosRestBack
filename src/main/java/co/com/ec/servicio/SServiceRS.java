/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ec.servicio;

import co.com.ec.data.SerieDao;
import co.com.ec.domain.Serie;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author caice
 */
@Stateless
@Path("/series")
public class SServiceRS {
    
    @Inject
    private SerieDao serieDao;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Serie> findAllSerie(){
        List<Serie> series = serieDao.findAll();
        System.out.println("series: " + series);
        return series;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Serie encontrarSerie(@PathParam("id") int id){
        Serie serie = serieDao.encontrarSerie(new Serie(id));
        System.out.println("serie: " + serie.getNombre());
        return serie;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Serie agregarSerie(Serie serie){
        serieDao.insertarSerie(serie);
        System.out.println("se inserto serie: " + serie.getIdSerie() + " - " + serie.getNombre());
        return serie;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarSerie(@PathParam("id") int id, Serie serieMd){
        Serie serie = serieDao.encontrarSerie(new Serie(id));
        if (serie != null){
            serieDao.actualizarSerie(serieMd);
            System.out.println("se modifico serie: " + serie.getIdSerie() + " - " + serie.getNombre());
            return Response.ok().entity(serieMd).build();
        }
        else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarSerie(@PathParam("id") int id){
        serieDao.eliminarSerie(new Serie(id));
        System.out.println("se elimino la serie: " + id);
        return Response.ok().build();
    }
    
}
