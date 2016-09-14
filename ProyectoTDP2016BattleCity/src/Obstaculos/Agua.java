package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;

public class Agua extends Obstaculo{

	private final static int resistencia=2;
	
	public Agua(int xx, int yy) {
		super(resistencia);
		etiqueta=new JLabel(graficos.getAgua());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}

	@Override
	public void recibirDisparo() {

		
	}

	@Override
	public void contacto(EntidadMovil e) {
		// TODO Auto-generated method stub
		
	}
}
