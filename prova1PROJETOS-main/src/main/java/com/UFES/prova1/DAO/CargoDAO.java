/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UFES.prova1.DAO;

import com.UFES.prova1.Model.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nandi
 */
public class CargoDAO implements DAOInterface<Cargo>{
    
    int id;
    Connection conn = Conexao.getInstance().connect();

private static CargoDAO INSTANCE;
 public CargoDAO() {
        
        
        
    }
     public static CargoDAO getCargoDAOInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CargoDAO();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }
    
@Override
    public ArrayList<Cargo> getAll() throws SQLException {
      ArrayList<Cargo> cargos = new ArrayList<Cargo>();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM CARGO");
       while(rs.next()){
         
           cargos.add(new Cargo(
                   rs.getInt("id"),
                  rs.getString("nome")
           ));
           
       }
       stmt.close();
       return cargos;
       }

    @Override
    public Cargo get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public void save(Cargo obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cargo obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}