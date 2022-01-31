/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Presenter;

import com.UFES.prova1.DAO.FuncionarioDAO;
import com.UFES.prova1.Model.Funcionario;
import com.UFES.prova1.View.TelaBuscarFuncionarioView;
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
public class BuscarFuncionarioPresenter {
    
    private TelaBuscarFuncionarioView view;
    
    public BuscarFuncionarioPresenter() throws SQLException{
        ConfigurarTela();
        
      view.getBtnFechar().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
                   view.dispose();
            } 
        });
      
      view.getBtnBonus().addActionListener(new ActionListener() {
           
                      public void actionPerformed(ActionEvent ae) {
               try {
                   Funcionario funcionario = pegarFuncionario();
                   new FuncionarioHistoricoPresenter(funcionario);
               } catch (SQLException ex) {
                   Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
               }
                  
            } 

        });
      
      view.getBtnBuscar().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
                   //view.dispose();
            } 
        });
      
      view.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               }
           
        });
      
      view.getBtnNovo().addActionListener(new ActionListener() {
           
           @Override
           public void actionPerformed(ActionEvent ae) {
               try {
                   new ManterFuncionarioPresenter();
               } catch (SQLException ex) {
                   Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
               }
            } 
        });
      
      view.getBtnAdicionar().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
               try {
                   Funcionario funcionario = pegarFuncionario();
                   new AdicionarBonusPresenter(funcionario);
               } catch (SQLException ex) {
                   Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
               }
                  
            } 
        });
    }
    
    
    private void ConfigurarTela() throws SQLException{
        this.view = new TelaBuscarFuncionarioView();
        PreencherTabela();
        view.setVisible(true);
    }
    
    
    public void PreencherTabela() throws SQLException{
      DefaultTableModel tabela = new DefaultTableModel();
      tabela.addColumn("ID");
      tabela.addColumn("NOME");
      tabela.addColumn("IDADE");
      tabela.addColumn("SALARIO BASE");
      tabela.addColumn("CARGO");
      ArrayList<Funcionario> listaFuncionarios = FuncionarioDAO.getFuncionarioDAOInstance().getAll();
      for (Funcionario funcionario: listaFuncionarios){
          tabela.addRow(new Object[]{ funcionario.getId(),
              funcionario.getNome(),
              funcionario.getIdade(),
              funcionario.getSalario(),
              funcionario.getCargo()
          });
         
      }
       view.getTbFuncionarios().setModel(tabela);
    }
    
    public Funcionario pegarFuncionario() throws SQLException{
        DefaultTableModel tabela = (DefaultTableModel) view.getTbFuncionarios().getModel();
        int linha = view.getTbFuncionarios().getSelectedRow();
        int id = (int) view.getTbFuncionarios().getValueAt(linha, 0);
       return FuncionarioDAO.getFuncionarioDAOInstance().get(id);  
    }
    
}
