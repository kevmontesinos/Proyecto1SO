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
import Interfaces.Interface;

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

import static Utils.ConstantsK.countdownProductoraK;
import static Utils.ConstantsK.numMaxProducers;
import javax.swing.JOptionPane;

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

        //Reiniciar semáforos y valores de la interfaz.
        semIntroK.release(driveIntroK);
        driveIntroK = 0;
        Interface.DriveIntro2.setText(Integer.toString(driveIntroK));

        semCreditsK.release(driveCreditsK);
        driveCreditsK = 0;
        Interface.DriveCredits2.setText(Integer.toString(driveCreditsK));

        semStartK.release(driveStartK);
        driveStartK = 0;
        Interface.DriveInicio2.setText(Integer.toString(driveStartK));

        semClosureK.release(driveClosureK);
        driveClosureK = 0;
        Interface.DriveCierre2.setText(Integer.toString(driveClosureK));

        semPTK.release(drivePTK);
        drivePTK = 0;
        Interface.DrivePt2.setText(Integer.toString(drivePTK));

        numCaps = 0;
        Interface.CapsTotal2.setText(Integer.toString(numCaps));

        for (int i = 0; i < numProducerIntroKev; i++) {
            prodIntro = new ProducersIntroK(i);
            prodIntro.start();

            stackProducersIntroK.push(prodIntro);
        }

        for (int i = 0; i < numProducerCreditsKev; i++) {
            prodCredits = new ProducersCreditsK(i);
            prodCredits.start();

            stackProducersCreditsK.push(prodCredits);
        }

        for (int i = 0; i < numProducerStartKev; i++) {
            prodStart = new ProducersStartK(i);
            prodStart.start();

            stackProducersStartK.push(prodStart);
        }

        for (int i = 0; i < numProducerClosureKev; i++) {
            prodClosure = new ProducersClosureK(i);
            prodClosure.start();

            stackProducersClosureK.push(prodClosure);
        }

        for (int i = 0; i < numProducerPTKev; i++) {
            prodPT = new ProducerPTK(i);
            prodPT.start();

            stackProducerPTK.push(prodPT);
        }

        for (int i = 0; i < numAssemblerKev; i++) {
            assembler = new AssemblerK(i);
            assembler.start();

            stackAssemblerK.push(assembler);
        }

        pmK = new PmK();
        pmK.start();
        directorK = new DirectorK();
        directorK.start();

    }

    public static void stopRun() {

        while (!stackProducersIntroK.isEmpty()) {
            stackProducersIntroK.peek().stopRun();
            stackProducersIntroK.pop();
        }

        while (!stackProducersCreditsK.isEmpty()) {
            stackProducersCreditsK.peek().stopRun();
            stackProducersCreditsK.pop();
        }

        while (!stackProducersStartK.isEmpty()) {
            stackProducersStartK.peek().stopRun();
            stackProducersStartK.pop();
        }

        while (!stackProducersClosureK.isEmpty()) {
            stackProducersClosureK.peek().stopRun();
            stackProducersClosureK.pop();
        }

        while (!stackProducerPTK.isEmpty()) {
            stackProducerPTK.peek().stopRun();
            stackProducerPTK.pop();
        }

        while (!stackAssemblerK.isEmpty()) {
            stackAssemblerK.peek().stopRun();
            stackAssemblerK.pop();
        }

        pmK.stopRun();
        directorK.stopRun();

    }

    public static void minusProducersIntro() {
        if (numProducerIntroKev > 1) {
            numProducerIntroKev--;
            Interface.ProducersIntro2.setText(Integer.toString(numProducerIntroKev));
            if (countdownProductoraK < 30) {
                stackProducersIntroK.peek().stopRun();
                stackProducersIntroK.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersCred() {
        if (numProducerCreditsKev > 1) {
            numProducerCreditsKev--;
            Interface.ProducersCred2.setText(Integer.toString(numProducerCreditsKev));
            if (countdownProductoraK < 30) {
                stackProducersCreditsK.peek().stopRun();
                stackProducersCreditsK.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersStart() {
        if (numProducerStartKev > 1) {
            numProducerStartKev--;
            Interface.ProducersInicio2.setText(Integer.toString(numProducerStartKev));
            if (countdownProductoraK < 30) {
                stackProducersStartK.peek().stopRun();
                stackProducersStartK.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersClosers() {
        if (numProducerClosureKev > 1) {
            numProducerClosureKev--;
            Interface.ProducersClosers2.setText(Integer.toString(numProducerClosureKev));
            if (countdownProductoraK < 30) {
                stackProducersClosureK.peek().stopRun();
                stackProducersClosureK.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusProducersPT() {
        if (numProducerPTKev > 1) {
            numProducerPTKev--;
            Interface.ProducersPT2.setText(Integer.toString(numProducerPTKev));
            if (countdownProductoraK < 30) {
                stackProducerPTK.peek().stopRun();
                stackProducerPTK.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void minusAssemblers() {
        if (numAssemblerKev > 1) {
            numAssemblerKev--;
            Interface.AssemblersJ2.setText(Integer.toString(numAssemblerKev));
            if (countdownProductoraK < 30) {
                stackAssemblerK.peek().stopRun();
                stackAssemblerK.pop();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se llegó a la cantidad mínima.");
        }
    }

    public static void sumProducersIntro() {
        int numTotalProducers = numProducerIntroKev + numProducerCreditsKev + numProducerStartKev + numProducerClosureKev + numProducerPTKev + numAssemblerKev;

        if (numTotalProducers < numMaxProducers) {
            numProducerIntroKev++;
            Interface.ProducersIntro2.setText(Integer.toString(numProducerIntroKev));

            if (countdownProductoraK < 30) {
                prodIntro = new ProducersIntroK(numProducerIntroKev);
                prodIntro.start();
                stackProducersIntroK.push(prodIntro);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersCred() {
        int numTotalProducers = numProducerIntroKev + numProducerCreditsKev + numProducerStartKev + numProducerClosureKev + numProducerPTKev + numAssemblerKev;

        if (numTotalProducers < numMaxProducers) {
            numProducerCreditsKev++;
            Interface.ProducersCred2.setText(Integer.toString(numProducerCreditsKev));

            if (countdownProductoraK < 30) {
                prodCredits = new ProducersCreditsK(numProducerCreditsKev);
                prodCredits.start();
                stackProducersCreditsK.push(prodCredits);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersStart() {
        int numTotalProducers = numProducerIntroKev + numProducerCreditsKev + numProducerStartKev + numProducerClosureKev + numProducerPTKev + numAssemblerKev;

        if (numTotalProducers < numMaxProducers) {
            numProducerStartKev++;
            Interface.ProducersInicio2.setText(Integer.toString(numProducerStartKev));

            if (countdownProductoraK < 30) {
                prodStart = new ProducersStartK(numProducerStartKev);
                prodStart.start();
                stackProducersStartK.push(prodStart);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersClosers() {
        int numTotalProducers = numProducerIntroKev + numProducerCreditsKev + numProducerStartKev + numProducerClosureKev + numProducerPTKev + numAssemblerKev;

        if (numTotalProducers < numMaxProducers) {
            numProducerClosureKev++;
            Interface.ProducersClosers2.setText(Integer.toString(numProducerClosureKev));

            if (countdownProductoraK < 30) {
                prodClosure = new ProducersClosureK(numProducerClosureKev);
                prodClosure.start();
                stackProducersClosureK.push(prodClosure);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumProducersPT() {
        int numTotalProducers = numProducerIntroKev + numProducerCreditsKev + numProducerStartKev + numProducerClosureKev + numProducerPTKev + numAssemblerKev;

        if (numTotalProducers < numMaxProducers) {
            numProducerPTKev++;
            Interface.ProducersPT2.setText(Integer.toString(numProducerPTKev));

            if (countdownProductoraK < 30) {
                prodPT = new ProducerPTK(numProducerPTKev);
                prodPT.start();
                stackProducerPTK.push(prodPT);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de productores totales");
        }
    }

    public static void sumAssemblers() {

        int numTotalProducers = numProducerIntroKev + numProducerCreditsKev + numProducerStartKev + numProducerClosureKev + numProducerPTKev + numAssemblerKev;

        if (numTotalProducers < numMaxProducers) {
            numAssemblerKev++;
            Interface.AssemblersJ2.setText(Integer.toString(numAssemblerKev));

            if (countdownProductoraK < 30) {
                assembler = new AssemblerK(numAssemblerKev);
                assembler.start();
                stackAssemblerK.push(assembler);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se excedió el número de trabajadores totales");
        }
    }

}
