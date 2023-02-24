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
import static Utils.ConstantsK.numProducerIntroKev;
import static Utils.ConstantsK.numProducerCreditsKev;
import static Utils.ConstantsK.numProducerStartKev;
import static Utils.ConstantsK.numProducerClosureKev;
import static Utils.ConstantsK.numProducerPTKev;
import static Utils.ConstantsK.numAssemblerKev;

import static Utils.ConstantsK.countdownProductoraK;
import static Utils.ConstantsK.mutexCountdown;
import static Utils.ConstantsK.tiempoDia;
import static Utils.ConstantsK.numCaps;
import static Utils.ConstantsK.estadoPm;

import Utils.InterfaceFunctionsK;
import Utils.WriteFile;

public class PmK extends Thread {

    public boolean stop;
    public int diaActual = 0;
    public static WriteFile writeNewData = new WriteFile();

    public PmK() {
        this.stop = false;

    }

    public int gastosProductoraK() {
        int gastoProdIntro = numProducerIntroKev * diaActual * 5;
        int gastoProdCred = numProducerCreditsKev * diaActual * 3;
        int gastoProdStart = numProducerStartKev * diaActual * 7;
        int gastoProdClose = numProducerClosureKev * diaActual * 14 / 2;
        int gastoProdPT = numProducerPTKev * diaActual * 10;
        int gastoAssembler = numAssemblerKev * diaActual * 8;
        int gastoPm = diaActual * 7;
        int gastoDirector = diaActual * 100;
        //tomar en cuenta el descuento por ver rick y morty despues
        return gastoProdIntro + gastoProdCred + gastoProdStart + gastoProdClose + gastoProdPT + gastoAssembler + gastoPm + gastoPm + gastoDirector;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                if (countdownProductoraK > 0) {
                    mutexCountdown.acquire();

                    Thread.sleep(tiempoDia * 3 / 8);

                    countdownProductoraK--;
                    diaActual++;

                    Interface.countdownKevin.setText(Integer.toString(countdownProductoraK));
                    //ultimo lote

                    Interface.Gastos2.setText(Integer.toString(gastosProductoraK()));

                    int ingresosProductoraK = numCaps * 1960 / 3;
                    Interface.Ganancia2.setText(Integer.toString(ingresosProductoraK - gastosProductoraK()));

                    mutexCountdown.release();

                    for (int i = 0; i < 29; i++) {
                        estadoPm = "Ricky y Morty";
                        Interface.RegistroPM2.setText(estadoPm);
                        Thread.sleep(tiempoDia * 1440 / 23); //intervalo de 23 minutos
                        estadoPm = "Sprints Reviews";
                        Interface.RegistroPM2.setText(estadoPm);
                        Thread.sleep(tiempoDia * 1440 / 23);

                    }
                } else {
                    InterfaceFunctionsK.stopRun();
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
