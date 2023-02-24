/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.PM;

/**
 *
 * @author Jose Rubin
 */
	public class PmJ extends Thread {
    
    public boolean stop;
    
    public PmJ(){
        this.stop = false;
        
    }
    
    @Override
    public void run(){
        while(!stop){
            
        }
    }
    
}
