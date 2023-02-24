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
public class ProducersClosureJ extends Thread {

	public int id;
    public boolean stop;

    public ProducersClosureJ(int id) {
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
                Utils.Constants.semClosureJ.acquire();
                Utils.Constants.mutexClosureJ.acquire();

                Utils.Constants.driveClosureJ++;
				Interface.DriveCierre.setText(Integer.toString(Utils.Constants.driveClosureJ));

                Utils.Constants.mutexClosureJ.release();

                Thread.sleep(tiempoDia * 2000); //1 closure cada 2 días

            } catch (Exception e) {
            }
        }

    }
    
}
