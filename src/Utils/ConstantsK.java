package Utils;

import Classes.Assemblers.AssemblerK;
import Classes.Directors.DirectorK;
import Classes.PM.PmK;
import Classes.Producers.ProducerPTK;
import Classes.Producers.ProducersClosureK;
import Classes.Producers.ProducersCreditsK;
import Classes.Producers.ProducersIntroK;
import Classes.Producers.ProducersStartK;
import java.util.Stack;
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class ConstantsK {
    //Constante Tiempo

    public static int tiempoDia;

    //Constantes Kevin
    public static int numMaxProducers = 18;

    public static int numProducerIntroKev;
    public static int numProducerPTKev;
    public static int numProducerClosureKev;
    public static int numProducerCreditsKev;
    public static int numProducerStartKev;
    public static int numAssemblerKev;

    public static volatile int driveMaxIntroKev = 30;
    public static volatile int driveMaxInicioKev = 50;
    public static volatile int driveMaxCreditosKev = 25;
    public static volatile int driveMaxCierreKev = 55;
    public static volatile int driveMaxPlotTwistKev = 40;

    //Semáforos para controlar almacén de los productores.
    public static Semaphore semIntroK = new Semaphore(30);
    public static Semaphore semCreditsK = new Semaphore(25);
    public static Semaphore semStartK = new Semaphore(50);
    public static Semaphore semClosureK = new Semaphore(55);
    public static Semaphore semPTK = new Semaphore(40);

    //Semáforos mutex para exclusividad.
    public static Semaphore mutexIntroK = new Semaphore(1);
    public static Semaphore mutexCreditsK = new Semaphore(1);
    public static Semaphore mutexStartK = new Semaphore(1);
    public static Semaphore mutexClosureK = new Semaphore(1);
    public static Semaphore mutexPTK = new Semaphore(1);

    //Cantidad de GB en drives de los productores
    public static volatile int driveIntroK = 0;
    public static volatile int driveCreditsK = 0;
    public static volatile int driveStartK = 0;
    public static volatile int driveClosureK = 0;
    public static volatile int drivePTK = 0;
    
    //Cantidad de capítulos producidos/ensamblados
    public static volatile int numCaps = 0;

    //Mutex para el ensamblador
    public static Semaphore mutexAssemblerK = new Semaphore(1);
    
    
    //Project Manager
    public static volatile int countdownProductoraK;
    
    //Instancia PM
    public static PmK pmK;
    
    //Estado de PM
    public static String estadoPm;
    
    //Mutex del countdown
    public static Semaphore mutexCountdown = new Semaphore(1);
    
     //Instancia Director
    public static DirectorK directorK;

    //Pilas para todos los cargos
    public static Stack<ProducersIntroK> stackProducersIntroK = new Stack<ProducersIntroK>();
    public static Stack<ProducersCreditsK> stackProducersCreditsK = new Stack<ProducersCreditsK>();
    public static Stack<ProducersStartK> stackProducersStartK = new Stack<ProducersStartK>();
    public static Stack<ProducersClosureK> stackProducersClosureK = new Stack<ProducersClosureK>();
    public static Stack<ProducerPTK> stackProducerPTK = new Stack<ProducerPTK>();
    public static Stack<AssemblerK> stackAssemblerK = new Stack<AssemblerK>();
   
    //Dinero Constantes
    public static int promedioGastosKev;
    public static int promedioGananciasKev;
    public static int promedioCapsGananciasKev;
    public static int numTotalCapsKev;
    public static int promedioPerdidaJefesKev;

}
