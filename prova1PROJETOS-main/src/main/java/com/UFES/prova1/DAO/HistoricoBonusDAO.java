/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UFES.prova1.DAO;

import com.UFES.prova1.Model.Funcionario;
import com.UFES.prova1.Model.HistoricoBonus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class HistoricoBonusDAO implements DAOInterface<HistoricoBonus>{
    private static HistoricoBonusDAO INSTANCE;
    private HistoricoBonus historico;
    Connection conn = Conexao.getInstance().connect();
    
    public static HistoricoBonusDAO getHistoricoDAOInstance() {

        if (INSTANCE == null) {
            INSTANCE = new HistoricoBonusDAO();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }
    @Override
    public HistoricoBonus get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(HistoricoBonus historico) throws SQLException {
       String sql = "INSERT INTO HISTORICOBONUS (nome , tipoBonus, valorBonus, mes, ano) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, historico.getNome().toUpperCase());
        stmt.setString(2, historico.getTipoBonus());
        stmt.setDouble(3, historico.getValorBonus());
        stmt.setInt(4, historico.getMes());
        stmt.setInt(5, historico.getAno());
        stmt.execute(); 
    }

    @Override
    public void update(HistoricoBonus historicoBonus) throws SQLException {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HistoricoBonus> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<HistoricoBonus> getAllFuncionario(String nomeFuncionario) throws SQLException {
        
       String sql = "SELECT * FROM HistoricoBonus WHERE nome = ?";
       
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1, nomeFuncionario);
       ArrayList<HistoricoBonus> historico = new ArrayList<>();
       ResultSet rs = stmt.executeQuery();
       
      
       while(rs.next()){
         
           historico.add(new HistoricoBonus(
                   rs.getString("nome"),
                   rs.getString("tipoBonus"),
                   rs.getDouble("valorBonus"),
                   rs.getInt("mes"),
                   rs.getInt("ano"))
           );
     
       }
       stmt.close();
       return historico;
       }
    }
  
