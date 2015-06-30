/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import javax.ejb.Singleton;

/**
 *
 * @author victoraweb
 */
@Singleton
public class Counter implements CounterLocal {
    private int countSeq;
    
    public Counter() {
        this.countSeq = 0;
    }

    @Override
    public int getSequence() {
        return this.countSeq;
    }

    @Override
    public void increaseCounter() {
        this.countSeq++;
    }
    
}
