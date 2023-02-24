/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Jose Rubin
 */
	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Assemblers.AssemblerJ;
import Classes.Directors.DirectorJ;
import Classes.PM.PmJ;
import Classes.Producers.ProducerPTJ;
import Classes.Producers.ProducersClosureJ;
import Classes.Producers.ProducersCreditsJ;
import Classes.Producers.ProducersIntroJ;
import Classes.Producers.ProducersStartJ;
import static Utils.Constants.countdownProductoraJ;
import static Utils.Constants.directorJ;
import static Utils.Constants.driveClosureJ;
import static Utils.Constants.driveCreditsJ;
import static Utils.Constants.driveIntroJ;
import static Utils.Constants.drivePTJ;
import static Utils.Constants.driveStartJ;
import static Utils.Constants.numAssemblersJose;
import static Utils.Constants.numCapsJ;
import static Utils.Constants.numProducerClosureJose;
import static Utils.Constants.numProducerCreditsJose;
import static Utils.Constants.numProducerIntroJose;
import static Utils.Constants.numProducerPTJose;
import static Utils.Constants.numProducerStartJose;
import static Utils.Constants.pmJ;
import static Utils.Constants.semClosureJ;
import static Utils.Constants.semCreditsJ;
import static Utils.Constants.semIntroJ;
import static Utils.Constants.semPTJ;
import static Utils.Constants.semStartJ;
import static Utils.Constants.stackAssemblerJ;
import static Utils.Constants.stackProducerPTJ;
import static Utils.Constants.stackProducersClosureJ;
import static Utils.Constants.stackProducersCreditsJ;
import static Utils.Constants.stackProducersIntroJ;
import static Utils.Constants.stackProducersStartJ;

public class InterfaceFunctions {

    public static ProducersIntroJ prodIntro;
    public static ProducersCreditsJ prodCredits;
    public static ProducersStartJ prodStart;
    public static ProducersClosureJ prodClosure;
    public static ProducerPTJ prodPT;
    public static AssemblerJ assembler;

    public InterfaceFunctions() {

    }

    public static void startRun() {
        countdownProductoraJ = 30;
        
        //me falta actualizar la interfaz aquí

        semStartJ.release(driveStartJ);
        driveStartJ = 0;

        semCreditsJ.release(driveCreditsJ);
        driveCreditsJ= 0;

        semIntroJ.release(driveIntroJ);
        driveIntroJ= 0;

        semClosureJ.release(driveClosureJ);
        driveClosureJ= 0;

        semPTJ.release(drivePTJ);
        drivePTJ= 0;

        numCapsJ = 0;

        for (int i = 0; i < numProducerIntroJose; i++) {
            prodIntro = new ProducersIntroJ(i);
            prodIntro.start();
            stackProducersIntroJ.push(prodIntro);
        }

        for (int i = 0; i < numProducerCreditsJose; i++) {
            prodCredits = new ProducersCreditsJ(i);
            prodCredits.start();
            //Apilo cada thread a la pila  de productores botones
            stackProducersCreditsJ.push(prodCredits);
        }

        for (int i = 0; i < numProducerStartJose; i++) {
            prodStart = new ProducersStartJ(i);
            prodStart.start();
            //Apilo cada thread a la pila  de productores botones
            stackProducersStartJ.push(prodStart);
        }

        for (int i = 0; i < numProducerClosureJose; i++) {
            prodClosure = new ProducersClosureJ(i);
            prodClosure.start();
            //Apilo cada thread a la pila  de productores botones
            stackProducersClosureJ.push(prodClosure);
        }

        for (int i = 0; i < numProducerPTJose; i++) {
            prodPT = new ProducerPTJ(i);
            prodPT.start();
            stackProducerPTJ.push(prodPT);
        }

        for (int i = 0; i < numAssemblersJose; i++) {
            assembler = new AssemblerJ(i);
            assembler.start();
            stackAssemblerJ.push(assembler);
        }
        
        pmJ= new PmJ();
        pmJ.start();
        directorJ= new DirectorJ();
        directorJ.start();

        System.out.println("HOLA");

    }

}

