/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Assemblers;

import Interfaces.Interface;

/**
 *
 * @author Jose Rubin
 */
public class AssemblerJ extends Thread {

	public int id;
    public boolean stop;
    public int tiempoDia = 1; //esto tiene que venir luego del json

    public boolean enableToAssemble() {
        if (Utils.Constants.driveIntroJ > 0 && Utils.Constants.driveCreditsJ > 0 && Utils.Constants.driveStartJ > 0 && Utils.Constants.driveClosureJ > 0 && Utils.Constants.drivePTJ > 0) {
            return true;
        }
        return false;
    }

    public AssemblerJ(int id) {
        this.id = id;
        this.stop = false;
    }

    @Override
    public void run() {
        while (!this.stop) {
            try {
                //Se toma en exclusividad la función de ensamblador
                Utils.Constants.mutexAssemblerJ.acquire();

                if (this.enableToAssemble()) {

                    //Para sacar 1 intro
                    Utils.Constants.mutexIntroJ.acquire();
                    Utils.Constants.semIntroJ.acquire();
                    Utils.Constants.driveIntroJ--;
                    Utils.Constants.semIntroJ.release();
                    Utils.Constants.mutexIntroJ.release();

                    //Para sacar 1 credit
                    Utils.Constants.mutexCreditsJ.acquire();
                    Utils.Constants.semCreditsJ.acquire();
                    Utils.Constants.driveCreditsJ--;
                    Utils.Constants.semCreditsJ.release();
                    Utils.Constants.mutexCreditsJ.release();

                    //Para sacar 1 start
                    Utils.Constants.mutexStartJ.acquire();
                    Utils.Constants.semStartJ.acquire();
                    Utils.Constants.driveStartJ--;
                    Utils.Constants.semStartJ.release();
                    Utils.Constants.mutexStartJ.release();

                    //Para sacar 1 closure
                    Utils.Constants.mutexClosureJ.acquire();
                    Utils.Constants.semClosureJ.acquire();
                    Utils.Constants.driveClosureJ--;
                    Utils.Constants.semClosureJ.release();
                    Utils.Constants.mutexClosureJ.release();

                    //Para sacar 1 plot twist
                    Utils.Constants.mutexPTJ.acquire();
                    Utils.Constants.semPTJ.acquire();
                    Utils.Constants.drivePTJ--;
                    Utils.Constants.semPTJ.release();
                    Utils.Constants.mutexPTJ.release();

                    //Se incrementa el número de capitulos producidos
                    Utils.Constants.numCapsJ++;
					Interface.CapsTotal.setText(Integer.toString(Utils.Constants.numCapsJ));
                    //Se libera
                    Utils.Constants.mutexAssemblerJ.release();

                    Thread.sleep(tiempoDia * 2000); //2 días por capítulo
                } else {
                    //Si no hay nada qué producir, se libera
                    Utils.Constants.mutexAssemblerJ.release();

                }
            } catch (Exception e) {
            }

        }
    }
	public void stopRun() {
        this.stop = true;
    }
    
}
