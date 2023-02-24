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
public class ProducersStartJ extends Thread {

	public int id;
    public boolean stop;

    public ProducersStartJ(int id) {
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
                Utils.Constants.semStartJ.acquire();
                Utils.Constants.mutexStartJ.acquire();

                Utils.Constants.driveStartJ++;
                Interface.DriveInicio.setText(Integer.toString(Utils.Constants.driveStartJ));

                Utils.Constants.mutexStartJ.release();

                Thread.sleep(tiempoDia * 3000); //1 starts cada 3 días

            } catch (Exception e) {
            }
        }

    }
    
}
