package Proyectil;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Obstaculos.Obstaculo;

public class ProyectilJugador extends Proyectil {

	public ProyectilJugador(char d,/*Enemigo e*/int x, int ancho, int y, int largo, Juego j) {
		super(8,d,j);
		etiqueta = new JLabel(gb.get_bala_jugador());
		this.getEtiqueta().setSize(10,10);
		//this.getEtiqueta().setLocation(x+(ancho/2)-10, y-10);
		setPosicion_inicial(d,x,y,ancho,largo);
		getJuego().agregar_proyectil(this);
		System.out.println("agregue");
		// TODO Auto-generated constructor stub
	}
	
	private void setPosicion_inicial(char d, int x, int y, int a, int l)
	{
		switch(d)
		{
		case'n' :
		{
			this.setX(x+(a/2)-5);
			this.setY(y-10);
			break;
		}
		case 's' :
		{
			this.setX(x+(a/2)-5);
			this.setY(y+60);
			break;
		}
		case 'd':
		{
			this.setX(x+60);
			this.setY(y+(l/2)-5);
			break;
		}
		case 'i':
		{
			this.setX(x-10);
			this.setY(y+(l/2)-5);
			break;
		}
		}
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
