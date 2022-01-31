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
public class BonusDistancia implements CalcularBonus{

    @Override
    public double calcular(Funcionario funcionario) {
        double valorBonus = 0 ;
        if ( funcionario.getKm() <= 10){
          valorBonus = funcionario.getSalario() * 0.05;  
        } else if ( funcionario.getKm() <= 50){
          valorBonus = funcionario.getSalario() * 0.1;  
        } else if ( funcionario.getKm() > 50){
          valorBonus = funcionario.getSalario() * 0.15;  
        }
        
        return valorBonus;
   }
}
