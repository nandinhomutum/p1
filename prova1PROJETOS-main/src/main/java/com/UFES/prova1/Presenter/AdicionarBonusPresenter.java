/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Presenter;

import com.UFES.prova1.Business.BonusDecimoTerceiro;
import com.UFES.prova1.Business.BonusDistancia;
import com.UFES.prova1.Business.BonusFalta;
import com.UFES.prova1.Business.BonusFuncionarioMes;
import com.UFES.prova1.Business.BonusGeneroso;
import com.UFES.prova1.Business.BonusIdade;
import com.UFES.prova1.Business.BonusNormal;
import com.UFES.prova1.DAO.HistoricoBonusDAO;
import com.UFES.prova1.DAO.HistoricoSalarioDAO;
import com.UFES.prova1.Model.Funcionario;
import com.UFES.prova1.Model.HistoricoBonus;
import com.UFES.prova1.Model.HistoricoSalario;
import com.UFES.prova1.View.TelaFuncionarioBonusView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nandi
 */
public class AdicionarBonusPresenter {

    private TelaFuncionarioBonusView view;
    private final Funcionario funcionario;

    public AdicionarBonusPresenter(Funcionario funcionario) {
        ConfigurarTela();
        this.funcionario = funcionario;
        preencherTela(funcionario);
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent ae) {
                   view.dispose();
            } 
        });
        
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent ae) {
              
             String tipoBonus;
             double valorBonus;
             double bonusAcumulado = 0;
             int mes = Integer.parseInt(view.getCbMes().getSelectedItem().toString());
             int ano = Integer.parseInt(view.getJcbAno().getSelectedItem().toString());
                   if(view.getCkDecimo().isSelected() == true){
                    
                       
                      tipoBonus = "BONUS 13 SALARIO";
                      valorBonus = 0;
                      BonusDecimoTerceiro bonus = new BonusDecimoTerceiro();
                      valorBonus = bonus.calcular(funcionario);
                      bonusAcumulado += valorBonus;
                      HistoricoBonus historico = new HistoricoBonus( funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
                 try {
                     HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
                 } catch (SQLException ex) {
                     Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                 }
                      
                   }
          
              
                   if(view.getCkDistancia().isSelected() == true){
                       
                       tipoBonus = "BONUS DISTANCIA";
                      valorBonus = 0;
                      BonusDistancia bonus = new BonusDistancia();
                      valorBonus = bonus.calcular(funcionario);
                      bonusAcumulado += valorBonus;
                      HistoricoBonus historico = new HistoricoBonus( funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
                      try {
                     HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
                 } catch (SQLException ex) {
                     Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                 }
                   }
                   
                    if(view.getJckIdade().isSelected() == true){
                        
                        tipoBonus = "BONUS IDADE";
                        valorBonus = 0;
                      BonusIdade bonus = new BonusIdade();
                      valorBonus = bonus.calcular(funcionario);
                      bonusAcumulado += valorBonus;
                      HistoricoBonus historico = new HistoricoBonus( funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
                   try {
                     HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
                 } catch (SQLException ex) {
                     Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    }
                   
                   if(view.getCkFuncionarioMes().isSelected() == true){
                       
                       tipoBonus = "BONUS FUNCIONARIO MES";
                       valorBonus = 0;
                      BonusFuncionarioMes bonus = new BonusFuncionarioMes();
                      valorBonus = bonus.calcular(funcionario);
                      bonusAcumulado += valorBonus;
                      HistoricoBonus historico = new HistoricoBonus( funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
                   try {
                     HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
                 } catch (SQLException ex) {
                     Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                 }
                   }
                   
          if(view.getjCBBonus().toString().equals("NORMAL")){
              
              tipoBonus = "BONUS NORMAL";
              valorBonus = 0;
                      
                      BonusNormal bonus = new BonusNormal();
                      valorBonus = bonus.calcular(funcionario);
                      bonusAcumulado += valorBonus;
                      HistoricoBonus historico = new HistoricoBonus( funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
                   try {
                     HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
                 } catch (SQLException ex) {
                     Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                 }
            } else {
              
                            tipoBonus = "BONUS GENEROSO";
                            valorBonus = 0;
                            
                            BonusGeneroso bonus = new BonusGeneroso();
                            valorBonus = bonus.calcular(funcionario);
                            HistoricoBonus historico = new HistoricoBonus( funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
                        try {
                     HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
                 } catch (SQLException ex) {
                     Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                 }
          }
          int numFaltas = Integer.parseInt(view.getTxtFaltas().getText());
          funcionario.setFaltas(numFaltas);
          tipoBonus = "BONUS POR FALTA";
          valorBonus = 0;
          BonusFalta bonus = new BonusFalta();
                System.out.println("faltas: "+ funcionario.getFaltas());
          valorBonus = bonus.calcular(funcionario);
          bonusAcumulado += valorBonus;
          System.out.println("valor bonus calculado: "+ valorBonus);
          HistoricoBonus historico = new HistoricoBonus( funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
          try {
                     HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
                 } catch (SQLException ex) {
                     Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                 }
          
          double salario = 0;
          
          salario = funcionario.getSalario() + bonusAcumulado;
          HistoricoSalario historicoSalario = new HistoricoSalario(funcionario.getNome(), bonusAcumulado, salario, mes, ano);
                try {
                    HistoricoSalarioDAO.getHistoricoDAOInstance().save(historicoSalario);
                } catch (SQLException ex) {
                    Logger.getLogger(AdicionarBonusPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
          
            } 
        });
        
    }
    
    private void ConfigurarTela(){
        this.view = new TelaFuncionarioBonusView();
        view.setVisible(true);
    }

    private void preencherTela(Funcionario funcionario) {
        
        view.getLblNome().setText(funcionario.getNome());
        view.getLblCargo().setText(funcionario.getNome());
        view.getLblDataAdmissao().setText(funcionario.getDataAdmissao());
        view.getLblCargo().setText(funcionario.getCargo());
        view.getLbId().setText("funcionario.getId()");
        
    }
    
}
