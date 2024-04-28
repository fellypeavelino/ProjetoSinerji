/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudospedro.sinerji.model.implement;

import com.estudospedro.sinerji.entities.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author felly
 */
public class EnderecoModel  implements DAO<Endereco> {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceSinerji");
    private static EntityManager entityManager = emf.createEntityManager();
    
    @Override
    public List<Endereco> findAll() {
        return entityManager.createQuery("from Endereco").getResultList();
    }

    @Override
    public Endereco findById(long id) {
        return entityManager.find(Endereco.class, id);
    }

    @Override
    public List<Endereco> findByName(String name) {
        Query query = entityManager.createQuery("from Endereco where logradouro like :plogradouro");
	query.setParameter("plogradouro", "%" + name + "%");
	return query.getResultList();
    }
    
    public List<Endereco> findByPessoa(long id) {
        Query query = entityManager.createQuery("from Endereco where id_pessoa = :pPessoaId");
	query.setParameter("pPessoaId", id);
	return query.getResultList();
    }

    @Override
    public boolean save(Endereco en) {
                boolean result = false;
        try {
            entityManager.getTransaction().begin();
            if (en.getId() != null) {
                entityManager.merge(en);
                return true;
            }
            entityManager.persist(en);
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
            Endereco en = findById(id);
            entityManager.remove(en);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
