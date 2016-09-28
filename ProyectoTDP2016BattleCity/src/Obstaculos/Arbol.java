package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;

public class Arbol extends Obstaculo{

	private final static int resistencia=3;
	
	public Arbol(int xx, int yy, Juego j) {
		super(resistencia,j);
		etiqueta=new JLabel(graficos.getArbol());
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
		return true;
		
	}
}
