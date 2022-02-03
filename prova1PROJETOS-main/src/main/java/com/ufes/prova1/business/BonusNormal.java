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
public class BonusNormal implements CalcularBonus{

    @Override
    public BigDecimal calcular(Funcionario funcionario) {
        BigDecimal valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.05"));
        return valorBonus;
    }
    
    
    
    
}
