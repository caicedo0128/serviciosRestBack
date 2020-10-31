/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ec.data;

import co.com.ec.domain.Pelicula;
import java.util.List;

/**
 *
 * @author caice
 */
public interface PeliculaDao {
    
    public List<Pelicula> findAll();
    
    public Pelicula encontrarPelicula(Pelicula pelicula);
    
    public void insertarPelicula(Pelicula pelicula);
    
    public void actualizarPelicula(Pelicula pelicula);
    
    public void eliminarPelicula(Pelicula pelicula);
}
