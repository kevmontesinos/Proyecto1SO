/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Assemblers;

import Interfaces.Interface;

/**
 *
 * @author Kevin
 */
public class AssemblerK extends Thread {

    public int id;
    public boolean stop;
    public int tiempoDia = 1; //esto tiene que venir luego del json

    public boolean enableToAssemble() {
        if (Utils.ConstantsK.driveIntroK > 0 && Utils.ConstantsK.driveCreditsK > 0 && Utils.ConstantsK.driveStartK > 0 && Utils.ConstantsK.driveClosureK > 0 && Utils.ConstantsK.drivePTK > 0) {
            return true;
        }
        return false;
    }

    public AssemblerK(int id) {
        this.id = id;
        this.stop = false;
    }

    @Override
    public void run() {
        while (!this.stop) {
            try {
                //Se toma en exclusividad la función de ensamblador
                Utils.ConstantsK.mutexAssemblerK.acquire();

                if (this.enableToAssemble()) {

                    //Para sacar 1 intro
                    Utils.ConstantsK.mutexIntroK.acquire();
                    Utils.ConstantsK.semIntroK.acquire();
                    Utils.ConstantsK.driveIntroK--;
                    Interface.DriveIntro2.setText(Integer.toString(Utils.ConstantsK.driveIntroK));
                    Utils.ConstantsK.semIntroK.release();
                    Utils.ConstantsK.mutexIntroK.release();

                    //Para sacar 1 credit
                    Utils.ConstantsK.mutexCreditsK.acquire();
                    Utils.ConstantsK.semCreditsK.acquire();
                    Utils.ConstantsK.driveCreditsK--;
                    Interface.DriveCredits2.setText(Integer.toString(Utils.ConstantsK.driveCreditsK));
                    Utils.ConstantsK.semCreditsK.release();
                    Utils.ConstantsK.mutexCreditsK.release();

                    //Para sacar 1 start
                    Utils.ConstantsK.mutexStartK.acquire();
                    Utils.ConstantsK.semStartK.acquire();
                    Utils.ConstantsK.driveStartK--;
                    Interface.DriveInicio2.setText(Integer.toString(Utils.ConstantsK.driveStartK));
                    Utils.ConstantsK.semStartK.release();
                    Utils.ConstantsK.mutexStartK.release();

                    //Para sacar 1 closure
                    Utils.ConstantsK.mutexClosureK.acquire();
                    Utils.ConstantsK.semClosureK.acquire();
                    Utils.ConstantsK.driveClosureK--;
                    Interface.DriveCierre2.setText(Integer.toString(Utils.ConstantsK.driveClosureK));
                    Utils.ConstantsK.semClosureK.release();
                    Utils.ConstantsK.mutexClosureK.release();

                    //Para sacar 1 plot twist
                    Utils.ConstantsK.mutexPTK.acquire();
                    Utils.ConstantsK.semPTK.acquire();
                    Utils.ConstantsK.drivePTK--;
                    Interface.DrivePt2.setText(Integer.toString(Utils.ConstantsK.drivePTK));
                    Utils.ConstantsK.semPTK.release();
                    Utils.ConstantsK.mutexPTK.release();

                    //Se incrementa el número de capitulos producidos
                    Utils.ConstantsK.numCaps++;
                    Interface.CapsTotal2.setText(Integer.toString(Utils.ConstantsK.numCaps));

                    //Se libera
                    Utils.ConstantsK.mutexAssemblerK.release();

                    Thread.sleep(tiempoDia * 2000); //2 días por capítulo
                } else {
                    //Si no hay nada qué producir, se libera
                    Utils.ConstantsK.mutexAssemblerK.release();

                }
            } catch (Exception e) {
            }

        }
    }

    public void stopRun() {
        this.stop = true;
    }

}
