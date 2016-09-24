package Enemigos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Graficas_Personajes.Enemigos.graficos_tanque_basico;
import Graficas_Personajes.Tanque.graficos_tanque;

public class Enemigo extends EntidadMovil{
	
	protected int puntos;
	
	public Enemigo (int r, int vm, int vd, int ds, int dp, int p)
	{
		super(r, vm, vd, ds, dp, 's');
		puntos=p;
		graficos = new graficos_tanque_basico();
		etiqueta=new JLabel(graficos.getAbajo());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(0);
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruirse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puede_disparar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int recibirDisparo()
	{
		return puntos;
	}

}
