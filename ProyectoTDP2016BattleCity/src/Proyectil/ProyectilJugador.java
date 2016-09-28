package Proyectil;

import Entidades_Moviles.Tanque_Jugador;
import Obstaculos.Obstaculo;

public class ProyectilJugador extends Proyectil {

	public ProyectilJugador(/*Enemigo e*/int x, int ancho) {
		super(5);
		this.getEtiqueta().setIcon(gb.get_bala_jugador());
		this.getEtiqueta().setSize(10,10);
		this.getEtiqueta().setLocation(x+(ancho/2)-10, y-10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impactar(Tanque_Jugador t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void impactar(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}

}
