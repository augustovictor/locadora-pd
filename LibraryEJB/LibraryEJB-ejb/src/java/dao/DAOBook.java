/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import model.Book;

/**
 *
 * @author victoraweb
 */
public class DAOBook extends DAO<Book> {

    public DAOBook(EntityManager em) {
        super(em);
    }
    
    public List<Book> findAllBooks() {
        try {
            Query q = getManager().createQuery("SELECT b FROM Book b");
            return (List<Book>) q.getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        
    }
    
    public Book findBookByCode(long codigo) {
        try {
            Query q = getManager().createQuery("SELECT b FROM Book b WHERE b.codigo = " + codigo);
            return (Book) q.getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }
    
    public Book findBookByTitle(String titulo) {
        try {
            Query q = getManager().createQuery("SELECT b FROM Book b WHERE b.titulo = '" + titulo + "'");
            return (Book) q.getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }
    
    public List<Book> findBookByAuthor(String autor) {
        try {
            Query q = getManager().createQuery("SELECT b FROM Book b WHERE b.autor = '" + autor + "'");
            return (List<Book>) q.getResultList();
        } catch (PersistenceException e) {
            return null;
        }
    }
    
    public Book findBookByIsbn(long isbn) {
        try {
            Query q = getManager().createQuery("SELECT b FROM Book b WHERE b.isbn = '" + isbn + "'");
            return (Book) q.getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }
    
    
    
}
