/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.prova1.business;


import java.math.BigDecimal;

import com.ufes.prova1.model.Funcionario;

/**
 *
 * @author Administrador
 */
public class BonusFalta implements CalcularBonus{
    
   
  
    @Override
    public BigDecimal calcular(Funcionario funcionario) {
    	BigDecimal valorBonus = BigDecimal.ZERO;
        System.out.println(" faltas dentro da funçao "+funcionario.getFaltas());
        if(funcionario.getFaltas().intValue() == 0 ){
            System.out.println(" entrou na 1 "+funcionario.getFaltas());
             valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        } else if(funcionario.getFaltas().intValue() <= 3 ){
            System.out.println(" entrou na 2 "+funcionario.getFaltas());
           valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.05"));
        } else if(funcionario.getFaltas().intValue() > 3 ){
            System.out.println(" entrou na 1 "+funcionario.getFaltas());
            valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.01"));
        }
        
        return valorBonus;
    }
       
}
