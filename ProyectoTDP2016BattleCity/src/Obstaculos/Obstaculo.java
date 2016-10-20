package Obstaculos;

import Entidades_Moviles.EntidadMovil;
import Graficas_Obstaculos.graficos_obstaculo;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;
import Proyectil.Proyectil;
import Visitor_Proyectiles.Visitor_Proyectil;

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
		getJuego().eliminar_obstaculo(this);
	}
	
	public abstract void aceptar_visitor_proyectil(Visitor_Proyectil v);
}
