package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;

public class ParedAcero extends Obstaculo{

	private final static int resistencia=8;
	
	public ParedAcero(int xx, int yy) {
		super(resistencia);
		etiqueta=new JLabel(graficos.getAcero());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}

	@Override
	public void recibirDisparo() 
	{

		
	}

	@Override
	public void contacto(EntidadMovil e) {
		e.deshacer_mov(this);
		
	}
}
