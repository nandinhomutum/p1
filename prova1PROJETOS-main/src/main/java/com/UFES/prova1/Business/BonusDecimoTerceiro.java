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
public class BonusDecimoTerceiro implements CalcularBonus{

    @Override
    public double calcular(Funcionario funcionario) {
        double valorBonus = 0 ;
        valorBonus = funcionario.getSalario();
        return valorBonus;
    }
    
}
