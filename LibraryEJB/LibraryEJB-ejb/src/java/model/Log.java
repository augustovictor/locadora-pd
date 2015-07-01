/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author victoraweb
 */

@Entity
public class Log implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String action;
    private Date date;
    
    public String getAction() {
        return action;
    }
    
    public void setAction() {
        
    }
    
    public static String getDateTime() {
        Date now = new Date();
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return simpleFormat.format(now);
    }
    
}


