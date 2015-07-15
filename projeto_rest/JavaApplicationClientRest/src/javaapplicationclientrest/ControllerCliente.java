/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationclientrest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.entity.StringEntity;

/**
 *
 * @author Alex
 */
public class ControllerCliente {
    HttpClient http;

    public ControllerCliente(){
        this.http = new HttpClient();
        
    }
    
    public void getMenu(){
        String menu = "1 - Listar Noticias\n2- Cadastrar Noticia\n3 - Remover Noticias\n4 - Buscar Notícia\n5- Atualizar Noticia";
        System.out.println(menu);
        
    }
    public void listarNoticias(){
        GetMethod list = new GetMethod(Constants.GET_NOTICIAS);
        String responseStatus="";
        String response="";
        try {
            http.executeMethod(list);
            responseStatus = list.getStatusText();
            response = list.getResponseBodyAsString();
        } catch (IOException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("status: "+ responseStatus + "\n" + "Responde: "+response);
      
    }
    
    public void removerNoticia(String id){
        
        DeleteMethod del = new DeleteMethod(String.format(Constants.REMOVE_NOTICIA, id));
//        System.out.println(String.format(Constants.REMOVE_NOTICIA, id));
        try {
            http.executeMethod(del);
            System.out.println("Status: " + del.getStatusText());
            System.out.println(del.getResponseBodyAsString());
            
        } catch (IOException ex) {
            
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void cadastrarNoticia(String titulo, String autor, String conteudo){
        PostMethod p = new PostMethod(Constants.POST_NOTICIA);
        String xml = "<?xml version=\"1.0\"?>";
        xml+="<noticia><titulo>"+titulo+"</titulo><autor>"+autor+"</autor><conteudo>"+conteudo+"</conteudo></noticia>";
        StringRequestEntity requestEntity;
        try {
            requestEntity = new StringRequestEntity(xml, "application/xml", "UTF-8");
           
            p.setRequestEntity(requestEntity);
     
            try {
             
                http.executeMethod(p);
                System.out.println("status : "+ p.getStatusText());
//                System.out.println("status: "+ p.getStatusText() + "\n");
               // System.out.println("message: "+ p.getResponseBodyAsString());
            } catch (IOException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
    
    public void atualizarNoticia(String id, String titulo){
        PutMethod p = new PutMethod(String.format(Constants.PUT_NOTICIA, id,titulo));
        
        try {
            
            
            int statusCode = http.executeMethod(p);
           
            System.out.println(p.getStatusText());
        } catch (IOException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    public void getNoticia(String id){
        GetMethod get = new GetMethod(String.format(Constants.GET_NOTICIA, id));
        try {
            http.executeMethod(get);
            System.out.println("status: "+ get.getStatusText()+"\nTESTANDO"+get.getResponseBodyAsString());
        } catch (IOException ex) {
            try {
                System.out.println("status: "+ get.getStatusText()+"\n"+get.getResponseBodyAsString());
            } catch (IOException ex1) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
