package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;
import Proyectil.Proyectil;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

public class Agua extends Obstaculo{

	private final static int resistencia=2;
	
	public Agua(int xx, int yy, Juego j) {
		super(resistencia,j);
		etiqueta=new JLabel(graficos.getAgua());
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
		return false;
		// TODO Auto-generated method stub
		
	}



	@Override
	public void recibirDisparo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void aceptar_visitor_proyectil(Visitor_Proyectil_obstaculo v) 
	{
		v.visitar(this);
		
	}


}
