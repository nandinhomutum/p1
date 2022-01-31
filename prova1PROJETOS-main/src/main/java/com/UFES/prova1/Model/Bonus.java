/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Model;

import java.util.Date;

/**
 *
 * @author nandi
 */
public class Bonus {
    
    private String nome;
    
    
     public Bonus(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Bonus{" + ", nome=" + nome +'}';
    }

}
   
