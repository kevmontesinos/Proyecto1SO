/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Directors;

/**
 *
 * @author Jose Rubin
 */
public class DirectorJ extends Thread {
    
public boolean stop;

    public DirectorJ() {
        this.stop = false;
    }

    @Override
    public void run() {
        while (!stop) {

        }
    }

    public void stopRun() {
        this.stop = true;
    }
}
