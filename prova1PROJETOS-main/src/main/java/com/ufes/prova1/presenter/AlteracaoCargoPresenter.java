/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.presenter;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import com.ufes.prova1.business.CargoBusiness;
import com.ufes.prova1.model.Cargo;
import com.ufes.prova1.view.AlteracaoCargoView;

/**
 *
 * @author nandi
 */
public class AlteracaoCargoPresenter {
	AlteracaoCargoView view;
	CargoBusiness business;

	public AlteracaoCargoPresenter() {
            this.business = CargoBusiness.getInstance();
	    configurarTela();
		
	}
        
        public AlteracaoCargoPresenter(Cargo cargo) {
            this.business = CargoBusiness.getInstance();
		configurarTela(cargo);
	}

	private void configurarTela() {
		this.view = new AlteracaoCargoView();
        this.view.getAlteraLabel().setText("Novo");
        criarEventListeners();
		this.view.setVisible(true);
	}

	private void configurarTela(Cargo cargo) {
		this.view = new AlteracaoCargoView();
		this.view.getAlteraLabel().setText("Editando");
		this.view.getIdLabel().setText("ID:");
		this.view.getIdNumberLabel().setText(cargo.getId().toString());
		this.view.getCargoTextField().setText(cargo.getNome());
		criarEventListeners();
		this.view.setVisible(true);
	}
        
	private void criarEventListeners() {
		view.getCancelarButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				sair();
			}
		});

		view.getOkButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				salvar();
			}
		});
	}

	public void salvar() {
		String id = this.view.getIdNumberLabel().getText();
		if (null == id || "".equals(id)) {
			business.cadastrarCargo(this.view.getCargoTextField().getText());
		} else {
			business.update(new BigInteger(id), this.view.getCargoTextField().getText());
		}
		sair();
	}
        
	public void sair() {
		new CargosPresenter();
		this.view.dispose();
	}
}
