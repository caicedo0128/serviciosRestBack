/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ec.implement;

import co.com.ec.data.SerieDao;
import co.com.ec.domain.Serie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author caice
 */
@Stateless
public class SerieDaoImpl implements SerieDao{
    
    @PersistenceContext(unitName = "PeliculasSeriesPU")
    EntityManager em;

    @Override
    public List<Serie> findAll() {
        return em.createNamedQuery("Serie.findAll").getResultList();
    }

    @Override
    public Serie encontrarSerie(Serie serie) {
        return em.find(Serie.class, serie.getIdSerie());
    }

    @Override
    public void insertarSerie(Serie serie) {
        em.persist(serie);
        em.flush();
    }

    @Override
    public void actualizarSerie(Serie serie) {
        em.merge(serie);
    }

    @Override
    public void eliminarSerie(Serie serie) {
        em.remove(em.merge(serie));
    }
    
}
