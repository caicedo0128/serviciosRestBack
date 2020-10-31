/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ec.data;

import co.com.ec.domain.Serie;
import java.util.List;

/**
 *
 * @author caice
 */
public interface SerieDao {
    
    public List<Serie> findAll();
    
    public Serie encontrarSerie(Serie serie);
    
    public void insertarSerie(Serie serie);
    
    public void actualizarSerie(Serie serie);
    
    public void eliminarSerie(Serie serie);
    
}
