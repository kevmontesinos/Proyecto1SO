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
import Interfaces.Interface;
import static Utils.Constants.countdownJose;
import static Utils.Constants.countdownProductoraJ;
import static Utils.Constants.directorJ;
import static Utils.Constants.driveClosureJ;
import static Utils.Constants.driveCreditsJ;
import static Utils.Constants.driveIntroJ;
import static Utils.Constants.drivePTJ;
import static Utils.Constants.driveStartJ;
import static Utils.Constants.maxWorkersJose;
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
import javax.swing.JOptionPane;

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

    }

     public static void stopRun() {

        while (!stackProducersIntroJ.isEmpty()) {
            stackProducersIntroJ.peek().stopRun();
            stackProducersIntroJ.pop();
        }

        while (!stackProducersCreditsJ.isEmpty()) {
            stackProducersCreditsJ.peek().stopRun();
            stackProducersCreditsJ.pop();
        }

        while (!stackProducersStartJ.isEmpty()) {
            stackProducersStartJ.peek().stopRun();
            stackProducersStartJ.pop();
        }

        while (!stackProducersClosureJ.isEmpty()) {
            stackProducersClosureJ.peek().stopRun();
            stackProducersClosureJ.pop();
        }

        while (!stackProducerPTJ.isEmpty()) {
            stackProducerPTJ.peek().stopRun();
            stackProducerPTJ.pop();
        }

        while (!stackAssemblerJ.isEmpty()) {
            stackAssemblerJ.peek().stopRun();
            stackAssemblerJ.pop();
        }

        pmJ.stopRun();
        directorJ.stopRun();

    }

    public static void minusProducersIntro() {
        if (numProducerIntroJose > 1) {
            numProducerIntroJose--;
            Interface.ProducersIntro.setText(Integer.toString(numProducerIntroJose));
            if (countdownJose < 30) {
                stackProducersIntroJ.peek().stopRun();
                stackProducersIntroJ.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersCred() {
        if (numProducerCreditsJose > 1) {
            numProducerCreditsJose--;
            Interface.ProducersCred.setText(Integer.toString(numProducerCreditsJose));
            if (countdownProductoraJ < 30) {
                stackProducersCreditsJ.peek().stopRun();
                stackProducersCreditsJ.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersStart() {
        if (numProducerStartJose > 1) {
            numProducerStartJose--;
            Interface.ProducersInicio.setText(Integer.toString(numProducerStartJose));
            if (countdownProductoraJ < 30) {
                stackProducersStartJ.peek().stopRun();
                stackProducersStartJ.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersClosers() {
        if (numProducerClosureJose > 1) {
            numProducerClosureJose--;
            Interface.ProducersClosers.setText(Integer.toString(numProducerClosureJose));
            if (countdownProductoraJ < 30) {
                stackProducersClosureJ.peek().stopRun();
                stackProducersClosureJ.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersPT() {
        if (numProducerPTJose > 1) {
            numProducerPTJose--;
            Interface.ProducersPT.setText(Integer.toString(numProducerPTJose));
            if (countdownProductoraJ < 30) {
                stackProducerPTJ.peek().stopRun();
                stackProducerPTJ.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusAssemblers() {
        if (numAssemblersJose > 1) {
            numAssemblersJose--;
            Interface.AssemblersJ1.setText(Integer.toString(numAssemblersJose));
            if (countdownProductoraJ < 30) {
                stackAssemblerJ.peek().stopRun();
                stackAssemblerJ.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void sumProducersIntro() {
        int numTotalProducers = numProducerIntroJose + numProducerCreditsJose + numProducerStartJose + numProducerClosureJose + numProducerPTJose + numAssemblersJose;

        if (numTotalProducers < maxWorkersJose) {
            numProducerIntroJose++;
            Interface.ProducersIntro.setText(Integer.toString(numProducerIntroJose));

            if (countdownProductoraJ < 30) {
                prodIntro = new ProducersIntroJ(numProducerIntroJose);
                stackProducersIntroJ.push(prodIntro);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersCred() {
        int numTotalProducers = numProducerIntroJose + numProducerCreditsJose + numProducerStartJose + numProducerClosureJose + numProducerPTJose + numAssemblersJose;

        if (numTotalProducers < maxWorkersJose) {
            numProducerCreditsJose++;
            Interface.ProducersCred.setText(Integer.toString(numProducerCreditsJose));

            if (countdownProductoraJ < 30) {
                prodCredits = new ProducersCreditsJ(numProducerCreditsJose);
                stackProducersCreditsJ.push(prodCredits);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersStart() {
        int numTotalProducers = numProducerIntroJose + numProducerCreditsJose + numProducerStartJose + numProducerClosureJose + numProducerPTJose + numAssemblersJose;

        if (numTotalProducers < maxWorkersJose) {
            numProducerStartJose++;
            Interface.ProducersInicio.setText(Integer.toString(numProducerStartJose));

            if (countdownProductoraJ < 30) {
                prodStart = new ProducersStartJ(numProducerStartJose);
                stackProducersStartJ.push(prodStart);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersClosers() {
        int numTotalProducers = numProducerIntroJose + numProducerCreditsJose + numProducerStartJose + numProducerClosureJose + numProducerPTJose + numAssemblersJose;

        if (numTotalProducers < maxWorkersJose) {
            numProducerClosureJose++;
            Interface.ProducersClosers.setText(Integer.toString(numProducerClosureJose));

            if (countdownProductoraJ < 30) {
                prodClosure = new ProducersClosureJ(numProducerClosureJose);
                stackProducersClosureJ.push(prodClosure);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersPT() {
        int numTotalProducers = numProducerIntroJose + numProducerCreditsJose + numProducerStartJose + numProducerClosureJose + numProducerPTJose + numAssemblersJose;

        if (numTotalProducers < maxWorkersJose) {
            numProducerPTJose++;
            Interface.ProducersPT.setText(Integer.toString(numProducerPTJose));

            if (countdownProductoraJ < 30) {
                prodPT = new ProducerPTJ(numProducerPTJose);
                stackProducerPTJ.push(prodPT);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumAssemblers() {

        int numTotalProducers = numProducerIntroJose + numProducerCreditsJose + numProducerStartJose + numProducerClosureJose + numProducerPTJose + numAssemblersJose;

        if (numTotalProducers < maxWorkersJose) {
            numAssemblersJose++;
            Interface.AssemblersJ1.setText(Integer.toString(numAssemblersJose));

            if (countdownProductoraJ < 30) {
                assembler = new AssemblerJ(numAssemblersJose);
                stackAssemblerJ.push(assembler);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de trabajadores totales");
        }
    }



}

