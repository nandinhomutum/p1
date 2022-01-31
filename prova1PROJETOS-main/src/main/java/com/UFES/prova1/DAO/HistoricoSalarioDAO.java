/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UFES.prova1.DAO;

import com.UFES.prova1.Model.Funcionario;
import com.UFES.prova1.Model.HistoricoBonus;
import com.UFES.prova1.Model.HistoricoSalario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class HistoricoSalarioDAO implements DAOInterface<HistoricoSalario>{
private static HistoricoSalarioDAO INSTANCE;
    private HistoricoSalario funcionario;
    Connection conn = Conexao.getInstance().connect();
    
    public static HistoricoSalarioDAO getHistoricoDAOInstance() {

        if (INSTANCE == null) {
            INSTANCE = new HistoricoSalarioDAO();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    @Override
    public HistoricoSalario get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(HistoricoSalario historico) throws SQLException {
       String sql = "INSERT INTO HISTORICOSALARIO (nome , bonus, salarioFinal, mes, ano) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, historico.getNome().toUpperCase());
        stmt.setDouble(2, historico.getBonus());
        stmt.setDouble(3, historico.getSalarioFinal());
        stmt.setInt(4, historico.getMes());
        stmt.setInt(5, historico.getAno());
        stmt.execute(); 
    }

    @Override
    public void update(HistoricoSalario obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HistoricoSalario> getAll() throws SQLException {
        String sql = "SELECT * FROM HistoricoSalario";
       
       PreparedStatement stmt = conn.prepareStatement(sql);
       
       ArrayList<HistoricoSalario> historico = new ArrayList<>();
       ResultSet rs = stmt.executeQuery();
       
      
       while(rs.next()){
         
           historico.add(new HistoricoSalario(
                   rs.getString("nome"),
                   rs.getDouble("bonus"),
                   rs.getDouble("salarioFinal"),
                   rs.getInt("mes"),
                   rs.getInt("ano"))
           );
     
       }
       stmt.close();
       return historico;
       }
       
    
    
     public ArrayList<HistoricoSalario> getAllFuncionario(String nomeFuncionario) throws SQLException {
        
       String sql = "SELECT * FROM HistoricoSalario WHERE nome = ?";
       
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1, nomeFuncionario);
       ArrayList<HistoricoSalario> historico = new ArrayList<>();
       ResultSet rs = stmt.executeQuery();
       
      
       while(rs.next()){
         
           historico.add(new HistoricoSalario(
                   rs.getString("nome"),
                   rs.getDouble("bonus"),
                   rs.getDouble("salarioFinal"),
                   rs.getInt("mes"),
                   rs.getInt("ano"))
           );
     
       }
       stmt.close();
       return historico;
       }

    public ArrayList<HistoricoSalario> getAllMes(String mes, String ano) throws SQLException {
       
       String sql = "SELECT * FROM HistoricoSalario WHERE mes = ? AND ano = ?";
       
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1, mes);
       stmt.setString(2, ano);
       ArrayList<HistoricoSalario> historico = new ArrayList<>();
       ResultSet rs = stmt.executeQuery();
       
      
       while(rs.next()){
         
           historico.add(new HistoricoSalario(
                   rs.getString("nome"),
                   rs.getDouble("bonus"),
                   rs.getDouble("salarioFinal"),
                   rs.getInt("mes"),
                   rs.getInt("ano"))
           );
     
       }
       stmt.close();
       return historico;
       }
   }
    
    

