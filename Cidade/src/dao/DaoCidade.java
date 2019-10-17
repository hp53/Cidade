/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cidade;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class DaoCidade {
     public static boolean inserir(Cidade objeto) {
        String sql = "INSERT INTO cidade (sigla_estado, nome, nr_habitantes, distancia_da_capital,area_total,data_emancipacao) VALUES (?, ?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSigla_estado());
            ps.setString(2, objeto.getNome());
            ps.setInt(3, objeto.getNr_habitantes());
            ps.setInt(4, objeto.getDistancia_da_capital());
            ps.setDouble(5, objeto.getArea_total());
            ps.setDate(6, Date.valueOf(objeto.getData_emancipacao()));
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
      public static boolean alterar(Cidade objeto) {
        String sql = "UPDATE cidade SET sigla_estado = ?, nome = ?, nr_habitantes = ?,distancia_da_capital = ? , area_total= ?, data_emancipacao = ?   WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
             ps.setString(1, objeto.getSigla_estado());
            ps.setString(2, objeto.getNome()); 
            ps.setInt(3, objeto.getNr_habitantes());
            ps.setInt(4, objeto.getDistancia_da_capital());
            ps.setDouble(5, objeto.getArea_total());
           ps.setDate(6, Date.valueOf(objeto.getData_emancipacao()));
            ps.setInt(7, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        public static boolean excluir(Cidade objeto) {
        String sql = "DELETE FROM cidade WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        public static List<Cidade> consultar() {
        List<Cidade> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla_estado, nr_habitantes, distancia_da_capital, area_total, data_emancipacao FROM cidade";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla_estado(rs.getString("Sigla_estado"));
                objeto.setNr_habitantes(rs.getInt("nr_habitantes"));
                objeto.setDistancia_da_capital(rs.getInt("distancia_da_capital"));
                objeto.setArea_total(rs.getDouble("area_total"));
                objeto.setData_emancipacao(rs.getDate("data_emancipacao").toLocalDate());
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
 public static Cidade consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla_estado, nr_habitantes, distancia_da_capital,area_total, data_emancipacao FROM cidade WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla_estado(rs.getString("sigla_estado"));
                objeto.setNr_habitantes(rs.getInt("nr_habitantes"));
                objeto.setDistancia_da_capital(rs.getInt("distancia_da_capital"));
                objeto.setArea_total(rs.getDouble("area_total"));
                objeto.setData_emancipacao(rs.getDate("data_emancipacao").toLocalDate());
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
