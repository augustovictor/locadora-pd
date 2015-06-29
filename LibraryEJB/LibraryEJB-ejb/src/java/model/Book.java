/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author victoraweb
 */

@Entity
@Table(name = "books")
public class Book implements Serializable {
    
// ATTRIBUTES
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long codigo;
    private String titulo;
    private String editora;
    private long isbn;
    private int edicao;
    private String autor;

    // METHODS
    public Book() { }

    public Book(final long codigo, final String titulo, final String editora, final long isbn, final int edicao, final String autor) {
            setCodigo(codigo);
            setTitulo(titulo);
            setEditora(editora);
            setIsbn(isbn);
            setEdicao(edicao);
            setAutor(autor);
    }

    public long getId() {
            return id;
    }

    private void setId(long id) {
            this.id = id;
    }

    public long getCodigo() {
            return codigo;
    }

    public void setCodigo(long codigo) {
            this.codigo = codigo;
    }

    public String getTitulo() {
            return titulo;
    }

    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }

    public String getEditora() {
            return editora;
    }

    public void setEditora(String editora) {
            this.editora = editora;
    }

    public long getIsbn() {
            return isbn;
    }

    public void setIsbn(long isbn) {
            this.isbn = isbn;
    }

    public int getEdicao() {
            return edicao;
    }

    public void setEdicao(int edicao) {
            this.edicao = edicao;
    }

    public String getAutor() {
            return autor;
    }

    public void setAutor(String autor) {
            this.autor = autor;
    }
    
    @Override
    public String toString() {
        /**
         * Código: 123 - Título | Autor: Victor
         * -- Editora: Abril [Edição: 01]
         * -----------------------------------
         */
        return "Código: " + this.getCodigo() + " - Título: " + this.getTitulo() +  " | Autor: " + this.getAutor() + " \n" + 
               "-- Editora: " + this.getEditora() + "[Edição: " + this.getEdicao() + "]" +
                "\n-----------------------------------\n";
    }
    
}
