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
import modelo.Produto;

/**
 *
 * @author igorm
 */
public class DAOProduto {
    DAOFornecedor dao = new DAOFornecedor();
    public ArrayList<Produto> getLista() {
        String sql = "select * from produto";
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Produto obj = new Produto();
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setNome(rs.getString("nome"));
                obj.setIdFornecedor(dao.localizar(rs.getInt("idFornecedor")));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("quantidade"));
                obj.setUnidade(rs.getString("unidade"));
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(Produto produto) {
        if(produto.getIdProduto() == null){
            return incluir(produto);
        }else{
            return alterar(produto);
        }
    }
    public boolean incluir(Produto obj){
        String sql = "insert into produto(nome,preco,quantidade,unidade,idFornecedor) values(?,?,?,?,?);";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getPreco());
            pst.setInt(3, obj.getQtdEstoque());
            pst.setString(4,obj.getUnidade());
            pst.setInt(5, obj.getIdFornecedor().getIdFornecedor());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Produto incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Produto não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Produto obj){
        String sql = 
           "update produto set nome= ?, preco = ?, quantidade = ?, unidade = ?, idFornecedor = ? where idProduto = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getPreco());
            pst.setInt(3, obj.getQtdEstoque());
            pst.setString(4,obj.getUnidade());
            pst.setInt(5, obj.getIdFornecedor().getIdFornecedor());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Produto não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
      
    public boolean deletar(Produto obj) {
        String sql = "delete from cliente where idProduto = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdProduto());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Produto não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public Produto localizar(int id) {
        String sql = "select * from produto where idProduto = ?";
        Produto obj = new Produto();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setNome(rs.getString("nome"));
                obj.setIdFornecedor(dao.localizar(rs.getInt("idFornecedor")));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("quantidade"));
                obj.setUnidade(rs.getString("unidade"));
                return obj;
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Exception "+ ex.getMessage());
        }
        return null;
    }
}
