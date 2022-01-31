/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Presenter;

import com.UFES.prova1.DAO.FuncionarioDAO;
import com.UFES.prova1.DAO.HistoricoSalarioDAO;
import com.UFES.prova1.Model.Funcionario;
import com.UFES.prova1.Model.HistoricoSalario;
import com.UFES.prova1.View.TelaCalcularSalarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nandi
 */
public class SalarioPresenter {
    
    private TelaCalcularSalarioView view;
    
    public SalarioPresenter(){
        configurarTela();
    
      view.getBtnFechar().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
                   view.dispose();
            } 
        });
      
      view.getBtnBuscar().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
               
               try {
                   String mes = view.getJcbMes().getSelectedItem().toString();
                    String ano = view.getJcbAno().getSelectedItem().toString();
                   PreencherTabelaSalarioMes(mes, ano);
               } catch (SQLException ex) {
                   Logger.getLogger(SalarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
               }
            } 
        });
      view.getBtnCalculo().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
                   //view.dispose();
            } 
        });
      view.getBtnDataCalculo().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
                   //view.dispose();
            } 
        });
      
      view.getBtnListarTodos().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
               try {   
                   PreencherTabelaSalario();
               } catch (SQLException ex) {
                   Logger.getLogger(SalarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
               }
           } 
        });
    }
    private void configurarTela(){
        this.view = new TelaCalcularSalarioView();
        this.view.setVisible(true);
    }
    
    private void PreencherTabelaSalario() throws SQLException {
      DefaultTableModel tabela1 = new DefaultTableModel();
      tabela1.addColumn("FUNCIONARIO");
      tabela1.addColumn("SALARIO BASE");
      tabela1.addColumn("BONUS");
      tabela1.addColumn("VALOR RECEBIDO");
      tabela1.addColumn("MES");
      tabela1.addColumn("ANO");
      
      ArrayList<HistoricoSalario> listaSalario = HistoricoSalarioDAO.getHistoricoDAOInstance().getAll();
      for (HistoricoSalario salario: listaSalario){
        
        Funcionario funcionario = FuncionarioDAO.getFuncionarioDAOInstance().getNome(salario.getNome());
          
          tabela1.addRow(new Object[]{ salario.getNome(),
              funcionario.getSalario(),
              salario.getBonus(),
              salario.getSalarioFinal(),
              salario.getMes(),
              salario.getAno()
          });
         
      }
       view.getTabelaFuncionarios().setModel(tabela1);
    }
    
    private void PreencherTabelaSalarioMes(String mes, String ano) throws SQLException {
      DefaultTableModel tabela1 = new DefaultTableModel();
      tabela1.addColumn("FUNCIONARIO");
      tabela1.addColumn("SALARIO BASE");
      tabela1.addColumn("BONUS");
      tabela1.addColumn("VALOR RECEBIDO");
      tabela1.addColumn("MES");
      tabela1.addColumn("ANO");
      
      ArrayList<HistoricoSalario> listaSalario = HistoricoSalarioDAO.getHistoricoDAOInstance().getAllMes(mes, ano);
      for (HistoricoSalario salario: listaSalario){
        
        Funcionario funcionario = FuncionarioDAO.getFuncionarioDAOInstance().getNome(salario.getNome());
          
          tabela1.addRow(new Object[]{ salario.getNome(),
              funcionario.getSalario(),
              salario.getBonus(),
              salario.getSalarioFinal(),
              salario.getMes(),
              salario.getAno()
          });
         
      }
       view.getTabelaFuncionarios().setModel(tabela1);
    }
}
