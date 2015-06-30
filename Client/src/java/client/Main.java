/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ejb.EJB;
import sessionBean.LibraryRemote;


/**
 *
 * @author victoraweb
 */
public class Main {
    @EJB
    private static LibraryRemote libRemote;

    public static void main(String[] args) {
        // Alterar persistence, pois esta drop and create
        
        libRemote.addBook(1L, "Testando titulo", "Abril", 4161L, 2, "Victor");
        libRemote.addBook(2L, "Como ficar monstro em duas refeições", "Monster gym", 4162L, 1, "Gleidson");
        libRemote.addBook(3L, "Lataria nova", "Editora Carro", 4163L, 1, "Victor");
        System.out.println(libRemote.findBookByAuthor("Victor"));
        libRemote.updateBook(2L, "Título novo2", "Abril", 4162L, 2, "Gleidson");
        System.out.println("Todos os livros:");
        System.out.println(libRemote.findAllBooks()); // List all books
        libRemote.deleteBook(4162L); // Delete by isbn
//        libRemote.deleteBookByTitle("Como ficar monstro em duas refeições"); // Delete by title
        System.out.println("Books by isbn");
        System.out.println(libRemote.findBookByIsbn(4161));
    }
    
}
