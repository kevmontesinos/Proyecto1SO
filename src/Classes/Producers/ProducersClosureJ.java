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
public class ProducersClosureJ extends Thread {

	public int id;
    public boolean stop;

    public int tiempoDia = 1; //esto tiene que venir luego del json

    public ProducersClosureJ(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.Constants.semClosureJ.acquire();
                Utils.Constants.mutexClosureJ.acquire();

                Utils.Constants.driveClosureJ++;
                
                Utils.Constants.mutexClosureJ.release();

                Thread.sleep(tiempoDia * 2000); //1 closure cada 2 días

            } catch (Exception e) {
            }
        }

    }
    
}
