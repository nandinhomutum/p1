/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import com.ufes.prova1.dao.FuncionarioDAO;
import com.ufes.prova1.dao.HistoricoSalarioDAO;
import com.ufes.prova1.model.Funcionario;
import com.ufes.prova1.model.HistoricoSalario;
import com.ufes.prova1.view.TelaCalcularSalarioView;

/**
 *
 * @author nandi
 */
public class SalarioPresenter {
    
    private TelaCalcularSalarioView view;
    
    public SalarioPresenter(){
        configurarTela();
    }
    private void configurarTela(){
        this.view = new TelaCalcularSalarioView();
        criarEventListeners();
        this.view.setVisible(true);
    }
    
    private void criarEventListeners() {
		view.getBtnFechar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				sair();
			}
		});

		view.getBtnBuscar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				buscar();
			}
		});

		view.getBtnCalculo().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				// view.dispose();
			}
		});

		view.getBtnDataCalculo().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				// view.dispose();
			}
		});
		
		view.getBtnListarTodos().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				try {
					preencherTabelaSalario();
				} catch (SQLException ex) {
					Logger.getLogger(SalarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
	}
    
	private void preencherTabelaSalario() throws SQLException {
      DefaultTableModel tabela1 = new DefaultTableModel();
      tabela1.addColumn("FUNCIONARIO");
      tabela1.addColumn("SALARIO BASE");
      tabela1.addColumn("BONUS");
      tabela1.addColumn("VALOR RECEBIDO");
      tabela1.addColumn("MES");
      tabela1.addColumn("ANO");
      
      List<HistoricoSalario> listaSalario = HistoricoSalarioDAO.getHistoricoDAOInstance().getAll();
      for (HistoricoSalario salario: listaSalario){
        
        Funcionario funcionario = FuncionarioDAO.getFuncionarioDAOInstance().get(salario.getFuncionario().getId());
          
          tabela1.addRow(new Object[]{ salario.getFuncionario().getNome(),
              funcionario.getSalario(),
              salario.getBonus(),
              salario.getSalarioFinal(),
              salario.getMes(),
              salario.getAno()
          });
         
      }
       view.getTabelaFuncionarios().setModel(tabela1);
    }
    
    private void preencherTabelaSalarioMes(String mes, String ano){
      DefaultTableModel tabela1 = new DefaultTableModel();
      tabela1.addColumn("FUNCIONARIO");
      tabela1.addColumn("SALARIO BASE");
      tabela1.addColumn("BONUS");
      tabela1.addColumn("VALOR RECEBIDO");
      tabela1.addColumn("MES");
      tabela1.addColumn("ANO");
      
      List<HistoricoSalario> listaSalario = HistoricoSalarioDAO.getHistoricoDAOInstance().getAllMes(mes, ano);
      for (HistoricoSalario salario: listaSalario){
        
        Funcionario funcionario = FuncionarioDAO.getFuncionarioDAOInstance().get(salario.getFuncionario().getId());
          
          tabela1.addRow(new Object[]{ salario.getFuncionario().getNome(),
              funcionario.getSalario(),
              salario.getBonus(),
              salario.getSalarioFinal(),
              salario.getMes(),
              salario.getAno()
          });
         
      }
       view.getTabelaFuncionarios().setModel(tabela1);
    }
    
    private void buscar() {
    	String mes = view.getJcbMes().getSelectedItem().toString();
        String ano = view.getJcbAno().getSelectedItem().toString();
        preencherTabelaSalarioMes(mes, ano);
    }
    
	public void sair() {
		new PrincipalPresenter();
		this.view.dispose();
	}
}
