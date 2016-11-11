package Proyectil;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Obstaculos.Obstaculo;
import Visitor_Proyectiles.Visitor_proyectil_jugadorN4_obstaculo;


public class Proyectil_Jugador_N4 extends ProyectilJugador {

	
	public Proyectil_Jugador_N4(Tanque_Jugador t, char d, int x, int ancho, int y, int largo, Juego j, int vd) 
	{
		super(t, d, x, ancho, y, largo, j, vd);
	}
	
	
	@Override
	public void impactar(Obstaculo o)
	{
		o.aceptar_visitor_proyectil(new Visitor_proyectil_jugadorN4_obstaculo(this,getJuego()));
	}

}
