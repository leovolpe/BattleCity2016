package Obstaculos;

import javax.swing.JLabel;

public class ParedAcero extends Obstaculo{

	private final static int resistencia=8;
	
	public ParedAcero() {
		super(resistencia);
		etiqueta=new JLabel(graficos.getAcero());
	}

	@Override
	public void recibirDisparo() 
	{

		
	}
}
