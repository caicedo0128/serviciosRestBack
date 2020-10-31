/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ec.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author caice
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
})
public class Pelicula implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int idPelicula;
    
    private String nombre;
    
    private String anio;
    
    public Pelicula(){
        
    }
    
    public Pelicula(int idPelicula){
        this.idPelicula = idPelicula;
    }
    
    public Pelicula (int idPelicula, String nombre, String anio){
        this.idPelicula = idPelicula;
        this.nombre = nombre;
        this.anio = anio;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "idPelicula=" + idPelicula + ", nombre=" + nombre + '}';
    }
    
}
