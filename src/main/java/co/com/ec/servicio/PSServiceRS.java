/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ec.servicio;

import co.com.ec.data.PeliculaDao;
import co.com.ec.domain.Pelicula;
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
@Path("/peliculas")
public class PSServiceRS {
    
    @Inject
    private PeliculaDao peliculaDao;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Pelicula> findAll(){
        List<Pelicula> peliculas = peliculaDao.findAll();
        System.out.println("peliculas: " + peliculas);
        return peliculas;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Pelicula encontrarPelicula(@PathParam("id") int id){
        Pelicula pelicula = peliculaDao.encontrarPelicula(new Pelicula(id));
        System.out.println("pelicula: " + pelicula.getNombre());
        return pelicula;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Pelicula agregarPelicula(Pelicula pelicula){
        peliculaDao.insertarPelicula(pelicula);
        System.out.println("se inserto pelicula: " + pelicula.getIdPelicula() + " - " + pelicula.getNombre());
        return pelicula;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarPelicula(@PathParam("id") int id, Pelicula peliculaMd){
        Pelicula pelicula = peliculaDao.encontrarPelicula(new Pelicula(id));
        if (pelicula != null){
            peliculaDao.actualizarPelicula(peliculaMd);
            System.out.println("se modifico pelicula: " + pelicula.getIdPelicula() + " - " + pelicula.getNombre());
            return Response.ok().entity(peliculaMd).build();
        }
        else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarPelicula(@PathParam("id") int id){
        peliculaDao.eliminarPelicula(new Pelicula(id));
        System.out.println("se elimino la pelicula: " + id);
        return Response.ok().build();
    }
    
    
}
