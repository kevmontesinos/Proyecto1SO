/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Directors;

import Interfaces.Interface;
import static Utils.ConstantsK.countdownProductoraK;
import static Utils.ConstantsK.counterPM;
import static Utils.ConstantsK.descuentoPM;
import static Utils.ConstantsK.estadoDirector;
import static Utils.ConstantsK.estadoPm;
import static Utils.ConstantsK.mutexCountdown;
import static Utils.ConstantsK.numTotalCapsKev;
import static Utils.ConstantsK.tiempoDia;
/**
 *
 * @author Jose Rubin
 */
public class DirectorK extends Thread {
    
public boolean stop;
	
	private int MinutosEnUnDia = 1440;
    private int PeriodoTrabajo = 0;

    public DirectorK() {
        this.stop = false;
    }

	public void stopRun() {
        this.stop = true;
    }

    @Override
    public void run() {
		while (!stop) {
			try{
				
				int MinutosDia = MinutosEnUnDia;
				mutexCountdown.acquire();
				estadoDirector = "Esperando contador";			
				Interface.Director2.setText(estadoDirector);
				if(countdownProductoraK>0){
					estadoPm = "Sprints Reviews";
					Interface.Director2.setText(estadoDirector);
					mutexCountdown.release();
					PeriodoTrabajo = (int) (Math.random() * (1080+60-720)) + 720;
					MinutosDia = MinutosDia-PeriodoTrabajo;
					while(MinutosDia>90){
						int n = (int) (Math.random() * 90+1-30)+30;
						MinutosDia = MinutosDia - n;
						if (estadoPm.equalsIgnoreCase("Ricky y Morty")){
							descuentoPM = descuentoPM+1;
							counterPM=counterPM+1;
							int salario = (30 - countdownProductoraK)* 7;
							Interface.SalarioPm2.setText(Integer.toString(salario - descuentoPM));
							Interface.RegistroPM2.setText(Integer.toString(counterPM));
						}
						Thread.sleep(tiempoDia*n);
					}
				} else{
					mutexCountdown.release();
					numTotalCapsKev=0;
				}
				
				estadoDirector="Casa";
				Interface.Director2.setText(estadoDirector);
				Thread.sleep(tiempoDia*(MinutosEnUnDia-PeriodoTrabajo));
				
			}catch (Exception e) {
			}
		}
	}
}