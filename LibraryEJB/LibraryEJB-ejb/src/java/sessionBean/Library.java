/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dao.DAOBook;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Book;

/**
 *
 * @author victoraweb
 */
@Stateful
public class Library implements LibraryRemote {

    @PersistenceContext(name = "Library_PU")
    EntityManager em;
    
    @Override
    public boolean addBook(long codigo, String titulo, String editora, long isbn, int edicao, String autor) {
        DAOBook daoBook = new DAOBook(em);
        if (daoBook.findBookByTitle(titulo) == null) {
            Book bookToUpdate = new Book();
            bookToUpdate.setCodigo(codigo);
            bookToUpdate.setTitulo(titulo);
            bookToUpdate.setEditora(editora);
            bookToUpdate.setIsbn(isbn);
            bookToUpdate.setEdicao(edicao);
            bookToUpdate.setAutor(autor);
            
            daoBook.persist(bookToUpdate);
            return true;
        }
        else {
            return false;
        }
    }

    @Override // Update find by code. Use when changing title
    public boolean updateBook(long codigo, String newTitulo, String newEditora, long newIsbn, int newEdicao, String newAutor) {
        DAOBook daoBook = new DAOBook(em);
        Book bookToUpdate = daoBook.findBookByCode(codigo);
        if (bookToUpdate != null) {
            bookToUpdate.setCodigo(codigo);
            bookToUpdate.setTitulo(newTitulo);
            bookToUpdate.setEditora(newEditora);
            bookToUpdate.setIsbn(newIsbn);
            bookToUpdate.setEdicao(newEdicao);
            bookToUpdate.setAutor(newAutor);
            
            daoBook.merge(bookToUpdate);
            return true;
        }
        else {
            return false;
        }
    }
    
//    @Override // Update find by title. Use when changing code
//    public boolean updateBook(String titulo, long newCodigo, String newEditora, long newIsbn, int newEdicao, String newAutor) {
//        DAOBook daoBook = new DAOBook(em);
//        Book bookToUpdate = daoBook.findBookByTitle(titulo);
//        if (bookToUpdate != null) {
//            bookToUpdate.setTitulo(titulo);
//            bookToUpdate.setCodigo(newCodigo);
//            bookToUpdate.setEditora(newEditora);
//            bookToUpdate.setIsbn(newIsbn);
//            bookToUpdate.setEdicao(newEdicao);
//            bookToUpdate.setAutor(newAutor);
//            daoBook.merge(bookToUpdate);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    @Override
    public boolean deleteBook(long isbn) {
        DAOBook daoBook = new DAOBook(em);
        Book bookToUpdate = daoBook.findBookByIsbn(isbn);
        
        if (bookToUpdate != null) {
            daoBook.remove(bookToUpdate);
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public boolean deleteBookByTitle(String titulo) {
        DAOBook daoBook = new DAOBook(em);
        Book book = daoBook.findBookByTitle(titulo);
        if (book != null) {
            daoBook.remove(book);
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public String findBookByCode(long codigo) {
        DAOBook daoBook = new DAOBook(em);
        Book book = daoBook.findBookByCode(codigo);
        if (book != null) {
            return book.toString();
        }
        else {
            return "O livro pesquisado com código: " + codigo + " não foi encontrado.";
        }
    }

    @Override
    public String findBookByTitle(String titulo) {
        DAOBook daoBook = new DAOBook(em);
        Book book = daoBook.findBookByTitle(titulo);
        if (book != null) {
            return book.toString();
        }
        else {
            return "Nenhum livro com titulo: " + titulo + " foi encontrado";
        }
    }

    @Override
    public String findBookByAuthor(String autor) {
        DAOBook daoBook = new DAOBook(em);
        List<Book> books = daoBook.findBookByAuthor(autor);
        String retrievedBooks = ""; 
        int i = 1;
        if (books != null) {
            for (Book b : books) {
                retrievedBooks += i + " - " + b.toString();
                i++;
            }
            return retrievedBooks;
        }
        else {
            return "Livros com o autor: " + autor + " não foram encontrados.";
        }
    }

    @Override
    public String findBookByIsbn(long isbn) {
        DAOBook daoBook = new DAOBook(em);
        Book book = daoBook.findBookByIsbn(isbn);
        if (book != null) {
            return book.toString();
        }
        return "Nenhum livro com isbn: " + isbn + " foi encontrado";
    }

    @Override
    public int counter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findAllBooks() {
        DAOBook daoBook = new DAOBook(em);
        List<Book> books = daoBook.findAllBooks();
        String retrievedBooks = "";
        int i = 1;
        if(books != null) {
            for (Book b : books) {
                retrievedBooks += i + " - " + b.toString();
                i++;
            }
            return retrievedBooks;
        }
        else {
            return "Não há livros cadastrados no sistema ainda =).";
        }
        
    }
    
}
