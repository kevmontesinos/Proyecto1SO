/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Kevin
 */
import Classes.Assemblers.AssemblerK;
import Classes.Directors.DirectorK;
import Classes.PM.PmK;
import Classes.Producers.ProducerPTK;
import Classes.Producers.ProducersClosureK;
import Classes.Producers.ProducersCreditsK;
import Classes.Producers.ProducersIntroK;
import Classes.Producers.ProducersStartK;

import static Utils.ConstantsK.countdownProductoraK;
import static Utils.ConstantsK.semClosureK;
import static Utils.ConstantsK.semCreditsK;
import static Utils.ConstantsK.semIntroK;
import static Utils.ConstantsK.semPTK;
import static Utils.ConstantsK.semStartK;

import static Utils.ConstantsK.driveClosureK;
import static Utils.ConstantsK.driveCreditsK;
import static Utils.ConstantsK.driveIntroK;
import static Utils.ConstantsK.drivePTK;
import static Utils.ConstantsK.driveStartK;

import static Utils.ConstantsK.stackProducersIntroK;
import static Utils.ConstantsK.stackProducersCreditsK;
import static Utils.ConstantsK.stackProducersStartK;
import static Utils.ConstantsK.stackProducersClosureK;
import static Utils.ConstantsK.stackProducerPTK;
import static Utils.ConstantsK.stackAssemblerK;

import static Utils.ConstantsK.numProducerIntroKev;
import static Utils.ConstantsK.numProducerPTKev;
import static Utils.ConstantsK.numProducerClosureKev;
import static Utils.ConstantsK.numProducerCreditsKev;
import static Utils.ConstantsK.numProducerStartKev;
import static Utils.ConstantsK.numAssemblerKev;

import static Utils.ConstantsK.pmK;
import static Utils.ConstantsK.directorK;

import static Utils.ConstantsK.numCaps;

public class InterfaceFunctionsK {

    public static ProducersIntroK prodIntro;
    public static ProducersCreditsK prodCredits;
    public static ProducersStartK prodStart;
    public static ProducersClosureK prodClosure;
    public static ProducerPTK prodPT;
    public static AssemblerK assembler;

    public InterfaceFunctionsK() {

    }

    public static void startRun() {
        countdownProductoraK = 30;
        
        //me falta actualizar la interfaz aquí

        semIntroK.release(driveIntroK);
        driveIntroK = 0;

        semCreditsK.release(driveCreditsK);
        driveCreditsK = 0;

        semIntroK.release(driveIntroK);
        driveIntroK = 0;

        semClosureK.release(driveClosureK);
        driveClosureK = 0;

        semPTK.release(drivePTK);
        drivePTK = 0;

        numCaps = 0;

        for (int i = 0; i < numProducerIntroKev; i++) {
            prodIntro = new ProducersIntroK(i);
            prodIntro.start();
            stackProducersIntroK.push(prodIntro);
        }

        for (int i = 0; i < numProducerCreditsKev; i++) {
            prodCredits = new ProducersCreditsK(i);
            prodCredits.start();
            //Apilo cada thread a la pila  de productores botones
            stackProducersCreditsK.push(prodCredits);
        }

        for (int i = 0; i < numProducerStartKev; i++) {
            prodStart = new ProducersStartK(i);
            prodStart.start();
            //Apilo cada thread a la pila  de productores botones
            stackProducersStartK.push(prodStart);
        }

        for (int i = 0; i < numProducerClosureKev; i++) {
            prodClosure = new ProducersClosureK(i);
            prodClosure.start();
            //Apilo cada thread a la pila  de productores botones
            stackProducersClosureK.push(prodClosure);
        }

        for (int i = 0; i < numProducerPTKev; i++) {
            prodPT = new ProducerPTK(i);
            prodPT.start();
            stackProducerPTK.push(prodPT);
        }

        for (int i = 0; i < numProducerPTKev; i++) {
            assembler = new AssemblerK(i);
            assembler.start();
            stackAssemblerK.push(assembler);
        }
        
        pmK = new PmK();
        pmK.start();
        directorK = new DirectorK();
        directorK.start();

        System.out.println("HOLA");

    }

}
