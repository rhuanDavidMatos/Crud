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
public class Livros implements Serializable {

    private Integer cdLivro;
    private String titulo;
    private String resumo;
    private String dtPublicacao;
    private String edicao;
    private String nmEditora;
    private String cidade;
    private String estado;

    public Livros() {
    }

    public Livros(Integer cdLivro, String titulo, String resumo, String dtPublicacao, String edicao, String nmEditora, String cidade, String estado) {
        this.cdLivro = cdLivro;
        this.titulo = titulo;
        this.resumo = resumo;
        this.dtPublicacao = dtPublicacao;
        this.edicao = edicao;
        this.nmEditora = nmEditora;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(Integer cdLivro) {
        this.cdLivro = cdLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(String dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getNmEditora() {
        return nmEditora;
    }

    public void setNmEditora(String nmEditora) {
        this.nmEditora = nmEditora;
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

}
