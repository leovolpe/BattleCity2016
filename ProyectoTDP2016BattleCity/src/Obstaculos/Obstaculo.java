package Obstaculos;

import Graficas_Obstaculos.graficos_obstaculo;
import Graficas_Personajes.graficos_entidad;
import ObjetosDeJuego.ObjetoDeJuego;

public abstract class Obstaculo extends ObjetoDeJuego {
	
	protected int resistencia;
	protected graficos_obstaculo graficos;
	
	public Obstaculo(int r)
	{
		resistencia=r;
		graficos=new graficos_obstaculo();
	}
	
	public abstract void recibirDisparo();
	
	public void destruirse()
	{
		
	}
}
