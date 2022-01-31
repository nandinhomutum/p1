/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Presenter;

import com.UFES.prova1.DAO.CargoDAO;
import com.UFES.prova1.DAO.FuncionarioDAO;
import com.UFES.prova1.Model.Bonus;
import com.UFES.prova1.Model.Cargo;
import com.UFES.prova1.Model.Funcionario;
import com.UFES.prova1.Utilidades.ManipuladorComboBox;
import com.UFES.prova1.View.TelaManterFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nandi
 */
public class ManterFuncionarioPresenter {
    TelaManterFuncionarioView view;
    
    public ManterFuncionarioPresenter() throws SQLException{
        configurarTela();
        
    view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent ae) {
                   view.dispose();
            } 
        });
    view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent ae) {
                   //view.dispose();
            } 
        });
    
    view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent ae) {
                try {
                    cadastrarFuncionario();
                } catch (SQLException ex) {
                    Logger.getLogger(ManterFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) { 
                    Logger.getLogger(ManterFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new BuscarFuncionarioPresenter();
                } catch (SQLException ex) {
                    Logger.getLogger(ManterFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
                   view.dispose();
            } 
        });
    
    
    view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent ae) {
                   //view.dispose();
            } 
        });
 
    
    }
    
    private void configurarTela() throws SQLException{
        this.view = new TelaManterFuncionarioView();
        BuscarCargo();
        this.view.setVisible(true);
       
    
    }
    
    
    public void cadastrarFuncionario() throws SQLException, ParseException{

        String nome = view.getTxtNome().getText();
        int idade = Integer.parseInt(view.getTxtIdade().getText());
        double salario = Float.parseFloat(view.getTxtSalario().getText());
        String cargo = view.getCbCargo().getSelectedItem().toString();
        String dataAdmissao = view.getTxtAdmissao().getText();
        int falta = 0;
        int km = Integer.parseInt(view.getjTKm().getText());
        Date data = new Date();
       
        Funcionario funcionario = new Funcionario(nome, idade, salario, cargo, dataAdmissao, falta, km);
        FuncionarioDAO.getFuncionarioDAOInstance().save(funcionario);
    }
    
    public void BuscarCargo () throws SQLException{
        ArrayList<String> cargos = new ArrayList<>();
        ArrayList<Cargo> cargoLista = CargoDAO.getCargoDAOInstance().getAll();
        cargoLista.forEach(cargo -> {
            cargos.add(cargo.getNome());
        });
        ManipuladorComboBox.getInstance().PreencherComboBox(cargos, view.getCbCargo());
    }
}
