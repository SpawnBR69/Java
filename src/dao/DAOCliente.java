/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Dados;

/**
 *
 * @author igorm
 */
public class DAOCliente {
    public ArrayList<Cliente> getLista() {
        String sql = "select * from cliente";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cliente obj = new Cliente();
                Date date = rs.getDate("dataDeNascimento");
                Calendar data = Calendar.getInstance();
                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEstado(rs.getString("estado"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCidade(rs.getString("cidade"));
                obj.setBairro(rs.getString("bairro"));
                obj.setRua(rs.getString("rua"));
                obj.setNum(rs.getInt("num"));
                data.setTime(date);
                obj.setDataDeNascimento(data);
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(Cliente cliente){
        if(cliente.getIdCliente() == null){
            return incluir(cliente);
        }else{
            return alterar(cliente);
        }
    }
    public boolean incluir(Cliente obj){
        String sql = "insert into cliente(nome,cpf,dataDeNascimento,telefone,estado,cidade,bairro,rua,num) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setDate(3, new Date(obj.getDataDeNascimento().getTimeInMillis()));
            pst.setString(4, obj.getTelefone());
            pst.setString(5,obj.getEstado());
            pst.setString(6, obj.getCidade());
            pst.setString(7, obj.getBairro());
            pst.setString(8, obj.getRua());
            pst.setInt(9, obj.getNum());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Cliente obj){
        String sql = 
           "update cliente set nome= ?, cpf = ?, dataDeNascimento = ?, telefone = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, num = ? where idCliente = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setDate(3, new Date(obj.getDataDeNascimento().getTimeInMillis()));
            pst.setString(4, obj.getTelefone());
            pst.setString(5,obj.getEstado());
            pst.setString(6, obj.getCidade());
            pst.setString(7, obj.getBairro());
            pst.setString(8, obj.getRua());
            pst.setInt(9, obj.getNum());
            pst.setInt(10, obj.getIdCliente());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
      
    public boolean deletar(Cliente obj) {
        String sql = "delete from cliente where idCliente = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdCliente());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public Cliente localizar(int id) {
        String sql = "select * from cliente where idCliente = ?";
        Cliente obj = new Cliente();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Date date = rs.getDate("dataDeNascimento");
                Calendar data = Calendar.getInstance();
                obj.setIdCliente(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEstado(rs.getString("estado"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCidade(rs.getString("cidade"));
                obj.setBairro(rs.getString("bairro"));
                obj.setRua(rs.getString("rua"));
                obj.setNum(rs.getInt("num"));
                data.setTime(date);
                obj.setDataDeNascimento(data);
                return obj;
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Exception "+ ex.getMessage());
        }
        return null;
    }
}

