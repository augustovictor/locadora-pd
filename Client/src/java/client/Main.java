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
        libRemote.addBook(1L, "Testando titulo", "Abril", 010101, 2, "Victor");
        libRemote.addBook(2, "Como ficar monstro em duas refeições.", "Monster gym", 010102, 1, "Gleidson");
        System.out.println(libRemote.findBookByAuthor("Victor"));
        libRemote.updateBook(1L, "Título novo2", "Abril", 010101, 2, "Gleidson");
        System.out.println(libRemote.findAllBooks());
//        libRemote.deleteBook(2);
//        libRemote.findAllBooks();
    }
    
}
