/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UFES.prova1.Business;

import com.UFES.prova1.Model.Bonus;
import com.UFES.prova1.Model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class BonusNormal implements CalcularBonus{

    @Override
    public double calcular(Funcionario funcionario) {
        double valorBonus = funcionario.getSalario() * 0.05;
        return valorBonus;
    }
    
    
    
    
}