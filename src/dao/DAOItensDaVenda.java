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
import modelo.ItensDaVenda;
import modelo.Dados;
/**
 *
 * @author igorm
 */
public class DAOItensDaVenda {
    DAOProduto dao = new DAOProduto();
    DAOVenda dao1 = new DAOVenda();
    public ArrayList<ItensDaVenda> getLista() {
        String sql = "select * from itensDeVenda";
        ArrayList<ItensDaVenda> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ItensDaVenda obj = new ItensDaVenda();
                obj.setIdIDV(rs.getInt("idVenda"));
                obj.setIdVendas(dao1.localizar(rs.getInt("idVenda")));
                obj.setIdProduto(dao.localizar(rs.getInt("idProduto")));
                obj.setQtdProd(rs.getInt("qtdProd"));
                obj.setSubTotal(rs.getDouble("subtotal"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(ItensDaVenda itensDaVenda) {
        if(itensDaVenda.getIdIDV() == null){
            return incluir(itensDaVenda);
        }else{
            return alterar(itensDaVenda);
        }
    }
    public boolean incluir(ItensDaVenda obj){
        String sql = "insert into itensDeVenda(idVenda,idProduto,qtdProd,subtotal) values(?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdVendas().getIdVenda());
            pst.setInt(2, obj.getIdProduto().getIdProduto());
            pst.setInt(3, obj.getQtdProd());
            pst.setDouble(4, obj.getSubTotal());
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
    public boolean alterar(ItensDaVenda obj){
        String sql = 
           "update venda set idVenda = ?, idProduto = ?, qtdProd = ?, subtotal = ? where idItensDeVenda = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdVendas().getIdVenda());
            pst.setInt(2, obj.getIdProduto().getIdProduto());
            pst.setInt(3, obj.getQtdProd());
            pst.setDouble(4, obj.getSubTotal());
            pst.setInt(5, obj.getIdIDV());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Itens Da Venda alterados com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Itens Da Venda não alterados");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
      
    public boolean deletar(ItensDaVenda obj) {
        String sql = "delete from itensDeVenda where idIDV = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdIDV());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Itens Da Venda excluídos com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Itens Da Venda não excluídos");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
}
