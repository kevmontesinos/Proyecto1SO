/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Producers;

import Interfaces.Interface;
import static Utils.ConstantsK.tiempoDia;

/**
 *
 * @author Kevin Montesinos
 */
public class ProducersCreditsK extends Thread {

    public int id;
    public boolean stop;

    public ProducersCreditsK(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.ConstantsK.semCreditsK.acquire();
                Utils.ConstantsK.mutexCreditsK.acquire();

                Utils.ConstantsK.driveCreditsK++;
                Interface.DriveCredits2.setText(Integer.toString(Utils.ConstantsK.driveCreditsK));

                Utils.ConstantsK.mutexCreditsK.release();

                Thread.sleep(tiempoDia * 1000 / 3); //3 credits por día

            } catch (Exception e) {
            }
        }

    }

    public void stopRun() {
        this.stop = true;
    }
}
