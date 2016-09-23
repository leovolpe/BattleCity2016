package Obstaculos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;

public class ParedLadrillo extends Obstaculo{

	private final static int resistencia=5;
	
	public ParedLadrillo(int xx, int yy) {
		super(resistencia);
		etiqueta=new JLabel(graficos.getLadrillo());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
		
	}

	@Override
	public void recibirDisparo() {

		
	}

	@Override
	public void contacto(EntidadMovil e) {
		e.deshacer_mov(this);
		// TODO Auto-generated method stub
		
	}

}
