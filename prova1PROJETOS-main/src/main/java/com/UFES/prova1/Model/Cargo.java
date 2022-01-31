/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Model;

/**
 *
 * @author nandi
 */
public class Cargo {
    
    private int id;
    private String nome;

    public Cargo(String nome) {
        this.nome = nome;
    }

    public Cargo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void add(Cargo cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
