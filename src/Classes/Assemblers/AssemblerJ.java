/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Assemblers;

import Interfaces.Interface;
import static Utils.Constants.driveClosureJ;
import static Utils.Constants.driveCreditsJ;
import static Utils.Constants.driveIntroJ;
import static Utils.Constants.drivePTJ;
import static Utils.Constants.driveStartJ;
import static Utils.Constants.numCapsJ;
import static Utils.Constants.tiempoDia;

/**
 *
 * @author Jose Rubin
 */
public class AssemblerJ extends Thread {

	public int id;
    public boolean stop;

    public boolean enableToAssemble() {
        if (Utils.Constants.driveIntroJ > 0 && Utils.Constants.driveCreditsJ > 0 && Utils.Constants.driveStartJ >= 2 && Utils.Constants.driveClosureJ > 0 && Utils.Constants.drivePTJ > 0) {
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
                    Utils.Constants.driveIntroJ--;
					Interface.DriveIntro.setText(Integer.toString(driveIntroJ));
                    Utils.Constants.semIntroJ.release();
                    Utils.Constants.mutexIntroJ.release();

                    //Para sacar 1 credit
                    Utils.Constants.mutexCreditsJ.acquire();
                    Utils.Constants.driveCreditsJ--;
					Interface.DriveCredits.setText(Integer.toString(driveCreditsJ));
                    Utils.Constants.semCreditsJ.release();
                    Utils.Constants.mutexCreditsJ.release();

                    //Para sacar 1 start
                    Utils.Constants.mutexStartJ.acquire();
                    Utils.Constants.driveStartJ--;
                    Utils.Constants.driveStartJ--;
					Interface.DriveInicio.setText(Integer.toString(driveStartJ));
                    Utils.Constants.semStartJ.release();
                    Utils.Constants.mutexStartJ.release();
					
					if(numCapsJ % 5 == 0 && numCapsJ>0){
						
						//Para sacar 1 plot twist
						System.out.println("PT");

						Utils.Constants.mutexPTJ.acquire();
						Utils.Constants.drivePTJ--;
						Interface.DrivePT.setText(Integer.toString(drivePTJ));
						Utils.Constants.mutexPTJ.release();
						
					}else{

						//Para sacar 1 closure
						Utils.Constants.mutexClosureJ.acquire();
						Utils.Constants.driveClosureJ--;
						Interface.DriveCierre.setText(Integer.toString(driveClosureJ));
						Utils.Constants.semClosureJ.release();
						Utils.Constants.mutexClosureJ.release();
					}


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
