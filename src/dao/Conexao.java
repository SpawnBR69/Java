/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author igorm
 */
public class Conexao {
    private static final String BANCO ="jdbc:mysql://localhost:3306/mercearia";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static Connection con = null;

    public Conexao() {
        
    }
    
    public static Connection getConexao(){
        if(con == null){
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                System.out.println("Não foi possível encontrar o driver.");
            } catch (SQLException ex){
                System.out.println("SQL Exception."+ ex.getMessage());
            }
        } 
        return con;
    }
    
    public static PreparedStatement getPreparedStatement(String sql){
        if(con == null){
            con = getConexao();
        }
        try {
            return con.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de sql: "+ ex.getMessage());
        }
        return null;
    }
}