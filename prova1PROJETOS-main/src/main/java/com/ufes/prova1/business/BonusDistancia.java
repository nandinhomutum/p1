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
public class BonusDistancia implements CalcularBonus{

    @Override
    public BigDecimal calcular(Funcionario funcionario) {
        BigDecimal valorBonus = BigDecimal.ZERO ;
        if ( funcionario.getKm().intValue() <= 10){
          valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.05"));  
        } else if ( funcionario.getKm().intValue() <= 50){
          valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.1"));  
        } else if ( funcionario.getKm().intValue() > 50){
          valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.15"));  
        }
        
        return valorBonus;
   }
}
