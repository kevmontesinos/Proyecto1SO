/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Producers;

/**
 *
 * @author Kevin
 */
public class ProducersClosureK extends Thread {

    public int id;
    public boolean stop;

    public int tiempoDia = 1; //esto tiene que venir luego del json

    public ProducersClosureK(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.ConstantsK.semClosureK.acquire();
                Utils.ConstantsK.mutexClosureK.acquire();

                Utils.ConstantsK.driveClosureK++;
                
                Utils.ConstantsK.mutexClosureK.release();

                Thread.sleep(tiempoDia * 3000); //1 closure cada 3 días

            } catch (Exception e) {
            }
        }

    }
}
