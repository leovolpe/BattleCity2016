package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;

public class Base extends Obstaculo {
	
	private final static int resistencia=2;

	public Base(int xx, int yy) {
		super(resistencia);
		etiqueta=new JLabel(graficos.getBase());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}

	@Override
	public void recibirDisparo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contacto(EntidadMovil e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean atravezable() {
		return false;
		
	}

}
