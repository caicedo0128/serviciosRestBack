/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ec.implement;

import co.com.ec.data.PeliculaDao;
import co.com.ec.domain.Pelicula;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author caice
 */
@Stateless
public class PeliculaDaoImpl implements PeliculaDao{
    
    @PersistenceContext(unitName = "PeliculasSeriesPU")
    EntityManager em;

    @Override
    public List<Pelicula> findAll() {
        return em.createNamedQuery("Pelicula.findAll").getResultList();
    }

    @Override
    public Pelicula encontrarPelicula(Pelicula pelicula) {
        return em.find(Pelicula.class, pelicula.getIdPelicula());
    }

    @Override
    public void insertarPelicula(Pelicula pelicula) {
        em.persist(pelicula);
        em.flush();
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        em.merge(pelicula);
    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {
        em.remove(em.merge(pelicula));
    }
    
}
