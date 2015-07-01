/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import dao.DAOLog;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Log;

/**
 *
 * @author victoraweb
 */
@Stateless
public class Logger implements LoggerRemote, LoggerLocal {

    @PersistenceContext(name = "Library_PU")
    private EntityManager em;

    @Override
    public void newLog(String action) {
        Log log = new Log();
        log.createAction(action);
        em.persist(log);
    }

    @Override
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
