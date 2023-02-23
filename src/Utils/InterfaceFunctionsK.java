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
}
