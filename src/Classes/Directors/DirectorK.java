/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Directors;

/**
 *
 * @author Kevin
 */
public class DirectorK extends Thread {

    public boolean stop;

    public DirectorK() {
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
