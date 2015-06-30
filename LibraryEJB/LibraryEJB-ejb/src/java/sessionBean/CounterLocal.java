/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import javax.ejb.Local;

/**
 *
 * @author victoraweb
 */
@Local
public interface CounterLocal {
    public int getSequence();
    public void increaseCounter();
}
