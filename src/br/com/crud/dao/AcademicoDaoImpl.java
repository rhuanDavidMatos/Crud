/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.dao;

import br.com.crud.entidade.Academico;
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
public class AcademicoDaoImpl implements Serializable {

    public class ProfessorDaoImpl implements Serializable {

        private Connection conexao;
        private PreparedStatement preparando;
        private ResultSet resultSet;
//Academico(Integer cdMatricula, String nmAcademico, int cpf, String dsEmail, String dsEndereco, int idSexo, int idade)

        public void salvar(Academico academico) throws SQLException {
            String sql = "INSERT INTO academico(cdMatricula, nmAcademico, cpf, dsEmail, dsEndereco, idSexo, idade) VALUES(?, ?, ? ?, ?, ?, ?)";

            try {
                conexao = ConexaoMysql.abrirConexao();

                preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparando.setInt(1, academico.getCdMatricula());
                preparando.setString(2, academico.getNmAcademico());
                preparando.setInt(3, academico.getCpf());
                preparando.setString(4, academico.getDsEmail());
                preparando.setString(5, academico.getDsEndereco());
                preparando.setInt(6, academico.getIdSexo());
                preparando.setInt(7, academico.getIdade());
                preparando.executeUpdate();
                resultSet = preparando.getGeneratedKeys();
                resultSet.next();
                academico.setCdMatricula(resultSet.getInt(1));

            } catch (SQLException eSQL) {
                System.err.println("Erro ao salvar " + eSQL.getMessage());
            } finally {
                ConexaoMysql.fecharConexao(conexao, preparando, resultSet);
            }
        }
//Academico(Integer cdMatricula, String nmAcademico, int cpf, String dsEmail, String dsEndereco, int idSexo, int idade)

        public void alterar(Academico academico) throws SQLException {
            String sql = "UPDATE academico SET nmAcademico = ?, cpf = ?, dsEmail = ?, dsEndereco = ?, idSexo = ?, idade = ? WHERE id = ?";

            try {
                conexao = ConexaoMysql.abrirConexao();
                preparando = conexao.prepareStatement(sql);
                preparando.setString(1, academico.getNmAcademico());
                preparando.setInt(2, academico.getCpf());
                preparando.setString(1, academico.getDsEmail());
                preparando.setString(1, academico.getDsEndereco());
                preparando.setInt(1, academico.getIdSexo());
                preparando.setInt(1, academico.getIdade());
                preparando.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Erro ao alterar" + e.getMessage());

            }
        }

        public void excluir(Integer id) throws SQLException {
            try {
                conexao = ConexaoMysql.abrirConexao();
                preparando = conexao.prepareStatement("DELETE FROM academico WHERE cdMatricula = ?");
                preparando.setInt(1, id);
                preparando.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Erro ao excluir " + e.getMessage());
            } finally {
                ConexaoMysql.fecharConexao(conexao, preparando);
            }
        }
//Academico(Integer cdMatricula, String nmAcademico, int cpf, String dsEmail, String dsEndereco, int idSexo, int idade)

        public Academico pesquisarPorId(Integer id) throws SQLException {
            Academico academico = null;
            String consulta = "SELECT * FROM academico WHERE cdMatricula = ?";

            try {
                conexao = ConexaoMysql.abrirConexao();
                preparando = conexao.prepareStatement(consulta);
                preparando.setInt(1, id);
                resultSet = preparando.executeQuery();
                if (resultSet.next()) {
                    academico = new Academico();
                    academico.setCdMatricula(id);
                    academico.setNmAcademico(resultSet.getString("nmAcademico"));
                    academico.setCpf(resultSet.getInt("cpf"));
                    academico.setDsEmail(resultSet.getString("dsEmail"));
                    academico.setDsEmail(resultSet.getString("dsEndereco"));
                    academico.setIdSexo(resultSet.getInt("idSexo"));
                    academico.setIdade(resultSet.getInt("idade"));
                }

            } catch (SQLException e) {
                System.err.println("Erro ao pesquisar por id +" + e.getMessage());
            } finally {
                ConexaoMysql.fecharConexao(conexao, preparando, resultSet);
            }

            return academico;
        }
    }
}
