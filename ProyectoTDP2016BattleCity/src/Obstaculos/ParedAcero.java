package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;
import Proyectil.Proyectil;
import Visitor_Proyectiles.Visitor_Proyectil;

public class ParedAcero extends Obstaculo{

	private final static int resistencia=8;
	
	public ParedAcero(int xx, int yy, Juego j) {
		super(resistencia,j);
		etiqueta=new JLabel(graficos.getAcero());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}

	

	//@Override
	//public void contacto(EntidadMovil e) {
		
		
	//}

	@Override
	public boolean atravezable() {
		// TODO Auto-generated method stub
		return false;
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
