/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import dao.DAOLog;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Log;
import sessionBean.LoggerLocal;

/**
 *
 * @author victoraweb
 */

@Stateless()
public class LogWebService {
    
    @PersistenceContext(name = "Library_PU")
    EntityManager em;
    
    @EJB
    private LoggerLocal ejbRef;

    @WebMethod(operationName = "newLog")
    @Oneway
    public void newLog(@WebParam(name = "action") String action) {
        ejbRef.newLog(action);
    }
    
    @WebMethod(operationName = "logsList")
    public String logsList() {
        DAOLog daoLog = new DAOLog(em);
        List<Log> logs = daoLog.logsList();
        if (logs != null) {
            String logsList = "";
            int i = 0;
            for (Log l : logs) {
                logsList += i + " - " + l.toString();
            }
            return logsList;
        }
        else return "Não há logs no sistema ainda.";
    }
    
}
