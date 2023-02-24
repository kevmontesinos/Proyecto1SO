/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Producers;

/**
 *
 * @author Jose Rubin
 */
public class ProducersIntroJ extends Thread {

	public int id;
    public boolean stop;

    public int tiempoDia = 1; //esto tiene que venir luego del json

    public ProducersIntroJ(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.Constants.semIntroJ.acquire();
                Utils.Constants.mutexIntroJ.acquire();

                Utils.Constants.driveIntroJ++;

                Utils.Constants.mutexIntroJ.release();
                
                //el semáforo de la intro se hará realease cuando el ensamblador usé alguna intro

                Thread.sleep(tiempoDia * 1000 / 2); //2 intros por día

            } catch (Exception e) {
            }
        }

    }
    
}
