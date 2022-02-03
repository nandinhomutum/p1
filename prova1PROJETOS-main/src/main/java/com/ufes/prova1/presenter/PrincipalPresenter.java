/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.prova1.presenter;

import com.ufes.prova1.utilidades.GerenciadorDeLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ufes.prova1.view.TelaPrincipalView;

/**
 *
 * @author nandi
 */
public class PrincipalPresenter {

    private TelaPrincipalView view;

    public PrincipalPresenter() {
        configurarTela();   
    }
    

    public void abrirManterFuncionario() { 
        new ManterFuncionarioPresenter();
        this.sair();
    }

    public void abreBuscarFuncionario() {
        new BuscarFuncionarioPresenter();
        this.sair();
    }

    public void abreSalario() {
    	new SalarioPresenter();
        this.sair();
    }
    
    public void abreCargos(){
        new CargosPresenter();
        this.sair();
    }
    
    public void sair(){
        this.view.dispose();
    }

    private void configurarTela() {
        this.view = new TelaPrincipalView();
        
        view.getMenuManterFuncionario().addActionListener(new ActionListener() {           
            @Override
           public void actionPerformed(ActionEvent ae) {
                    abrirManterFuncionario();
            } 
        });
        
        view.getMenuBuscarFuncionario().addActionListener(new ActionListener() {           
            @Override
           public void actionPerformed(ActionEvent ae) {
                    abreBuscarFuncionario();
            } 
        }); 
        
        view.getMenuCalcularSalario().addActionListener(new ActionListener() {           
            @Override
           public void actionPerformed(ActionEvent ae) {
                    abreSalario();
            } 
        }); 
        
        view.getMenuCargos().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				abreCargos();				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});  
        
        view.getMenuSair().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sair();				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		}); 
        
        view.getMenuLog().addActionListener(new ActionListener() {           
            @Override
           public void actionPerformed(ActionEvent ae) {
                    abrirLog();
            } 
        });
        
        this.view.setVisible(true);
    }
    private void abrirLog() {
    	GerenciadorDeLog.getInstance().abrirArquivoDeLog();
    }

}
