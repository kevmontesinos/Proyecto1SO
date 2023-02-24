/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Interfaces.Interface.Ganancia1;
import static Interfaces.Interface.Ganancia2;
import static Interfaces.Interface.Gastos1;
import static Interfaces.Interface.Gastos2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author Jose Rubin
 */
public class WriteFile {
    

    public static ReadFile txtAction = new ReadFile();

    ArrayList newdataGastos1 = new ArrayList();
    ArrayList newdataGastos2 = new ArrayList();
    ArrayList newdataGanancia1 = new ArrayList();
    ArrayList newdataGanancia2 = new ArrayList();
    // ArrayList newtelefGanancia1 = new ArrayList();
    // ArrayList newtelefGanancia2 = new ArrayList();
    ArrayList newcapsTotal1 = new ArrayList();
    ArrayList newcapsTotal2 = new ArrayList();
    // ArrayList newperdidaJefe1 = new ArrayList();
    // ArrayList newperdidaJefe2 = new ArrayList();

    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();

    public void writeData(){
        JSONArray data3 = txtAction.readJson("DataHistorica.json");
        Map<String, Object> map2 = (Map<String, Object>) data3.get(0);
        JSONObject obj = new JSONObject();
        JSONArray newJson = new JSONArray();
        for (String key2 : map2.keySet())
            switch(key2){
                case "GastosSalario1": 
                    newdataGastos1 = (JSONArray) map2.get(key2);
                    newdataGastos1.add(Gastos1.getText());
                    obj.put(key2, newdataGastos1);
                    break;
                case "GastosSalario2":
                    newdataGastos2 = (JSONArray) map2.get(key2);
                    newdataGastos2.add(Gastos2.getText());
                    obj.put(key2, newdataGastos2);
                    break;
                case "GananciaNeta1":
                    newdataGanancia1 = (JSONArray) map2.get(key2);
                    newdataGanancia1.add(Ganancia1.getText());
                    obj.put(key2, newdataGanancia1);
                    break;
                case "GananciaNeta2":
                    newdataGanancia2 = (JSONArray) map2.get(key2);
                    newdataGanancia2.add(Ganancia2.getText());
                    obj.put(key2, newdataGanancia2);
                    break;
//                case "newcapsTotal1":
//                    newcapsTotal1 = (JSONArray) map2.get(key2);
//                    newcapsTotal1.add(CapsTotal.getText());
//                    obj.put(key2, newcapsTotal1);
//                    break;
//                case "newcapsTotal2":
//                    newcapsTotal2 = (JSONArray) map2.get(key2);
//                    newcapsTotal2.add(CapsTotal2.getText());
//                    obj.put(key2, newcapsTotal2);
//                    break;
                // case "perdidaJefe1":
                //     newperdidaJefe1 = (JSONArray) map2.get(key2);
                //     newperdidaJefe1.add(JefePerdido1.getText());
                //     obj.put(key2, newperdidaJefe1);
                //     break;
                // case "perdidaJefe2":
                //     newperdidaJefe2 = (JSONArray) map2.get(key2);
                //     newperdidaJefe2.add(JefePerdido2.getText());
                //     obj.put(key2, newperdidaJefe2);
                //     break;
            }
        newJson.add(obj);
        
        try {
            FileWriter file = new FileWriter(new File(System.getProperty("user.dir"), "DataHistorica.json"));            
            file.write(newJson.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}