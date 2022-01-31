
package com.UFES.prova1.DAO;

import com.UFES.prova1.Model.Cargo;
import com.UFES.prova1.Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class FuncionarioDAO implements DAOInterface<Funcionario>{
    private static FuncionarioDAO INSTANCE;
    private Funcionario funcionario;
    Connection conn = Conexao.getInstance().connect();

    public FuncionarioDAO() {
        
        
        
    }
     public static FuncionarioDAO getFuncionarioDAOInstance() {

        if (INSTANCE == null) {
            INSTANCE = new FuncionarioDAO();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }
    
    @Override
    public Funcionario get(int id) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if(!rs.next())
             new JOptionPane().showMessageDialog(new JFrame(),"Funcionario Inválido!","Aviso",JOptionPane.WARNING_MESSAGE);
        
        rs = stmt.executeQuery(); 
        Funcionario funcionarioSelecionado = new Funcionario(rs.getInt("idFuncionario"),
                   rs.getString("nomeFuncionario"),
                   rs.getInt("idadeFuncionario"),
                   rs.getDouble("salarioBaseFuncionario"),
                   rs.getString("cargo"),
                   rs.getString("dataAdmissaoFuncionario"),
                   rs.getInt("faltas"),
                   rs.getInt("km")
            );
        return funcionarioSelecionado;
    }


    @Override
    public void save(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO FUNCIONARIO (nomeFuncionario, idadeFuncionario, salarioBaseFuncionario, cargo, dataAdmissaoFuncionario, faltas, km) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        //LocalDate dataAdmissao = Instant.ofEpochMilli(funcionario.getDataAdmissao()).atZone(ZoneId.systemDefault()).toLocalDate();
        //Date dataAdmissao = java.sql.Date.valueOf(funcionario.getDataAdmissao());
        
        stmt.setString(1, funcionario.getNome().toUpperCase());
        stmt.setInt(2, funcionario.getIdade());
        stmt.setDouble(3, funcionario.getSalario());
        stmt.setString(4, funcionario.getCargo().toUpperCase());
        stmt.setString(5, funcionario.getDataAdmissao());
        stmt.setInt(6, funcionario.getFaltas());
        stmt.setInt(7, funcionario.getKm());
        stmt.execute(); 
    }

    @Override
    public void update(Funcionario obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> getAll() throws SQLException {
       ArrayList<Funcionario> funcionarios = new ArrayList<>();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM FUNCIONARIO");
       while(rs.next()){
         
           funcionarios.add(new Funcionario(rs.getInt("idFuncionario"),
                   rs.getString("nomeFuncionario"),
                   rs.getInt("idadeFuncionario"),
                   rs.getDouble("salarioBaseFuncionario"),
                   rs.getString("cargo"),
                   rs.getString("dataAdmissaoFuncionario"),
                   rs.getInt("faltas"),
                   rs.getInt("km")
            )
           );
     
       }
       stmt.close();
       return funcionarios;
       }

    public Funcionario getNome(String nome) throws SQLException {
       String sql1 = "SELECT * FROM funcionario WHERE nomeFuncionario = ?";
        PreparedStatement stmt1 = conn.prepareStatement(sql1);
        stmt1.setString(1, nome);
        ResultSet rs1 = stmt1.executeQuery();
        if(!rs1.next())
             new JOptionPane().showMessageDialog(new JFrame(),"Funcionario Inválido!","Aviso",JOptionPane.WARNING_MESSAGE);
        
        rs1 = stmt1.executeQuery(); 
        Funcionario funcionarioSelecionado = new Funcionario(rs1.getInt("idFuncionario"),
                   rs1.getString("nomeFuncionario"),
                   rs1.getInt("idadeFuncionario"),
                   rs1.getDouble("salarioBaseFuncionario"),
                   rs1.getString("cargo"),
                   rs1.getString("dataAdmissaoFuncionario"),
                   rs1.getInt("faltas"),
                   rs1.getInt("km")
            );
        return funcionarioSelecionado;
    }

        
}
