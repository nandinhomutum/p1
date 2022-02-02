/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ufes.prova1.business.FuncionarioBusiness;
import com.ufes.prova1.dao.CargoDAO;
import com.ufes.prova1.model.Cargo;
import com.ufes.prova1.model.Funcionario;
import com.ufes.prova1.utilidades.ManipuladorComboBox;
import com.ufes.prova1.view.TelaManterFuncionarioView;

/**
 *
 * @author nandi
 */
public class ManterFuncionarioPresenter {
	TelaManterFuncionarioView view;
	FuncionarioBusiness business;

	public ManterFuncionarioPresenter() {
		this.business = FuncionarioBusiness.getInstance();
		configurarTela();
	}
	
	public ManterFuncionarioPresenter(BigInteger id, String nomeCargo) {
        this.business = FuncionarioBusiness.getInstance();
	    configurarTela(id, nomeCargo);		
    }

	private void configurarTela() {
		this.view = new TelaManterFuncionarioView();
		BuscarCargos();
		criarEventListeners();
		this.view.setVisible(true);

	}
	
	private void configurarTela(BigInteger id, String nomeCargo) {
		this.view = new TelaManterFuncionarioView();
		BuscarCargos();
		criarEventListeners();
		preencherCamposView(id, nomeCargo);
		this.view.setVisible(true);
	}
	
	private void preencherCamposView(BigInteger id, String nomeCargo) {
		Funcionario funcionario = business.get(id);
		this.view.getIdLabel1().setText("ID:");
		this.view.getIdLabel2().setText(id.toString());
		this.view.getCbCargo().getModel().setSelectedItem(nomeCargo);
		this.view.getTxtNome().setText(funcionario.getNome());
		this.view.getTxtIdade().setText(funcionario.getIdade().toString());
		this.view.getTxtSalario().setText(funcionario.getSalario().toString());
		this.view.getTxtKm().setText(funcionario.getKm().toString());
		this.view.getJcMes().getModel().setSelectedItem(funcionario.getMes());
                this.view.getJcAno().getModel().setSelectedItem(funcionario.getMes());
	}
	
	private void criarEventListeners() {
		view.getBtnFechar().addActionListener(new ActionListener() {           
            @Override
           public void actionPerformed(ActionEvent ae) {
                    sair();
            } 
        });
		
		view.getBtnSalvar().addActionListener(new ActionListener() {           
            @Override
           public void actionPerformed(ActionEvent ae) {
                    salvarFuncionario();
            } 
        });
	}

	public void salvarFuncionario() {
		
		String nome = view.getTxtNome().getText();
		BigInteger idade = new BigInteger(view.getTxtIdade().getText());
		BigDecimal salario = new BigDecimal(view.getTxtSalario().getText());
		String cargo = view.getCbCargo().getSelectedItem().toString();
//        String bonusSelecionado = view.getCbBonus().getSelectedItem().toString();
		String mes = view.getJcMes().getSelectedItem().toString();
                String ano = view.getJcAno().getSelectedItem().toString();
//        Date data = new Date();
//        Bonus bonus = new BonusNormal();
		if(!"".equals(this.view.getIdLabel2().getText())) {
			BigInteger id = new BigInteger(this.view.getIdLabel2().getText());
		   business.salvarFuncionario(id, nome, idade, salario, cargo, mes, ano);
		}else {
			business.cadastrarFuncionario(nome, idade, salario, cargo, mes, ano);
		}
		new PrincipalPresenter();
		this.view.dispose();
	}

	public void BuscarCargos() {
		ArrayList<String> cargos = new ArrayList<>();
		List<Cargo> cargoLista = CargoDAO.getCargoDAOInstance().getAll();
		cargoLista.forEach(cargo -> {
			cargos.add(cargo.getNome());
		});
		ManipuladorComboBox.getInstance().preencherComboBox(cargos, view.getCbCargo());
	}

	public void sair() {
		new PrincipalPresenter();
		this.view.dispose();
	}
}
