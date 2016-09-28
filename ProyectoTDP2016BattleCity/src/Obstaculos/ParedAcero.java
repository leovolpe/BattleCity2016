package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;

public class ParedAcero extends Obstaculo{

	private final static int resistencia=8;
	
	public ParedAcero(int xx, int yy, Juego j) {
		super(resistencia,j);
		etiqueta=new JLabel(graficos.getAcero());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}

	@Override
	public void recibirDisparo() 
	{

		
	}

	//@Override
	//public void contacto(EntidadMovil e) {
		
		
	//}

	@Override
	public boolean atravezable() {
		// TODO Auto-generated method stub
		return false;
	}
}
