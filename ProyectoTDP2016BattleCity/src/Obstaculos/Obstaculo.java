package Obstaculos;

import Entidades_Moviles.EntidadMovil;
import Graficas_Obstaculos.graficos_obstaculo;
import ObjetosDeJuego.ObjetoDeJuego;

/**
 * Clase que modela un obstaculo
 *
 */
public abstract class Obstaculo extends ObjetoDeJuego {
	
	protected int resistencia;
	protected graficos_obstaculo graficos;
	
	public Obstaculo(int r)
	{
		resistencia=r;
		graficos=new graficos_obstaculo();
	}
	
	public abstract boolean atravezable();
	
	public abstract void recibirDisparo();
	
	public abstract void contacto(EntidadMovil e);
	
	public void destruirse()
	{
		
	}
}
