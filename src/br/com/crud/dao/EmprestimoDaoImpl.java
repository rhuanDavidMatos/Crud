/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.dao;

import br.com.crud.entidade.Emprestimo;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rhuan
 */
public class EmprestimoDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;
    //Emprestimo(Integer cdEmprestismo, int cdUsuario, int cdBibliotecario, int cdLivro, String dtDevolucao, String dtRetirada)

    public void salvar(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo(cdEmprestimo, dtDevolucao, dtRetirada) "
                + "VALUES(?, ?, ?)";
        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, emprestimo.getCdEmprestismo());
            preparando.setString(2, emprestimo.getDtDevolucao());
            preparando.setString(3, emprestimo.getDtRetirada());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            emprestimo.setCdEmprestismo(resultSet.getInt(1));

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        }
    }
//Emprestimo(Integer cdEmprestismo, int cdUsuario, int cdBibliotecario, int cdLivro, String dtDevolucao, String dtRetirada)

    public void alterar(Emprestimo emprestimo) throws SQLException {
        String sql = "UPDATE emprestimo SET dtDevolucao = ?, dtRetirada = ? WHERE cdEmprestimo = ?";

        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, emprestimo.getDtDevolucao());
            preparando.setString(1, emprestimo.getDtRetirada());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());

        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM emprestimo WHERE cdEmprestimo = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            ConexaoMysql.fecharConexao(conexao, preparando);
        }
    }

    public Emprestimo pesquisarPorId(Integer id) throws SQLException {
        Emprestimo emprestimo = null;

        String consulta = "SELECT * FROM emprestimo where cdEmprestimo = ?";

        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, id);
            resultSet = preparando.executeQuery();
            if (resultSet.next()) {
                emprestimo = new Emprestimo();
                emprestimo.setCdEmprestismo(id);
                emprestimo.setDtDevolucao(resultSet.getString("dtDevolucao"));
                emprestimo.setDtRetirada(resultSet.getString("dtRetirada"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id " + e.getMessage());
        } finally {
            ConexaoMysql.fecharConexao(conexao, preparando, resultSet);
        }

        return emprestimo;
    }

}
