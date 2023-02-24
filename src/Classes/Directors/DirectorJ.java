/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Directors;

import Interfaces.Interface;
import static Utils.Constants.countdownProductoraJ;
import static Utils.Constants.counterPM;
import static Utils.Constants.descuentoPM;
import static Utils.Constants.estadoDirector;
import static Utils.Constants.estadoPm;
import static Utils.Constants.mutexCountdownJ;
import static Utils.Constants.numCapsJ;
import static Utils.Constants.tiempoDia;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Rubin
 */
public class DirectorJ extends Thread {
    
public boolean stop;
	
	private int MinutosEnUnDia = 1440;
    private int PeriodoTrabajo = 0;

    public DirectorJ() {
        this.stop = false;
    }

	public void stopRun() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
			try{
				
				mutexCountdownJ.acquire();
				estadoDirector = "Esperando contador";
				
				Interface.Director1.setText(estadoDirector);
				if(countdownProductoraJ>0){
					estadoDirector = "Sprints Reviews";
					Interface.Director1.setText(estadoDirector);

					mutexCountdownJ.release();
					PeriodoTrabajo = (int) (Math.random() * (1080+60-720)) + 720;
					MinutosEnUnDia = MinutosEnUnDia-PeriodoTrabajo;
					while(MinutosEnUnDia>90){
						int n = (int) (Math.random() * 90+1-30)+30;
						MinutosEnUnDia = MinutosEnUnDia - n;

						if (estadoPm.equalsIgnoreCase("Ricky y Morty")){
							descuentoPM = descuentoPM+1;
							counterPM=counterPM+1;
							System.out.println(counterPM);
							Interface.SalarioPm1.setText(Integer.toString(descuentoPM));
							Interface.RegistroPM1.setText(Integer.toString(counterPM));
							Interface.Director1.setText(estadoDirector);
						}
						Thread.sleep(tiempoDia);
					}
				} else{
					mutexCountdownJ.release();
					numCapsJ=0;
				}
				
				estadoDirector="Casa";
				Interface.Director1.setText(estadoDirector);
				Thread.sleep(tiempoDia*(MinutosEnUnDia-PeriodoTrabajo));
				
			}catch (InterruptedException ex) {
				Logger.getLogger(DirectorJ.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
