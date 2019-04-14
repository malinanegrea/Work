package edu.utcluj.lic.TP.Assigment1.Logic;


import edu.utcluj.lic.TP.Assigment1.GUI.Controler;
import edu.utcluj.lic.TP.Assigment1.GUI.View;

public class Main {

	public static void main(String[] args) {		
		
		
		View view = new View();
		Controler cont = new Controler(view);
		cont.setVisible();
	}

}
