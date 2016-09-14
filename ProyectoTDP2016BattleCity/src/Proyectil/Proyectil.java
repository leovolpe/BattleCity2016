package Proyectil;

import Entidades_Moviles.Tanque_Jugador;
import ObjetosDeJuego.ObjetoDeJuego;
import Obstaculos.Obstaculo;

public abstract class Proyectil extends ObjetoDeJuego {
	
	protected int velocidad;
	
	public Proyectil(int vel)
	{
		velocidad=vel;
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
