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
public class ProducersCreditsJ extends Thread {

	public int id;
    public boolean stop;

    public int tiempoDia = 1; //esto tiene que venir luego del json

    public ProducersCreditsJ(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.Constants.semCreditsJ.acquire();
                Utils.Constants.mutexCreditsJ.acquire();

                Utils.Constants.driveCreditsJ++;

                Utils.Constants.mutexCreditsJ.release();

                Thread.sleep(tiempoDia * 1000 / 2); //2 credits por día

            } catch (Exception e) {
            }
        }

    }
    
}
