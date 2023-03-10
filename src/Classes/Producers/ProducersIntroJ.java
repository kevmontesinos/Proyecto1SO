/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Producers;

import Interfaces.Interface;
import static Utils.Constants.tiempoDia;

/**
 *
 * @author Jose Rubin
 */
public class ProducersIntroJ extends Thread {

	public int id;
    public boolean stop;

    public ProducersIntroJ(int id) {
        this.stop = false;
        this.id = id;

    }
	public void stopRun() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.Constants.semIntroJ.acquire();
                Utils.Constants.mutexIntroJ.acquire();

                Utils.Constants.driveIntroJ++;
                Interface.DriveIntro.setText(Integer.toString(Utils.Constants.driveIntroJ));

                Utils.Constants.mutexIntroJ.release();
                
                //el semáforo de la intro se hará realease cuando el ensamblador usé alguna intro

                Thread.sleep(tiempoDia * 1000 / 2); //2 intros por día

            } catch (Exception e) {
            }
        }

    }
    
}
