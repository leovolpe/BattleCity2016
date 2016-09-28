package Proyectil;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;
import Obstaculos.Obstaculo;
import graficos_balas.graficos_balas;

public abstract class Proyectil extends ObjetoDeJuego {
	
	protected int velocidad;
	protected graficos_balas gb;
	
	public Proyectil(int vel, Juego j)
	{
		super(j);
		velocidad=vel;
		gb = new graficos_balas();
	}
	
	public void arriba()
	{
		
	}
	
	public void abajo()
	{
		
	}
	
	public void derecha()
	{
		
	}
	
	public void izquierda()
	{
		
	}
	
	public void mover()
	{
		
	}
	
	public abstract void impactar(Tanque_Jugador t);
	//public abstract void impactar(Enemigo  e); aun no estan implementados los enemigos
	public abstract void impactar(Obstaculo o);
	
	private void destruirse()
	{
		
	}
	

}
