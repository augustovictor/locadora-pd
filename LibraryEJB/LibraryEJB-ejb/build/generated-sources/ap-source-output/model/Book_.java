package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-29T18:20:45")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, Long> codigo;
    public static volatile SingularAttribute<Book, String> titulo;
    public static volatile SingularAttribute<Book, String> autor;
    public static volatile SingularAttribute<Book, Integer> edicao;
    public static volatile SingularAttribute<Book, Long> isbn;
    public static volatile SingularAttribute<Book, String> editora;

}