/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;


import javax.ejb.Remote;

/**
 *
 * @author victoraweb
 * 
 * Interface para definir que métodos serão implementados em LibraryEJB-ejb.sessionBean.Library.java
 */
@Remote
public interface LibraryRemote {
    public boolean addBook(long codigo, final String titulo, final String editora, final long isbn, final int edicao, final String autor);
    public boolean updateBook(long codigo, String newTitulo, String newEditora, long newIsbn, int newEdicao, String newAutor);
//    public boolean updateBook(String titulo, long newCodigo, String newEditora, long newIsbn, int newEdicao, String newAutor);
    public boolean deleteBook(long codigo);
    
    public String findAllBooks();
    public String findBookByTitle(String titulo);
    public String findBookByCode(long codigo);
    public String findBookByAuthor(String autor);
    public String findBookByIsbn(long isbn);
    
    
    public int counter(); 
   
    // Missing msg(String msg);
}
