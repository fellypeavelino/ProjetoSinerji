/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudospedro.sinerji.model.implement;

import java.util.List;

/**
 *
 * @author felly
 */
public interface DAO <T> {
    	List<T> findAll();

	T findById(Integer id);

	List<T> findByName(String name);

	boolean save(T t);

	boolean delete(Integer id);
}
