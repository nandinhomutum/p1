/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UFES.prova1.Model;

/**
 *
 * @author Administrador
 */
public class HistoricoSalario {
    private int id;
    private String nome;
    private double bonus;
    private double salarioFinal;
    private int mes;
    private int ano;

    public int getId() {
        return id;
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

   

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    
    public double getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public HistoricoSalario(String nome, double bonus, double salarioFinal, int mes, int ano) {
        this.nome = nome;
        this.bonus = bonus;
        this.salarioFinal = salarioFinal;
        this.mes = mes;
        this.ano = ano;
    }
    

 
    
    
}
