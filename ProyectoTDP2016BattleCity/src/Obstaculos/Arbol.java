package Obstaculos;

import javax.swing.JLabel;

public class Arbol extends Obstaculo{

	private final static int resistencia=3;
	
	public Arbol() {
		super(resistencia);
		etiqueta=new JLabel(graficos.getArbol());
	}

	@Override
	public void recibirDisparo() {

		
	}
}
