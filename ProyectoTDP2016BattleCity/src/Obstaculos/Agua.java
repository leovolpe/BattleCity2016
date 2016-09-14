package Obstaculos;

import javax.swing.JLabel;

public class Agua extends Obstaculo{

	private final static int resistencia=2;
	
	public Agua() {
		super(resistencia);
		etiqueta=new JLabel(graficos.getAgua());
	}

	@Override
	public void recibirDisparo() {

		
	}
}
