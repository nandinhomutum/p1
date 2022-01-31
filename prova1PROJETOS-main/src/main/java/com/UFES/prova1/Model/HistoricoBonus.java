/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UFES.prova1.Model;

/**
 *
 * @author Administrador
 */
public class HistoricoBonus {
    private int id;
    private String nome;
    private String tipoBonus;
    private double valorBonus;
    private int mes;
    private int ano;

    public HistoricoBonus( String nome, String tipoBonus, double valorBonus, int mes, int ano) {
        this.id = id;
        this.nome = nome;
        this.tipoBonus = tipoBonus;
        this.valorBonus = valorBonus;
        this.mes = mes;
        this.ano = ano;
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

    public String getTipoBonus() {
        return tipoBonus;
    }

    public void setTipoBonus(String tipoBonus) {
        this.tipoBonus = tipoBonus;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    @Override
    public String toString() {
        return "HistoricoBonus{" + "id=" + id + ", nome=" + nome + ", tipoBonus=" + tipoBonus + ", valorBonus=" + valorBonus + ", mes=" + mes + ", ano=" + ano + '}';
    }

   

   
    
}
