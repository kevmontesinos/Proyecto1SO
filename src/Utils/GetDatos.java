import static Interfaces.Interface.AssemblersJ1;
import static Interfaces.Interface.AssemblersJ2;
import static Interfaces.Interface.ProducersClosers;
import static Interfaces.Interface.ProducersClosers2;
import static Interfaces.Interface.ProducersClosers4;
import static Interfaces.Interface.ProducersCred;
import static Interfaces.Interface.ProducersCred2;
import static Interfaces.Interface.ProducersInicio;
import static Interfaces.Interface.ProducersInicio2;
import static Interfaces.Interface.ProducersIntro;
import static Interfaces.Interface.ProducersIntro2;
import static Interfaces.Interface.ProducersPT;
import static Interfaces.Interface.countdownJose;
import static Utils.Constants.countdownProductoraJ;
import static Utils.Constants.driveMaxCierreJose;
import static Utils.Constants.driveMaxCreditosJose;
import static Utils.Constants.driveMaxInicioJose;
import static Utils.Constants.driveMaxIntroJose;
import static Utils.Constants.driveMaxPlotTwistJose;
import static Utils.Constants.numAssemblersJose;
import static Utils.Constants.numProducerClosureJose;
import static Utils.Constants.numProducerCreditsJose;
import static Utils.Constants.numProducerIntroJose;
import static Utils.Constants.numProducerPTJose;
import static Utils.Constants.numProducerStartJose;
import static Utils.Constants.promedioGastosJose;
import static Utils.Constants.promedioGananciasJose;
import static Utils.Constants.promedioPerdidaPMJose;
import static Utils.Constants.promedioNumTotalCaps1;
import static Utils.ConstantsK.countdownProductoraK;
import static Utils.ConstantsK.numAssemblerKev;
import static Utils.ConstantsK.numProducerClosureKev;
import static Utils.ConstantsK.numProducerCreditsKev;
import static Utils.ConstantsK.numProducerIntroKev;
import static Utils.ConstantsK.numProducerPTKev;
import static Utils.ConstantsK.numProducerStartKev;
import static Utils.ConstantsK.promedioGastosKev;
import static Utils.ConstantsK.promedioGananciasKev;
import static Utils.ConstantsK.promedioPerdidaJefesKev;
import static Utils.WriteFile.txtAction;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.JSONArray;


/**
 *
 * @author Jose Rubin
 */
public class GetDatos {
    
    ArrayList dataGastos1 = new ArrayList();
    ArrayList dataGastos2 = new ArrayList();
    ArrayList dataGanancia1 = new ArrayList();
    ArrayList dataGanancia2 = new ArrayList();
    ArrayList capsGanancia1 = new ArrayList();
    ArrayList capsGanancia2 = new ArrayList();
    ArrayList capsTotal1 = new ArrayList();
    ArrayList capsTotal2 = new ArrayList();
    ArrayList perdidaPM1 = new ArrayList();
    ArrayList perdidaPM2 = new ArrayList();
    
    public static int totalGastosSalario1;
    public static int totalGastosSalario2;
    public static int totalGananciaNeta1;
    public static int totalGananciaNeta2;
    // public static int totalCapsonosGan1;
    // public static int totalCapsonosGan2;
    public static int totalnumCaps1;
    public static int totalnumCaps2;
    public static int totalperdidaPM1;
    public static int totalperdidaPM2;

