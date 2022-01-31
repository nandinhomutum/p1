/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Presenter;

import com.UFES.prova1.View.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nandi
 */
public class PrincipalPresenter {
    
    private TelaPrincipalView view;
    
    public PrincipalPresenter(){
        configurarTela();
     
       
    view.getMenuManterFuncionario().addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent ae) {
                try {
                    new ManterFuncionarioPresenter();
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });        
      

     view.getMenuBuscarFuncionario().addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent ae) {
                try {
                    new BuscarFuncionarioPresenter();
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
 
     view.getMenuCalcularSalario().addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent ae) {
                   new SalarioPresenter();
            } 
        });        
      
  
    }
             
    private void configurarTela(){
        this.view = new TelaPrincipalView();
        this.view.setVisible(true);
       
    
    }
    
}
