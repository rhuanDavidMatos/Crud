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
public class Autores implements Serializable {

    private Integer cdAutor;
    private String nmAutor;
    private int cdLivro;

    public Autores() {
    }

    public Autores(Integer cdAutor, String nmAutor, int cdLivro) {
        this.cdAutor = cdAutor;
        this.nmAutor = nmAutor;
        this.cdLivro = cdLivro;
    }

    public Integer getCdAutor() {
        return cdAutor;
    }

    public void setCdAutor(Integer cdAutor) {
        this.cdAutor = cdAutor;
    }

    public String getNmAutor() {
        return nmAutor;
    }

    public void setNmAutor(String nmAutor) {
        this.nmAutor = nmAutor;
    }

    public int getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(int cdLivro) {
        this.cdLivro = cdLivro;
    }

}
