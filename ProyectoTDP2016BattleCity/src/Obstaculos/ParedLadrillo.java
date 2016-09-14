package Obstaculos;

import javax.swing.JLabel;

public class ParedLadrillo extends Obstaculo{

	private final static int resistencia=5;
	
	public ParedLadrillo() {
		super(resistencia);
		etiqueta=new JLabel(graficos.getLadrillo());
		
	}

	@Override
	public void recibirDisparo() {

		
	}

}
