/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.entidade;

import java.io.Serializable;

/**
 *
 * @author rhuan
 */
public class Usuarios implements Serializable {

    private Integer cdUsuario;
    private String nome;
    private String login;
    private String senha;
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

    public Usuarios() {
    }

    public Usuarios(Integer cdUsuario, String nome, String login, String senha, String logradouro, String cidade, String estado, String cep) {
        this.cdUsuario = cdUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