    public void getData(){
    
        JSONArray data = txtAction.readJson("DataPlantas.json");
        Map<String, Object> map = (Map<String, Object>) data.get(0);
        for (String key : map.keySet())
            switch(key){
                case "tiempoDia": 
                    Utils.Constants.tiempoDia = Integer.valueOf((String)map.get(key));
                    Utils.ConstantsK.tiempoDia = Integer.valueOf((String)map.get(key));
                    break;
                case "countdown":
                    countdownProductoraJ = Integer.valueOf((String)map.get(key));
                    countdownProductoraK = Integer.valueOf((String)map.get(key));
                    countdownJose.setText(Integer.toString(countdownProductoraJ));
//                    countdownKev.setText(Integer.toString(countdownProductoraK));
                    break;
                case "driveMaxIntroJose":
                    driveMaxIntroJose = Integer.valueOf((String)map.get(key));
                    break;
                case "driveMaxInicioJose":
                    driveMaxInicioJose = Integer.valueOf((String)map.get(key));
                    break;
                case "driveMaxCreditosJose":
                    driveMaxCreditosJose = Integer.valueOf((String)map.get(key));
                    break;
                case "driveMaxCierreJose":
                    driveMaxCierreJose = Integer.valueOf((String)map.get(key));
                    break;
                case "driveMaxPlotTwistJose":
                    driveMaxPlotTwistJose = Integer.valueOf((String)map.get(key));
                    break;
                case "numAssemblersJose":
                    numAssemblersJose = Integer.valueOf((String)map.get(key));
                    AssemblersJ1.setText(Integer.toString(numAssemblersJose));
                    break;
//                case "driveMaxIntroKev":
//                    driveMaxIntroKev = Integer.valueOf((String)map.get(key));
//                    break;
//                case "driveMaxInicioKev":
//                    driveMaxInicioKev = Integer.valueOf((String)map.get(key));
//                    break;
//                case "driveMaxCreditosKev":
//                    driveMaxCreditosKev = Integer.valueOf((String)map.get(key));
//                    break;
//                case "driveMaxCierreKev":
//                    driveMaxCierreKev = Integer.valueOf((String)map.get(key));
//                    break;
//                case "driveMaxPlotTwistKev":
//                    driveMaxPlotTwistKev = Integer.valueOf((String)map.get(key));
//                    break;
                case "numAssemblersKev":
                    numAssemblerKev = Integer.valueOf((String)map.get(key));
                    AssemblersJ2.setText(Integer.toString(numAssemblerKev));
                    break;
                case "numProducerIntroJose":
                    numProducerIntroJose = Integer.valueOf((String)map.get(key));
                    ProducersIntro.setText(Integer.toString(numProducerIntroJose));
                    break;
                case "numProducerCreditsJose":
                    numProducerCreditsJose = Integer.valueOf((String)map.get(key));
                    ProducersCred.setText(Integer.toString(numProducerCreditsJose));
                    break;
                case "numProducerClosureJose":
                    numProducerClosureJose = Integer.valueOf((String)map.get(key));
                    ProducersClosers.setText(Integer.toString(numProducerClosureJose));
                    break;
                case "numProducerStartJose":
                    numProducerStartJose = Integer.valueOf((String)map.get(key));
                    ProducersInicio.setText(Integer.toString(numProducerStartJose));
                    break;
                case "numProducerPTJose":
                    numProducerPTJose = Integer.valueOf((String)map.get(key));
                    ProducersPT.setText(Integer.toString(numProducerPTJose));
                    break;
                case "numProducerIntroKev":
                    numProducerIntroKev = Integer.valueOf((String)map.get(key));
                    ProducersIntro2.setText(Integer.toString(numProducerIntroKev));
                    break;
                case "numProducerCreditsKev":
                    numProducerCreditsKev = Integer.valueOf((String)map.get(key));
                    ProducersCred2.setText(Integer.toString(numProducerCreditsKev));
                    break;
                case "numProducerClosureKev":
                    numProducerClosureKev = Integer.valueOf((String)map.get(key));
                    ProducersClosers2.setText(Integer.toString(numProducerClosureKev));
                    break;
                case "numProducerStartKev":
                    numProducerStartKev = Integer.valueOf((String)map.get(key));
                    ProducersInicio2.setText(Integer.toString(numProducerStartKev));
                    break;
                case "numProducerPTKev":
                    numProducerPTKev = Integer.valueOf((String)map.get(key));
                    ProducersClosers4.setText(Integer.toString(numProducerPTKev));
                    break;
            }
    }
    
