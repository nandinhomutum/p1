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

import com.ufes.prova1.business.BonusDecimoTerceiro;
import com.ufes.prova1.business.BonusDistancia;
import com.ufes.prova1.business.BonusFalta;
import com.ufes.prova1.business.BonusFuncionarioMes;
import com.ufes.prova1.business.BonusGeneroso;
import com.ufes.prova1.business.BonusIdade;
import com.ufes.prova1.business.BonusNormal;
import com.ufes.prova1.business.BonusTempo;
import com.ufes.prova1.business.CalcularBonus;
import com.ufes.prova1.dao.HistoricoBonusDAO;
import com.ufes.prova1.dao.HistoricoSalarioDAO;
import com.ufes.prova1.model.Funcionario;
import com.ufes.prova1.model.HistoricoBonus;
import com.ufes.prova1.model.HistoricoSalario;
import com.ufes.prova1.view.TelaFuncionarioBonusView;

/**
 *
 * @author nandi
 */
public class AdicionarBonusPresenter {

    private TelaFuncionarioBonusView view;
    private final Funcionario funcionario;

    public AdicionarBonusPresenter(Funcionario funcionario) {
        configurarTela();
        this.funcionario = funcionario;
        preencherTela(funcionario);
    }
        
	private void salvar() {
		String tipoBonus;
		BigDecimal valorBonus;
		BigDecimal bonusAcumulado = BigDecimal.ZERO;
		BigInteger mes = new BigInteger(view.getCbMes().getSelectedItem().toString());
		BigInteger ano = new BigInteger(view.getJcbAno().getSelectedItem().toString());
		if (view.getCkDecimo().isSelected() == true) {
			tipoBonus = "BONUS 13 SALARIO";
			valorBonus = BigDecimal.ZERO;
			CalcularBonus bonus = new BonusDecimoTerceiro();
			valorBonus = bonus.calcular(funcionario);
			bonusAcumulado = bonusAcumulado.add(valorBonus);
			HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
			HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);

		}

		if (view.getCkDistancia().isSelected() == true) {

			tipoBonus = "BONUS DISTANCIA";
			valorBonus = BigDecimal.ZERO;
			CalcularBonus bonus = new BonusDistancia();
			valorBonus = bonus.calcular(funcionario);
			bonusAcumulado = bonusAcumulado.add(valorBonus);
			HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
			HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
		}

		if (view.getJckIdade().isSelected() == true) {

			tipoBonus = "BONUS IDADE";
			valorBonus = BigDecimal.ZERO;
			CalcularBonus bonus = new BonusIdade();
			valorBonus = bonus.calcular(funcionario);
			bonusAcumulado = bonusAcumulado.add(valorBonus);
			HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
			HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
		}

		if (view.getCkFuncionarioMes().isSelected() == true) {

			tipoBonus = "BONUS FUNCIONARIO MES";
			valorBonus = BigDecimal.ZERO;
			CalcularBonus bonus = new BonusFuncionarioMes();
			valorBonus = bonus.calcular(funcionario);
			bonusAcumulado = bonusAcumulado.add(valorBonus);
			HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
			HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
		}
                
                if (view.getJckbTempo().isSelected() == true) {

			tipoBonus = "BONUS TEMPO DE SERVIÇO";
			valorBonus = BigDecimal.ZERO;
			CalcularBonus bonus = new BonusTempo();
			valorBonus = bonus.calcular(funcionario);
			bonusAcumulado = bonusAcumulado.add(valorBonus);
			HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
			HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
		}
                

		if (view.getjCBBonus().toString().equals("NORMAL")) {

			tipoBonus = "BONUS NORMAL";
			valorBonus = BigDecimal.ZERO;

			CalcularBonus bonus = new BonusNormal();
			valorBonus = bonus.calcular(funcionario);
			bonusAcumulado = bonusAcumulado.add(valorBonus);
			HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
			HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
		} else {

			tipoBonus = "BONUS GENEROSO";
			valorBonus = BigDecimal.ZERO;
			CalcularBonus bonus = new BonusGeneroso();
			valorBonus = bonus.calcular(funcionario);
                        bonusAcumulado = bonusAcumulado.add(valorBonus);
			HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
			HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);
		}
		BigInteger numFaltas = new BigInteger(view.getTxtFaltas().getText());
		funcionario.setFaltas(numFaltas);
		tipoBonus = "BONUS POR FALTA";
		valorBonus = BigDecimal.ZERO;
		CalcularBonus bonus = new BonusFalta();
		System.out.println("faltas: " + funcionario.getFaltas());
		valorBonus = bonus.calcular(funcionario);
		bonusAcumulado = bonusAcumulado.add(valorBonus);
		System.out.println("valor bonus calculado: " + valorBonus);
		HistoricoBonus historico = new HistoricoBonus(funcionario.getNome(), tipoBonus, valorBonus, mes, ano);
		HistoricoBonusDAO.getHistoricoDAOInstance().save(historico);

		BigDecimal salario = BigDecimal.ZERO;

		salario = funcionario.getSalario().add(bonusAcumulado);
		HistoricoSalario historicoSalario = new HistoricoSalario(funcionario, bonusAcumulado, salario, mes,
				ano);
		HistoricoSalarioDAO.getHistoricoDAOInstance().save(historicoSalario);
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
				salvar();
			}
		});
	}

	private void configurarTela(){
        this.view = new TelaFuncionarioBonusView();
        criarEventListeners();
        view.setVisible(true);
    }

    private void preencherTela(Funcionario funcionario) {        
        view.getLblNome().setText(funcionario.getNome());
        view.getLblCargo().setText(funcionario.getNome());
       view.getLblMes().setText(funcionario.getMes());
       view.getLblAno().setText(funcionario.getAno());
        view.getLblCargo().setText(funcionario.getCargo().getNome());
        view.getLbId().setText("funcionario.getId()");
    }

	public void sair() {
		new PrincipalPresenter();
		this.view.dispose();
	}
    
}
