/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.Utilidades;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author nandi
 */
public class ManipuladorComboBox {
    
    private ManipuladorComboBox() {
    }
    
    public static ManipuladorComboBox getInstance() {
        return ManipuladorComboBoxHolder.INSTANCE;
    }
    
    private static class ManipuladorComboBoxHolder {

        private static final ManipuladorComboBox INSTANCE = new ManipuladorComboBox();
    }
    
    public void RemoveItens(JComboBox<String> jcb){
            jcb.removeAllItems();                    
    }
    
    public void PreencherComboBox(ArrayList<String> itens ,JComboBox<String> jcb){
            jcb.removeAllItems();
            for(String item : itens){
                jcb.addItem(item);
            }
    }
}
