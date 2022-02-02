/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.dao;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ufes.prova1.model.Cargo;

/**
 *
 * @author nandi
 */
public class CargoDAO implements DAOInterface<Cargo> {

	private static CargoDAO INSTANCE;

	public CargoDAO() {

	}

	public static CargoDAO getCargoDAOInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CargoDAO();
			return INSTANCE;
		} else {
			return INSTANCE;
		}
	}

	@Override
	public List<Cargo> getAll() {
		// @SuppressWarnings("static-access")
		// EntityManagerFactory emf = new
		// Persistence().createEntityManagerFactory("persistenceUnit");
		EntityManager em = Conexao.getInstance().abreTransacao();// emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cargo> cq = cb.createQuery(Cargo.class);
		Root<Cargo> rootEntry = cq.from(Cargo.class);
		CriteriaQuery<Cargo> all = cq.select(rootEntry);
		TypedQuery<Cargo> allQuery = em.createQuery(all);
		List<Cargo> retorno = allQuery.getResultList();
		em.getTransaction().commit();
		//em.close();
		//emf.close();
		return retorno;
	}
		
	public Cargo get(String nome) {
		// @SuppressWarnings("static-access")
		// EntityManagerFactory emf = new
		// Persistence().createEntityManagerFactory("persistenceUnit");
		EntityManager em = Conexao.getInstance().abreTransacao();// emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cargo> cq = cb.createQuery(Cargo.class);
		Root<Cargo> rootEntry = cq.from(Cargo.class);
		CriteriaQuery<Cargo> criteria = cq.select(rootEntry);
		cq.where(rootEntry.get("nome").in(Arrays.asList(nome)));
		TypedQuery<Cargo> query = em.createQuery(criteria);
		try {
			Cargo retorno = query.getSingleResult();
			em.getTransaction().commit();
			//em.close();
			//emf.close();
		  return retorno;
		} catch (NoResultException nre) {
			em.getTransaction().commit();
			//em.close();
			//emf.close();
			return null;
		}
	}


	@Override
	public Cargo get(BigInteger id) {
		// @SuppressWarnings("static-access")
		// EntityManagerFactory emf = new
		// Persistence().createEntityManagerFactory("persistenceUnit");
		EntityManager em = Conexao.getInstance().abreTransacao();// emf.createEntityManager();
		em.getTransaction().begin();
		Cargo retorno = em.find(Cargo.class, id);
		em.getTransaction().commit();
		//em.close();
		//emf.close();
		return retorno;
	}

	@Override
	public void save(Cargo cargo) {
		// @SuppressWarnings("static-access")
		// EntityManagerFactory emf = new
		// Persistence().createEntityManagerFactory("persistenceUnit");
		EntityManager em = Conexao.getInstance().abreTransacao();// emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(cargo);
		em.getTransaction().commit();
		//em.close();
		//emf.close();
	}

	@Override
	public void delete(BigInteger id) {
		// @SuppressWarnings("static-access")
		// EntityManagerFactory emf = new
		// Persistence().createEntityManagerFactory("persistenceUnit");
		EntityManager em = Conexao.getInstance().abreTransacao();// emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<Cargo> query = criteriaBuilder.createCriteriaDelete(Cargo.class);
		Root<Cargo> root = query.from(Cargo.class);
		query.where(root.get("id").in(Arrays.asList(id)));
		em.createQuery(query).executeUpdate();
		em.getTransaction().commit();
		//em.close();
		//emf.close();
	}
}