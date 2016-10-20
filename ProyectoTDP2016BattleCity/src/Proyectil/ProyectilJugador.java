package Proyectil;

import javax.swing.JLabel;

import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Obstaculos.Obstaculo;
import Visitor_Proyectiles.Visitor_proyectil_jugador;

public class ProyectilJugador extends Proyectil 
{
	private Tanque_Jugador tanque;

	public ProyectilJugador(Tanque_Jugador t,char d,int x, int ancho, int y, int largo, Juego j) {
		super(8,d,j);
		tanque=t;
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
	public void impactar(Tanque_Jugador t) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void impactar(Obstaculo o) 
	{
		o.aceptar_visitor_proyectil(new Visitor_proyectil_jugador(this));
	}

	@Override
	public void destruirse() 
	{
		tanque.reducir_disparo();
		getJuego().eliminar_proyectil(this);
	}

	@Override
	public void impactar(Enemigo e) 
	{
		int pts = e.recibirDisparo();
		tanque.aumentarPuntaje(pts);
		destruirse();
		// TODO Auto-generated method stub
		
	}

}
