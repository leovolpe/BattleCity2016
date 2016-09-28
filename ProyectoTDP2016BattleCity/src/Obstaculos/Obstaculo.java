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
	protected Juego juego;
	
	public Obstaculo(int r, Juego j)
	{
		juego=j;
		resistencia=r;
		graficos=new graficos_obstaculo();
	}
	
	public abstract boolean atravezable();
	
	public abstract void recibirDisparo();
	
	//public abstract void contacto(EntidadMovil e);
	
	public void destruirse()
	{
		juego.getGui().getGj().getPanel_obstaculos().remove(this.getEtiqueta());
		juego.getGui().getGj().getPanel_obstaculos().repaint();
	}
}
