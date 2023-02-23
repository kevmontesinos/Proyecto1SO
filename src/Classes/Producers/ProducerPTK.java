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
public class ProducerPTK extends Thread {

    public int id;
    public boolean stop;

    public int tiempoDia = 1; //esto tiene que venir luego del json

    public ProducerPTK(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.ConstantsK.semPTK.acquire();
                Utils.ConstantsK.mutexPTK.acquire();

                Utils.ConstantsK.drivePTK++;

                Utils.ConstantsK.mutexPTK.release();

                Thread.sleep(tiempoDia * 3000); //1 plot twist cada 3 días

            } catch (Exception e) {
            }
        }

    }
}
