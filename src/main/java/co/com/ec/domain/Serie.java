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
    @NamedQuery(name = "Serie.findAll", query = "SELECT p FROM Serie p")
})
public class Serie implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int idSerie;
    
    private String nombre;
    
    private String anio;
    
    public Serie(){
        
    }
    
    public Serie(int idSerie){
        this.idSerie = idSerie;
    }

    public Serie(int idSerie, String nombre, String anio) {
        this.idSerie = idSerie;
        this.nombre = nombre;
        this.anio = anio;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
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
        return "Serie{" + "idSerie=" + idSerie + ", nombre=" + nombre + ", anio=" + anio + '}';
    }
    
}
