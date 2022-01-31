/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UFES.prova1.Presenter;

import com.UFES.prova1.DAO.FuncionarioDAO;
import com.UFES.prova1.DAO.HistoricoBonusDAO;
import com.UFES.prova1.DAO.HistoricoSalarioDAO;
import com.UFES.prova1.Model.Funcionario;
import com.UFES.prova1.Model.HistoricoBonus;
import com.UFES.prova1.Model.HistoricoSalario;
import com.UFES.prova1.View.TelaHistoricoFuncionariosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class FuncionarioHistoricoPresenter {
    
    private TelaHistoricoFuncionariosView view;
    private final Funcionario funcionario;
    
    public FuncionarioHistoricoPresenter(Funcionario funcionario) throws SQLException {
        ConfigurarTela();
        this.funcionario = funcionario;
        preencherTela(funcionario);
        PreencherTabelaBonus();
        PreencherTabelaSalario();    
       
        
        view.getJbSair().addActionListener(new ActionListener() {
           
           public void actionPerformed(ActionEvent ae) {
                   view.dispose();
            } 
        });
        
    }
    
     private void ConfigurarTela(){
        this.view = new TelaHistoricoFuncionariosView();
        view.setVisible(true);
    }

    private void preencherTela(Funcionario funcionario) {
        view.getJlbNome().setText(funcionario.getNome());
        view.getJlbCargo().setText(funcionario.getCargo());
        view.getjLBIdade().setText(String.valueOf(funcionario.getIdade()));
        view.getJlbSalario().setText(String.valueOf(funcionario.getSalario()));
    }
    
    public void PreencherTabelaBonus() throws SQLException{
      String nomeBuscado = funcionario.getNome();
      DefaultTableModel tabela = new DefaultTableModel();
      tabela.addColumn("BONUS");
      tabela.addColumn("VALOR RECEBIDO");
      tabela.addColumn("MES");
      tabela.addColumn("ANO");
      
      ArrayList<HistoricoBonus> listaBonus = HistoricoBonusDAO.getHistoricoDAOInstance().getAllFuncionario(nomeBuscado);
      for (HistoricoBonus bonus: listaBonus){
          tabela.addRow(new Object[]{ bonus.getTipoBonus(),
              bonus.getValorBonus(),
              bonus.getMes(),
              bonus.getAno()
          });
         
      }
       view.getjTBonus().setModel(tabela);
    }

    private void PreencherTabelaSalario() throws SQLException {
        String nomeBuscado = funcionario.getNome();
      DefaultTableModel tabela1 = new DefaultTableModel();
      tabela1.addColumn("BONUS");
      tabela1.addColumn("VALOR RECEBIDO");
      tabela1.addColumn("MES");
      tabela1.addColumn("ANO");
      
      ArrayList<HistoricoSalario> listaSalario = HistoricoSalarioDAO.getHistoricoDAOInstance().getAllFuncionario(nomeBuscado);
      for (HistoricoSalario salario: listaSalario){
          tabela1.addRow(new Object[]{ salario.getBonus(),
              salario.getSalarioFinal(),
              salario.getMes(),
              salario.getAno()
          });
         
      }
       view.getjTSalario().setModel(tabela1);
    }

}
