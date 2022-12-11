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
import modelo.Funcionario;

/**
 *
 * @author igorm
 */
public class DAOFuncionario {
    public ArrayList<Funcionario> getLista() {
        String sql = "select * from funcionario";
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Funcionario obj = new Funcionario();
                Date date = rs.getDate("dataDeNascimento");
                Calendar data = Calendar.getInstance();
                obj.setIdFunc(rs.getInt("idFuncionario"));
                obj.setNome(rs.getString("nome"));
                obj.setSalario(rs.getDouble("salario"));
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
    
    public boolean salvar(Funcionario funcionario) {
        if(funcionario.getIdFunc() == null){
            return incluir(funcionario);
        }else{
            return alterar(funcionario);
        }
    }
    public boolean incluir(Funcionario obj){
        String sql = "insert into funcionario(nome,cpf,salario,dataDeNascimento,telefone,estado,cidade,bairro,rua,num) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setDouble(3, obj.getSalario());
            pst.setDate(4, new Date(obj.getDataDeNascimento().getTimeInMillis()));
            pst.setString(5, obj.getTelefone());
            pst.setString(6,obj.getEstado());
            pst.setString(7, obj.getCidade());
            pst.setString(8, obj.getBairro());
            pst.setString(9, obj.getRua());
            pst.setInt(10, obj.getNum());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Funcionario obj){
        String sql = 
           "update funcionario set nome= ?, cpf = ?, salario = ?, dataDeNascimento = ?, telefone = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, num = ? where idFuncionario = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setDouble(3, obj.getSalario());
            pst.setDate(4, new Date(obj.getDataDeNascimento().getTimeInMillis()));
            pst.setString(5, obj.getTelefone());
            pst.setString(6,obj.getEstado());
            pst.setString(7, obj.getCidade());
            pst.setString(8, obj.getBairro());
            pst.setString(9, obj.getRua());
            pst.setInt(10, obj.getNum());
            pst.setInt(11, obj.getIdFunc());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
      
    public boolean deletar(Funcionario obj) {
        String sql = "delete from funcionario where idFuncionario = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdFunc());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Funcionario excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public Funcionario localizar(int id) {
        String sql = "select * from funcionario where idFuncionario = ?";
        Funcionario obj = new Funcionario();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Date date = rs.getDate("dataDeNascimento");
                Calendar data = Calendar.getInstance();
                obj.setIdFunc(rs.getInt("idFuncionario"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setSalario(rs.getDouble("salario"));
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