    public void getDataforDashboard(){
        
        JSONArray data2 = txtAction.readJson("DataHistorica.json");
        Map<String, Object> map2 = (Map<String, Object>) data2.get(0);
        for (String key2 : map2.keySet())
            switch(key2){
                case "GastosSalario1": 
                    dataGastos1 = (ArrayList) map2.get(key2);
                    for (int i = 0; i<dataGastos1.size(); i++){
                        totalGastosSalario1 = totalGastosSalario1 + Integer.valueOf((String)dataGastos1.get(i));
                    }
                    promedioGastosJose = totalGastosSalario1/dataGastos1.size();
                    break;
                case "GastosSalario2":
                    dataGastos2 = (ArrayList) map2.get(key2);
                    for (int i = 0; i<dataGastos2.size(); i++){
                        totalGastosSalario2 = totalGastosSalario2 + Integer.valueOf((String)dataGastos2.get(i));
                    }
                    promedioGastosKev = totalGastosSalario2/dataGastos2.size();
                    break;
                case "GananciaNeta1":
                    dataGanancia1 = (ArrayList) map2.get(key2);
                    for (int i = 0; i<dataGanancia1.size(); i++){
                        totalGananciaNeta1 = totalGananciaNeta1 + Integer.valueOf((String)dataGanancia1.get(i));
                    }
                    promedioGananciasJose = totalGananciaNeta1/dataGanancia1.size();
                    break;
                case "GananciaNeta2":
                    dataGanancia2 = (ArrayList) map2.get(key2);
                    for (int i = 0; i<dataGanancia2.size(); i++){
                        totalGananciaNeta2 = totalGananciaNeta2 + Integer.valueOf((String)dataGanancia2.get(i));
                    }
                    promedioGananciasKev = totalGananciaNeta2/dataGanancia2.size();
                    break;
//                case "CapsGanancia1":
//                    capsGanancia1 = (ArrayList) map2.get(key2);
//                    for (int i = 0; i<capsGanancia1.size(); i++){
//                        totalCapsGan1 = totalCapsGan1 + Integer.valueOf((String)capsGanancia1.get(i));
//                    }
//                    promedioCapsGananciasJose = totalCapsGan1/capsGanancia1.size();
//                    break;
//                case "CapsGanancia2":
//                    capsGanancia2 = (ArrayList) map2.get(key2);
//                    for (int i = 0; i<capsGanancia2.size(); i++){
//                        totalCapsGan2 = totalCapsGan2 + Integer.valueOf((String)capsGanancia2.get(i));
//                    }
//                    promedioCapsGananciasKev = totalCapsGan2/capsGanancia2.size();
//                    break;
                case "numCapsTotal1":
                    capsTotal1 = (ArrayList) map2.get(key2);
                    for (int i = 0; i<capsTotal1.size(); i++){
                        totalnumCaps1 = totalnumCaps1 + Integer.valueOf((String)capsTotal1.get(i));
                    }
                    promedioNumTotalCaps1 = totalnumCaps1/capsTotal1.size();
                    break;
//                case "numCapsTotal2":
//                    capsTotal2 = (ArrayList) map2.get(key2);
//                    for (int i = 0; i<capsTotal2.size(); i++){
//                        totalnumCaps2 = totalnumCaps2 + Integer.valueOf((String)capsTotal2.get(i));
//                    }
//                    promedioNumTotalCaps2 = totalnumCaps2/capsTotal2.size();
//                    break;
                case "perdidaPM1":
                    perdidaPM1 = (ArrayList) map2.get(key2);
                    for (int i = 0; i<perdidaPM1.size(); i++){
                        totalperdidaPM1 = totalperdidaPM1 + Integer.valueOf((String)perdidaPM1.get(i));
                    }
                    promedioPerdidaPMJose = totalperdidaPM1/perdidaPM1.size();
                    break;
                case "perdidaPM2":
                    perdidaPM2 = (ArrayList) map2.get(key2);
                    for (int i = 0; i<perdidaPM2.size(); i++){
                        totalperdidaPM2 = totalperdidaPM2 + Integer.valueOf((String)perdidaPM2.get(i));
                    }
                    promedioPerdidaJefesKev = totalperdidaPM2/perdidaPM2.size();
                    break;
        }
    }    
}