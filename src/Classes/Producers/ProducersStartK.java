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
 * @author Kevin
 */
public class ProducersStartK extends Thread {

    public int id;
    public boolean stop;

    public ProducersStartK(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.ConstantsK.semStartK.acquire();
                Utils.ConstantsK.mutexStartK.acquire();

                Utils.ConstantsK.driveStartK++;
                Interface.DriveInicio2.setText(Integer.toString(Utils.ConstantsK.driveStartK));

                Utils.ConstantsK.mutexStartK.release();

                Thread.sleep(tiempoDia * 4000); //1 starts cada 4 días

            } catch (Exception e) {
            }
        }

    }

    public void stopRun() {
        this.stop = true;
    }
}
