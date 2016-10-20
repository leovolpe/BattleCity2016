package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;
import Proyectil.Proyectil;
import Visitor_Proyectiles.Visitor_Proyectil;

public class ParedLadrillo extends Obstaculo{

	
	
	public ParedLadrillo(int xx, int yy, Juego j) {
		super(5,j);
		etiqueta=new JLabel(graficos.getLadrillo());
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
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void recibirDisparo() 
	{
		
		
	}
	
	public void reducir_energia()
	{
		System.out.println("recibio disparo ");
		resistencia--;
		if (resistencia==3)
			this.getEtiqueta().setIcon(graficos.getLadrillo_fuego());
		if (resistencia==0)
			super.destruirse();
	}



	@Override
	public void aceptar_visitor_proyectil(Visitor_Proyectil v) 
	{
		v.visitar(this);
		
	}

	

}
