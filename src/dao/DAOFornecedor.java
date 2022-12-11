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
import javax.swing.JOptionPane;
import modelo.Dados;
import modelo.Fornecedor;

/**
 *
 * @author igorm
 */
public class DAOFornecedor {
    public ArrayList<Fornecedor> getLista() {
        String sql = "select * from fornecedor";
        ArrayList<Fornecedor> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Fornecedor obj = new Fornecedor();
                obj.setIdFornecedor(rs.getInt("idFornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEstado(rs.getString("estado"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCidade(rs.getString("cidade"));
                obj.setBairro(rs.getString("bairro"));
                obj.setRua(rs.getString("rua"));
                obj.setNum(rs.getInt("num"));
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(Fornecedor fornecedor) {
        if(fornecedor.getIdFornecedor() == null){
            return incluir(fornecedor);
        }else{
            return alterar(fornecedor);
        }
    }
    public boolean incluir(Fornecedor obj){
        String sql = "insert into fornecedor(nome,cnpj,telefone,estado,cidade,bairro,rua,num) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCnpj());
            pst.setString(3, obj.getTelefone());
            pst.setString(4,obj.getEstado());
            pst.setString(5, obj.getCidade());
            pst.setString(6, obj.getBairro());
            pst.setString(7, obj.getRua());
            pst.setInt(8, obj.getNum());
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
    public boolean alterar(Fornecedor obj){
        String sql = 
           "update fornecedor set nome= ?, cnpj = ?, telefone = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, num = ? where idFornecedor = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCnpj());
            pst.setString(4, obj.getTelefone());
            pst.setString(5,obj.getEstado());
            pst.setString(6, obj.getCidade());
            pst.setString(7, obj.getBairro());
            pst.setString(8, obj.getRua());
            pst.setInt(9, obj.getNum());
            pst.setInt(10, obj.getIdFornecedor());
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
      
    public boolean deletar(Fornecedor obj) {
        String sql = "delete from fornecedor where idFornecedor = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdFornecedor());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Fornecedor não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public Fornecedor localizar(int id) {
        String sql = "select * from fornecedor where idFornecedor = ?";
        Fornecedor obj = new Fornecedor();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                obj.setIdFornecedor(rs.getInt("idFornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEstado(rs.getString("estado"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCidade(rs.getString("cidade"));
                obj.setBairro(rs.getString("bairro"));
                obj.setRua(rs.getString("rua"));
                obj.setNum(rs.getInt("num"));
                return obj;
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Exception "+ ex.getMessage());
        }
        return null;
    }
}