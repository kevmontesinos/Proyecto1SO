/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.PM;

/**
 *
 * @author Kevin
 */
import Interfaces.Interface;
import static Utils.Constants.countdownProductoraJ;
import static Utils.Constants.estadoPm;
import static Utils.Constants.mutexCountdownJ;
import static Utils.Constants.numAssemblersJose;
import static Utils.Constants.numCapsJ;
import static Utils.Constants.numProducerClosureJose;
import static Utils.Constants.numProducerCreditsJose;
import static Utils.Constants.numProducerIntroJose;
import static Utils.Constants.numProducerPTJose;
import static Utils.Constants.numProducerStartJose;
import static Utils.Constants.tiempoDia;
import Utils.InterfaceFunctions;
import Utils.WriteFile;

public class PmJ extends Thread {

    public boolean stop;
    public int diaActual = 0;
    public static WriteFile writeNewData = new WriteFile();

    public PmJ() {
        this.stop = false;

    }

    public int gastosProductoraJ() {
        int gastoProdIntro = numProducerIntroJose * diaActual * 5;
        int gastoProdCred = numProducerCreditsJose * diaActual * 3;
        int gastoProdStart = numProducerStartJose * diaActual * 7;
        int gastoProdClose = numProducerClosureJose * diaActual * 14 / 2;
        int gastoProdPT = numProducerPTJose * diaActual * 10;
        int gastoAssembler = numAssemblersJose * diaActual * 8;
        int gastoPm = diaActual * 7;
        int gastoDirector = diaActual * 100;
        //tomar en cuenta el descuento por ver rick y morty despues
        return gastoProdIntro + gastoProdCred + gastoProdStart + gastoProdClose + gastoProdPT + gastoAssembler + gastoPm + gastoPm + gastoDirector;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                if (countdownProductoraJ > 0) {
                    mutexCountdownJ.acquire();

                    Thread.sleep(tiempoDia * 3 / 8);

                    countdownProductoraJ--;
                    diaActual++;

                    Interface.countdownJose.setText(Integer.toString(countdownProductoraJ));
                    //ultimo lote

                    Interface.Gastos1.setText(Integer.toString(gastosProductoraJ()));

                    int ingresosProductoraJ = numCapsJ * 1960 / 3;
                    Interface.Ganancia1.setText(Integer.toString(ingresosProductoraJ - gastosProductoraJ()));
					

                    mutexCountdownJ.release();

                    for (int i = 0; i < 29; i++) {
                        estadoPm = "Ricky y Morty";
                        Interface.Pm3.setText(estadoPm);
                        Thread.sleep(tiempoDia * 1440 / 23); //intervalo de 23 minutos
                        estadoPm = "Sprints Reviews";
                        Interface.Pm3.setText(estadoPm);
                        Thread.sleep(tiempoDia * 1440 / 23);

                    }
                } else {
                    InterfaceFunctions.stopRun();
                    writeNewData.writeData();
                }

            } catch (Exception e) {
            }
        }
    }

    public void stopRun() {
        this.stop = true;
    }

}
