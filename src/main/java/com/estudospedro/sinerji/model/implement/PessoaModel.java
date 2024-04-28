/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudospedro.sinerji.model.implement;

import com.estudospedro.sinerji.entities.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author felly
 */

public class PessoaModel implements DAO<Pessoa> {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceSinerji");
    private static EntityManager entityManager = emf.createEntityManager();
    
    @Override
    public List<Pessoa> findAll() {
        return entityManager.createQuery("from Pessoa").getResultList();
    }

    @Override
    public Pessoa findById(long id) {
        return entityManager.find(Pessoa.class, 15L);
    }

    @Override
    public List<Pessoa> findByName(String name) {
	Query query = entityManager.createQuery("from Pessoa where nome like :pNome");
	query.setParameter("pNome", "%" + name + "%");
	return query.getResultList();
    }

    @Override
    public boolean save(Pessoa p) {
        boolean result = false;
        try {
            entityManager.getTransaction().begin();
            if (p.getId() != null) {
                entityManager.merge(p);
                return true;
            }
            entityManager.persist(p);
            result = true;
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            result = false;
            entityManager.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public boolean delete(long id) {
        try {
            entityManager.getTransaction().begin();
            Pessoa p = findById(id);
            System.out.println("delete "+p.toString());
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
