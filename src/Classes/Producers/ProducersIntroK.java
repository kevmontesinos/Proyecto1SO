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
public class ProducersIntroK extends Thread {

    public int id;
    public boolean stop;

    public int tiempoDia = 1; //esto tiene que venir luego del json

    public ProducersIntroK(int id) {
        this.stop = false;
        this.id = id;

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Utils.ConstantsK.semIntroK.acquire();
                Utils.ConstantsK.mutexIntroK.acquire();

                Utils.ConstantsK.driveIntroK++;

                Utils.ConstantsK.mutexIntroK.release();
                
                //el semáforo de la intro se hará realease cuando el ensamblador usé alguna intro

                Thread.sleep(tiempoDia * 1000 / 3); //3 intros por día

            } catch (Exception e) {
            }
        }

    }

}
