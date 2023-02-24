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
public class ProducerPTJ extends Thread {
    public int id;
    public boolean stop;

    public int tiempoDia = 1; //esto tiene que venir luego del json

    public ProducerPTJ(int id) {
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
                Utils.Constants.semPTJ.acquire();
                Utils.Constants.mutexPTJ.acquire();

                Utils.Constants.drivePTJ++;

                Utils.Constants.mutexPTJ.release();

                Thread.sleep(tiempoDia * 1000); //1 plot twist cada 1 día

            } catch (Exception e) {
            }
        }

    }
}
