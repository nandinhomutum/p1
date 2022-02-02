/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.ufes.prova1.business.CargoBusiness;
import com.ufes.prova1.model.Cargo;
import com.ufes.prova1.utilidades.Notificador;
import com.ufes.prova1.view.CargosView;

/**
 *
 * @author nandi
 */
public class CargosPresenter {
	CargosView view;
	CargoBusiness business;

	public CargosPresenter() {
            this.business = CargoBusiness.getInstance();
		configurarTela();		
	}

	private void configurarTela() {
		this.view = new CargosView();
		criarEventListeners();
		BuscarCargos();
		this.view.setVisible(true);
	}

	private void criarEventListeners() {
		view.getFecharButton().addActionListener(new ActionListener() {           
	        @Override
	       public void actionPerformed(ActionEvent ae) {
	                sair();
	        } 
	    });
		
		view.getNovoCargoButton().addActionListener(new ActionListener() {           
	        @Override
	       public void actionPerformed(ActionEvent ae) {
	                novo();
	        } 
	    });
		
		view.getEditarCargoButton().addActionListener(new ActionListener() {           
	        @Override
	       public void actionPerformed(ActionEvent ae) {
	                alterar();
	        } 
	    });
		
		view.getExcluirCargoButton().addActionListener(new ActionListener() {           
	        @Override
	       public void actionPerformed(ActionEvent ae) {
	                excluir();
	        } 
	    });
	}

	public void BuscarCargos() {
		DefaultTableModel tabela = (DefaultTableModel) view.getCargosTable().getModel();

		List<Cargo> cargos = business.getAll();

		for (Cargo cargo : cargos) {
			tabela.addRow(new Object[] { cargo.getId(), cargo.getNome() });
		}

		view.getCargosTable().setModel(tabela);
		tabela.fireTableDataChanged();
	}
        
        public void novo(){
            new AlteracaoCargoPresenter();
            this.view.dispose();
        }
        
        public void alterar(){
            int linhaSelecionada = this.view.getCargosTable().getSelectedRow();
            if(linhaSelecionada > -1){
              BigInteger id = new BigInteger(this.view.getCargosTable().getModel().getValueAt(linhaSelecionada, 0).toString());
              String nome = this.view.getCargosTable().getModel().getValueAt(linhaSelecionada, 1).toString();
              new AlteracaoCargoPresenter(new Cargo(id,nome));
              this.view.dispose();
            }else{
                Notificador.getInstance().disparaAviso("Selecione um cargo para editar");
            }
        }
        
        public void excluir(){
            int linhaSelecionada = this.view.getCargosTable().getSelectedRow();
            if(linhaSelecionada > -1){
              BigInteger id = new BigInteger(this.view.getCargosTable().getModel().getValueAt(linhaSelecionada, 0).toString());
              business.delete(id);
              this.view.dispose();
              configurarTela();
            }else{
                Notificador.getInstance().disparaAviso("Selecione um cargo para excluir");
            }
        }

	public void sair() {
		new PrincipalPresenter();
		this.view.dispose();
	}
}
