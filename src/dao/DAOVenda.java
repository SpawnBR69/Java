/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.beans.Transient;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelo.Dados;
import modelo.Venda;

/**
 *
 * @author igorm
 */
public class DAOVenda {
    DAOCliente dao = new DAOCliente();
    DAOFuncionario dao1 = new DAOFuncionario();
    public ArrayList<Venda> getLista() {
        String sql = "select * from venda";
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Venda obj = new Venda();
                obj.setIdVenda(rs.getInt("idVenda"));
                Date date = rs.getDate("dataDaVenda");
                Calendar data = Calendar.getInstance();
                data.setTime(date);
                obj.setData(data);
                obj.setIdCliente(dao.localizar(rs.getInt("idCliente")));
                obj.setIdFuncionario(dao1.localizar(rs.getInt("idFuncionario")));
                obj.setValor(rs.getDouble("valor"));
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(Venda venda) {
        if(venda.getIdVenda() == null){
            return incluir(venda);
        }else{
            return alterar(venda);
        }
    }
    public boolean incluir(Venda obj){
        String sql = "insert into venda(idCliente,idFuncionario,dataDaVenda,valor) values(?,?,?,?);";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdCliente().getIdCliente());
            pst.setInt(2, obj.getIdFuncionario().getIdFunc());
            pst.setDate(3, new Date(obj.getData().getTimeInMillis()));
            pst.setDouble(4, obj.getValor());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Venda incluída com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Venda não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Venda obj){
        String sql = 
           "update venda set idCliente = ?, idFuncionario = ?, dataDaVenda = ?, valor = ? where idVenda = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdCliente().getIdCliente());
            pst.setInt(2, obj.getIdFuncionario().getIdFunc());
            pst.setDate(3, new Date(obj.getData().getTimeInMillis()));
            pst.setDouble(4, obj.getValor());
            pst.setInt(5, obj.getIdVenda());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Venda alterada com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Venda não alterada");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public boolean deletar(Venda obj) {
        String sql = "delete from venda where idVenda = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdVenda());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Venda excluída com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Venda não excluída");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public Venda localizar(int id) {
        String sql = "select * from venda where idVenda = ?";
        Venda obj = new Venda();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                obj.setIdVenda(rs.getInt("idVenda"));
                Date date = rs.getDate("dataDaVenda");
                Calendar data = Calendar.getInstance();
                data.setTime(date);
                obj.setData(data);
                obj.setIdCliente(dao.localizar(rs.getInt("idCliente")));
                obj.setIdFuncionario(dao1.localizar(rs.getInt("idFuncionario")));
                obj.setValor(rs.getDouble("valor"));
                return obj;
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Exception "+ ex.getMessage());
        }
        return null;
    }
}
