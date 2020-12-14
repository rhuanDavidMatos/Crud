/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.dao;

import br.com.crud.entidade.Livros;
import br.com.crud.entidade.Usuarios;
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
public class LivrosDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;
//Livros(Integer cdLivro, String titulo, String resumo, String dtPublicacao, String edicao, String nmEditora, String cidade, String estado)

    public void salvar(Livros livros) throws SQLException {
        String sql = "INSERT INTO livros(cdLivro, titulo, resumo, dtPublicacao, edicao, nmEditora, cidade, estado) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, livros.getCdLivro());
            preparando.setString(2, livros.getTitulo());
            preparando.setString(3, livros.getResumo());
            preparando.setString(4, livros.getDtPublicacao());
            preparando.setString(5, livros.getEdicao());
            preparando.setString(6, livros.getNmEditora());
            preparando.setString(7, livros.getCidade());
            preparando.setString(8, livros.getEstado());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            livros.setCdLivro(resultSet.getInt(1));

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        }
    }
//Livros(Integer cdLivro, String titulo, String resumo, String dtPublicacao, String edicao, String nmEditora, String cidade, String estado)

    public void alterar(Livros livros) throws SQLException {
        String sql = "UPDATE livros SET cdLivro = ?, titulo = ?, resumo = ?, "
                + "dtPublicacao = ?, edicao = ?, nmEditora = ?, cidade = ?, estado = ? WHERE cdLivro = ?";

        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, livros.getCdLivro());
            preparando.setString(2, livros.getTitulo());
            preparando.setString(3, livros.getResumo());
            preparando.setString(4, livros.getDtPublicacao());
            preparando.setString(5, livros.getEdicao());
            preparando.setString(6, livros.getNmEditora());
            preparando.setString(7, livros.getCidade());
            preparando.setString(8, livros.getEstado());
            preparando.setInt(1, livros.getCdLivro());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());

        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM livros WHERE cdUsuario = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            ConexaoMysql.fecharConexao(conexao, preparando);
        }
    }
//Livros(Integer cdLivro, String titulo, String resumo, String dtPublicacao, String edicao, String nmEditora, String cidade, String estado)

    public Livros pesquisarPorId(Integer id) throws SQLException {
        Livros livro = null;

        String consulta = "SELECT * FROM usuario where = ?";

        try {
            conexao = ConexaoMysql.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, id);
            resultSet = preparando.executeQuery();
            if (resultSet.next()) {
                livro = new Livros();
                livro.setCdLivro(id);
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setResumo(resultSet.getString("resumo"));
                livro.setDtPublicacao(resultSet.getString("dtPublicacao"));
                livro.setEdicao(resultSet.getString("edicao"));
                livro.setNmEditora(resultSet.getString("nmEditora"));
                livro.setCidade(resultSet.getString("cidade"));
                livro.setEstado(resultSet.getString("estado"));
                livro.setCdLivro(resultSet.getInt("cdLivro"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            ConexaoMysql.fecharConexao(conexao, preparando, resultSet);
        }

        return livro;
    }

}
