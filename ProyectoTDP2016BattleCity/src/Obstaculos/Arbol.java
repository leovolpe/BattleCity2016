package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;
import Proyectil.Proyectil;
import Visitor_Proyectiles.Visitor_Proyectil;

public class Arbol extends Obstaculo{

	private final static int resistencia=3;
	
	public Arbol(int xx, int yy, Juego j) {
		super(resistencia,j);
		etiqueta=new JLabel(graficos.getArbol());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
		
	}

	

	//@Override
	//public void contacto(EntidadMovil e) {
		// TODO Auto-generated method stub
		
	//}

	@Override
	public boolean atravezable() {
		return true;
		
	}



	@Override
	public void recibirDisparo() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void aceptar_visitor_proyectil(Visitor_Proyectil v) 
	{
		v.visitar(this);
		
	}
	
}
