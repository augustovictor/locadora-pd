/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationclientrest;

/**
 *
 * @author Alex
 */
public class Constants {
    
    /*URL DE LIBS NECESSÁRIAS NESSE PROJETO
    
        http://www.java2s.com/Code/Jar/c/Downloadcommonshttpclient31jar.htm
        http://commons.apache.org/proper/commons-codec/download_codec.cgi
        http://commons.apache.org/proper/commons-logging/download_logging.cgi
        http://www.java2s.com/Code/Jar/a/Downloadapachehttpcomponentshttpcorejar.htm
    
    */
    public final static String GET_NOTICIAS = "http://localhost:8080/Projeto_Rest/webresources/noticias/listar";
    public final static String REMOVE_NOTICIA = "http://localhost:8080/Projeto_Rest/webresources/noticias/%s";
    public final static String GET_NOTICIA = "http://localhost:8080/Projeto_Rest/webresources/noticias?id=%s";
    public final static String POST_NOTICIA = "http://localhost:8080/Projeto_Rest/webresources/noticias";
    public final static String PUT_NOTICIA = "http://localhost:8080/Projeto_Rest/webresources/noticias/%s/%s";
}
