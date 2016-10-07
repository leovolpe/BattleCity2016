package Proyectil;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;
import Obstaculos.Obstaculo;
import graficos_balas.graficos_balas;

public abstract class Proyectil extends ObjetoDeJuego {
	
	protected int velocidad;
	protected char direccion;
	protected graficos_balas gb;
	
	
	public Proyectil(int vel, char d, Juego j)
	{
		super(j);
		direccion=d;
		velocidad=vel;
		gb = new graficos_balas();
	}
	
	
	public void mover()
	{
		switch(direccion)
		{
		case 'n' :
		{
			this.setY(this.getY()-velocidad);
			break;
		}
		case 's' :
		{
			this.setY(this.getY()+velocidad);
			break;
		}
		case 'i' :
		{
			this.setX(this.getX()-velocidad);
			break;
		}
		case 'd' :
		{
			this.setX(this.getX()+velocidad);
			break;
		}
		}
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
	
	
	
	public abstract void impactar(Tanque_Jugador t);
	//public abstract void impactar(Enemigo  e); aun no estan implementados los enemigos
	public abstract void impactar(Obstaculo o);
	
	private void destruirse()
	{
		
	}
	

}
