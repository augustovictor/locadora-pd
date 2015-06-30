/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Scanner;
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
        
//        libRemote.addBook(1, "Testando titulo", "Abril", 4161L, 2, "Victor");
//        libRemote.addBook(2, "Como ficar monstro em duas refeições", "Monster gym", 4162L, 1, "Gleidson");
//        libRemote.addBook(3, "Lataria nova", "Editora Carro", 4163L, 1, "Victor");
//        libRemote.addBook(4, "Lataria nova2", "Editora Carro", 4164L, 2, "Mama");
//        System.out.println("Livros by Victor");
//        System.out.println(libRemote.findBookByAuthor("Victor"));

//        libRemote.updateBook(2, "Título novo2", "Abril", 4162L, 2, "Gleidson");
//        System.out.println("Todos os livros:");

//        System.out.println(libRemote.findAllBooks()); // List all books
//        
//        libRemote.deleteBook(4162L); // Delete by isbn
//        
//        System.out.println("Todos os livros apos remover 4162L:");
//        System.out.println(libRemote.findAllBooks()); // List all books
//        
//        System.out.println("Books by isbn");
//        System.out.println(libRemote.findBookByIsbn(4161));
//        
//        System.out.println("Books by title");
//        System.out.println(libRemote.findBookByTitle("Editora Carro"));
//        
//        libRemote.deleteBookByTitle("Editora Carro"); // Delete by title
//        
//        System.out.println("Todos os livros apos remover \"Editora Carro\":");
//        System.out.println(libRemote.findAllBooks()); // List all books
//        
//        System.out.println(libRemote.qtdSearch());
        
        
        Scanner keyboard = new Scanner(System.in);
        
        while(true) {
            String titulo, editora, autor;
            long codigo, isbn;
            int edicao;
            
            System.out.println(libRemote.showMenu());
            int option = keyboard.nextInt();
            
            switch(option) {
                
                // OPTION 1 - ADD BOOK
                case 1:
                    System.out.println("------ Opção 1 selecionada - Adicionar livro ------");
                    System.out.println("------ Insira primeiramente o código de identificação do livro: ------");
                    codigo = keyboard.nextLong();
                    
                    keyboard.nextLine();
                    
                    System.out.println("------ Qual será o título? ------");
                    titulo = keyboard.nextLine();
                    
                    System.out.println("------ E quanto à editora? ------");
                    editora = keyboard.nextLine();
                    
                    System.out.println("------ Qual o ISBN? ------");
                    isbn = keyboard.nextLong();
                    
                    System.out.println("------ Qual a edição? ------");
                    edicao = keyboard.nextInt();
                    keyboard.nextLine();
                    
                    System.out.println("------ Quem é o(a) autor(a)? ------");
                    autor = keyboard.nextLine();
                    
                    if (libRemote.addBook(codigo, titulo, editora, isbn, edicao, autor)) 
                        System.out.println("Livro \"" + titulo + "\" cadastrado com sucesso!");
                    else System.out.println("Ocorreu um erro durante a criação do livro " + titulo);
                    
                break;
                    
                // OPTION 2 - UPDATE BOOK
                case 2:
                    System.out.println("------ Opção 2 selecionada - Atualizar livro ------");
                    System.out.println("Você deve informar o código do livro a ser atualizado:");
                    codigo = keyboard.nextLong();
                    
                    System.out.println("------ Qual será o novo título? ------");
                    keyboard.nextLine();
                    titulo = keyboard.nextLine();

                    System.out.println("------ E quanto à nova editora? ------");
                    editora = keyboard.nextLine();

                    System.out.println("------ Qual o novo ISBN? ------");
                    isbn = keyboard.nextLong();

                    System.out.println("------ Qual a nova edição? ------");
                    edicao = keyboard.nextInt();
                    keyboard.nextLine();

                    System.out.println("------ Quem é o(a) novo(a) autor(a)? ------");
                    autor = keyboard.nextLine();

                    // Ex: libRemote.updateBook(2, "Título monstro atualizado", "Abril", 4162L, 2, "Monstro")
                    if(libRemote.updateBook(codigo, titulo, editora, isbn, edicao, autor)) {
                        System.out.println("Livro com código " + codigo + " atualizado com sucesso! Este é o novo registro do livro:");
                        System.out.println(libRemote.findBookByTitle(titulo));

                    }
                    else System.out.println("Ocorreu um erro durante a atualização do livro com código: " + codigo);

                    
                break;
                    
                // OPTION 3 - REMOVE BOOK
                case 3:
                    System.out.println("------ Opção 3 selecionada - Remover livro [] ------");
                    System.out.println("Insira o isbn do livro a ser removido:");
                    isbn = keyboard.nextLong();
                    keyboard.nextLine();
                    
                    if(libRemote.deleteBook(isbn))
                        System.out.println("Livro com isbn " + isbn + " removido com sucesso!");
                    else System.out.println("Erro ao tentar deletar o livro com isbn " + isbn + ".");
                    
                break;
                    
                // OPTION 4 - LIST ALL BOOKS
                case 4:
                    System.out.println("------ Opção 4 selecionada - Listar todos os livros ------");
                    System.out.println(libRemote.findAllBooks());
                break;
                    
                // OPTION 5 - SEARCH BOOK
                case 5:
                    System.out.println("------ Opção 5 selecionada - Procurar livro ------");
                    System.out.println("------ Como deseja pesquisar livros? ------");
                    System.out.println("------------ 1 - Pesquisar por título");
                    System.out.println("------------ 2 - Pesquisar por autor");
                    System.out.println("------------ 3 - Pesquisar por isbn");
                    
                    option = keyboard.nextInt();
                    keyboard.nextLine();
                    
                    switch(option) {
                        case 1:
                            System.out.println("------ Pesquisar por livro com o seguinte título: ");
                            titulo = keyboard.nextLine();
                            System.out.println(libRemote.findBookByTitle(titulo));
                        break;
                            
                        case 2:
                            System.out.println("------ Pesquisar por livro com o seguinte autor: ");
                            autor = keyboard.nextLine();
                            System.out.println(libRemote.findBookByAuthor(autor));
                        break;
                            
                        case 3:
                            System.out.println("------ Pesquisar por livro com o seguinte isbn: ");
                            isbn = keyboard.nextLong();
                            System.out.println(libRemote.findBookByIsbn(isbn));
                        break;
                    }
                    
                    
                break;
                    
                // OPTION 6 - VERIFY AMOUNT OF SEARCHES
                case 6:
                    System.out.println("------ Opção 6 selecionada - Exibir quantidade de pesquisas já realizadas ------");
                    keyboard.nextLine();
                    System.out.println(libRemote.qtdSearch());
                break;
                    
                // OPTION 7 - SHOW MENU OPTIONS
                case 7:
                    System.out.println("------ Opção 7 selecionada - Exibir menu ------");
                break;
                    
                // OPTION 8 - 
                
                    
                // OPTION 9 - 
            }
        }
          
        
    }
}
