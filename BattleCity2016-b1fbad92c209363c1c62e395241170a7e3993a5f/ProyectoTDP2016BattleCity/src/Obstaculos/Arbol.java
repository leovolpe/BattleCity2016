package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;

public class Arbol extends Obstaculo{

	private final static int resistencia=3;
	
	public Arbol(int xx, int yy) {
		super(resistencia);
		etiqueta=new JLabel(graficos.getArbol());
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
