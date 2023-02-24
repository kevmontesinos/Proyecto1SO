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
public class ProducersCreditsJ extends Thread {

	public int id;
    public boolean stop;

    public ProducersCreditsJ(int id) {
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
                Utils.Constants.semCreditsJ.acquire();
                Utils.Constants.mutexCreditsJ.acquire();

                Utils.Constants.driveCreditsJ++;
                Interface.DriveCredits.setText(Integer.toString(Utils.Constants.driveCreditsJ));

                Utils.Constants.mutexCreditsJ.release();

                Thread.sleep(tiempoDia * 1000 / 2); //2 credits por día

            } catch (Exception e) {
            }
        }

    }
    
}
