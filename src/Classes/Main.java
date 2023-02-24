/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.Interface;
import Utils.GetDatos;
import Utils.WriteFile;

/**
 *
 * @author Kevin
 */
public class Main {

	public static GetDatos datum = new GetDatos();
	public static WriteFile writeNewData = new WriteFile();

    /**
     * @param args the command line arguments
     */

	public static Interface Interface = new Interface();

    public static void main(String[] args) {
        // TODO code application logic here
		datum.getData();
//        writeNewData.writeData();

		Interface.setVisible(true);
    }
    
}
