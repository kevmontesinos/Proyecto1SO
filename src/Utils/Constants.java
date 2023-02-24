package Utils;

import Classes.Assemblers.AssemblerJ;
import Classes.Directors.DirectorJ;
import Classes.PM.PmJ;
import Classes.Producers.ProducerPTJ;
import Classes.Producers.ProducersClosureJ;
import Classes.Producers.ProducersCreditsJ;
import Classes.Producers.ProducersIntroJ;
import Classes.Producers.ProducersStartJ;
import java.util.Stack;
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Rubin
 */
public class Constants {
	//Constante Tiempo
	public static int tiempoDia;
	//Constantes Rubin
	public static volatile int countdownJose=30;
	public static int maxWorkersJose=15;
	
	public static int numAssemblersJose;
	public static int numProducerIntroJose;
	public static int numProducerPTJose;
	public static int numProducerClosureJose;
	public static int numProducerCreditsJose;
	public static int numProducerStartJose;
	
    public static int driveMaxIntroJose;
    public static int driveMaxInicioJose;
    public static int driveMaxCreditosJose;
    public static int driveMaxCierreJose;
    public static int driveMaxPlotTwistJose;

	//Semáforos para controlar almacén de los productores.

    public static Semaphore semIntroJ = new Semaphore(30);
    public static Semaphore semCreditsJ = new Semaphore(25);
    public static Semaphore semStartJ = new Semaphore(50);
    public static Semaphore semClosureJ = new Semaphore(55);
    public static Semaphore semPTJ = new Semaphore(40);

    //Semáforos mutex para exclusividad.
    public static Semaphore mutexIntroJ = new Semaphore(1);
    public static Semaphore mutexCreditsJ = new Semaphore(1);
    public static Semaphore mutexStartJ = new Semaphore(1);
    public static Semaphore mutexClosureJ = new Semaphore(1);
    public static Semaphore mutexPTJ = new Semaphore(1);

	//Cantidad de GB en drives de los productores
    public static volatile int driveIntroJ = 0;
    public static volatile int driveCreditsJ = 0;
    public static volatile int driveStartJ = 0;
    public static volatile int driveClosureJ = 0;
    public static volatile int drivePTJ = 0;

    //Cantidad de capítulos producidos/ensamblados
    public static volatile int numCapsJ = 0;

    //Mutex para el ensamblador
    public static Semaphore mutexAssemblerJ = new Semaphore(1);
    
    //Instancia PM
    public static PmJ pmJ;
    
    //Project Manager
    public static volatile int countdownProductoraJ;
    
	//Instancia Director
    public static DirectorJ directorJ;

    //Pilas para todos los cargos
    public static Stack<ProducersIntroJ> stackProducersIntroJ = new Stack<ProducersIntroJ>();
    public static Stack<ProducersCreditsJ> stackProducersCreditsJ = new Stack<ProducersCreditsJ>();
    public static Stack<ProducersStartJ> stackProducersStartJ = new Stack<ProducersStartJ>();
    public static Stack<ProducersClosureJ> stackProducersClosureJ = new Stack<ProducersClosureJ>();
    public static Stack<ProducerPTJ> stackProducerPTJ = new Stack<ProducerPTJ>();
    public static Stack<AssemblerJ> stackAssemblerJ = new Stack<AssemblerJ>();

	//Dinero Constantes
	public static int promedioGastosJose;
    public static int promedioGananciasJose;
    public static int promedioCapsGananciasJose;
    public static int numTotalCapsJose;
    public static int promedioPerdidaPMJose;
    public static int promedioNumTotalCaps1;

	
}
