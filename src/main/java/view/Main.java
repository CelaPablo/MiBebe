package view;

import javax.swing.WindowConstants;
import model.Ambiente;
import model.Bebe;

public class Main {
	
	public static void main(String[] args) {
		Bebe bebe = new Bebe();
		Ambiente ambiente = new Ambiente();
		
		BabyInterface interfaz = new BabyInterface(bebe, ambiente);
		interfaz.setLocationRelativeTo(null);
		interfaz.setVisible(true);
		interfaz.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
