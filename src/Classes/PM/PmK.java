/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.PM;

/**
 *
 * @author Kevin
 */
public class PmK extends Thread {
    
    public boolean stop;
    
    public PmK(){
        this.stop = false;
        
    }
    
    @Override
    public void run(){
        while(!stop){
            
        }
    }
    
}
