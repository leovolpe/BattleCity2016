package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;

public class ParedLadrillo extends Obstaculo{

	private final static int resistencia=5;
	
	public ParedLadrillo(int xx, int yy, Juego j) {
		super(resistencia,j);
		etiqueta=new JLabel(graficos.getLadrillo());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
		
	}

	@Override
	public void recibirDisparo() {

		
	}

	//@Override
	//public void contacto(EntidadMovil e) {
		
		// TODO Auto-generated method stub
		
	//}

	@Override
	public boolean atravezable() {
		// TODO Auto-generated method stub
		return false;
	}

}
