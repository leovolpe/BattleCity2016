package Obstaculos;

import Entidades_Moviles.EntidadMovil;
import Graficas_Obstaculos.graficos_obstaculo;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;

/**
 * Clase que modela un obstaculo
 *
 */
public abstract class Obstaculo extends ObjetoDeJuego {
	
	protected int resistencia;
	protected graficos_obstaculo graficos;
	
	
	public Obstaculo(int r, Juego j)
	{
		super(j);
		resistencia=r;
		graficos=new graficos_obstaculo();
	}
	
	public abstract boolean atravezable();
	
	public abstract void recibirDisparo();
	
	//public abstract void contacto(EntidadMovil e);
	
	public void destruirse()
	{
		getJuego().getGui().getGj().getPanel_obstaculos().remove(this.getEtiqueta());
		getJuego().getGui().getGj().getPanel_obstaculos().repaint();
	}
}
