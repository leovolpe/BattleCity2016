package Enemigos;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Graficas_Personajes.Enemigos.graficos_tanque_basico;
import Graficas_Personajes.Tanque.graficos_tanque;
import Gui.Gui_Juego;
import Juego.Juego;

public class Enemigo extends EntidadMovil{
	
	protected int puntos;
	
	public Enemigo (int r, int vm, int vd, int ds, int dp, int p, Juego j)
	{
		super(r, vm, vd, ds, dp, 's',j);
		puntos=p;
		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
	public void destruirse()
	{
		
	}

	public void destruirse(Juego j) 
	{	
		j.getGui().getGj().getPanel_tanque().remove(this.getEtiqueta());
		
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
