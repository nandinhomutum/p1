/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UFES.prova1.Business;


import com.UFES.prova1.Model.Funcionario;

/**
 *
 * @author Administrador
 */
public class BonusFalta implements CalcularBonus{
    
   
  
    @Override
    public double calcular(Funcionario funcionario) {
        double valorBonus = 0 ;
        System.out.println(" faltas dentro da funçao "+funcionario.getFaltas());
        if(funcionario.getFaltas() == 0 ){
            System.out.println(" entrou na 1 "+funcionario.getFaltas());
             valorBonus = funcionario.getSalario() * 0.1;
        } else if(funcionario.getFaltas() <= 3 ){
            System.out.println(" entrou na 2 "+funcionario.getFaltas());
           valorBonus = funcionario.getSalario() * 0.05;
        } else if(funcionario.getFaltas() > 3 ){
            System.out.println(" entrou na 1 "+funcionario.getFaltas());
            valorBonus = funcionario.getSalario() * 0.01;
        }
        
        return valorBonus;
    }
       
}
