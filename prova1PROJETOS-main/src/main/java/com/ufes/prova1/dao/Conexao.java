/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nandi
 */
public class Conexao {
    

  private Connection conn;
  private EntityManagerFactory emf;
  private EntityManager em;

    private Conexao() {
    	    	
    }

    public static Conexao getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final Conexao INSTANCE = new Conexao();
    }

    @Deprecated
    public Connection connect() {
        if (null == this.getConn()) {
            try {
                // db parameters  
                String url = "jdbc:sqlite:bancoDB.db";
                // create a connection to the database  
                this.conn = DriverManager.getConnection(url);

                System.out.println("Conectou ao banco");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.conn;
    }
    
    @SuppressWarnings("static-access")
	public EntityManager abreTransacao() {
    	if(null != em) {
    		if(em.isJoinedToTransaction()) {
    			em.close();
    			emf.close();
    			emf = new Persistence().createEntityManagerFactory("persistenceUnit");
        		em = emf.createEntityManager();        		
    		}
    		return em;
    	} else {
			emf = new Persistence().createEntityManagerFactory("persistenceUnit");
    		em = emf.createEntityManager();
    		return em;
    	}
    }
    
    @Deprecated
    public void disconect(){
        if (null != this.getConn()) {        
            try {                
              conn.close();
              System.out.println("Desconectou do banco");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    @Deprecated
    public Connection connect(String url) {
        if (null == this.getConn()) {
            try {
                // db parameters                  
                // create a connection to the database  
                this.conn = DriverManager.getConnection(url);

                System.out.println("Conexao Estabelecida");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.conn;
    }
    @Deprecated
    private Connection getConn() {
        return conn;
    }
}