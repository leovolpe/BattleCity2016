package Visitor_Proyectiles;

import Enemigos.EnemigoBasico;
import Enemigos.EnemigoBlindado;
import Enemigos.EnemigoDePoder;
import Enemigos.EnemigoRapido;
import Entidades_Moviles.Tanque_Jugador;
import Proyectil.Proyectil;

public class Visitor_proyectil_jugador_enemigos extends Visitor_Proyectil_enemigos 
{
	protected Tanque_Jugador tanque;
	
	public Visitor_proyectil_jugador_enemigos(Proyectil p, Tanque_Jugador t)
	{
		proy=p;
		tanque=t;
	}
	@Override
	public void visitar(EnemigoBasico e) 
	{
		int pts = e.recibirDisparo();
		tanque.aumentarPuntaje(pts);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(EnemigoBlindado e) 
	{
		int pts = e.recibirDisparo();
		tanque.aumentarPuntaje(pts);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(EnemigoDePoder e) 
	{
		int pts = e.recibirDisparo();
		tanque.aumentarPuntaje(pts);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(EnemigoRapido e) 
	{
		int pts = e.recibirDisparo();
		tanque.aumentarPuntaje(pts);
		// TODO Auto-generated method stub
		
	}

}
