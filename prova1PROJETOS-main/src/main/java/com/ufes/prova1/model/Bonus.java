/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nandi
 */
@Getter
@Setter
public abstract class Bonus implements IBonus{
	private BigDecimal percentual;
	private BigDecimal valor;
}
   
