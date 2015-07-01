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
import model.Log;

/**
 *
 * @author victoraweb
 */
public class DAOLog extends DAO<Log> {
    
    public DAOLog(EntityManager em) {
        super(em);
    }
    
    public List<Log> logsList() {
        try {
            Query q = getManager().createQuery("SELECT l FROM Log l");
            return (List<Log>) q.getResultList();
        } catch (PersistenceException e) {
            return null;
        }
        
    }
    
}
