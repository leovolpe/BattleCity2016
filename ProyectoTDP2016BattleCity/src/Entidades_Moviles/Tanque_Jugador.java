package Entidades_Moviles;

import javax.swing.JLabel;

import ControladorDeTeclado.manejador_teclado_jugador;
import Graficas_Personajes.graficos_entidad;
import Graficas_Personajes.Tanque.graficos_tanque;

public class Tanque_Jugador extends EntidadMovil {

	private int puntaje;
	private int vidas;
	private boolean inmunidad;
	private int nivel;
	
	private manejador_teclado_jugador teclado;
	
	public Tanque_Jugador(int r, int vm, int vd, int ds, int dp) {
		super(2, 2, 2, 2, 2,'n');
		graficos = new graficos_tanque();
		
		//inicializo objetodejuego
		x=500;
		y=500;
		
		etiqueta = new JLabel(graficos.getArriba());
		//etiqueta.setBounds(60, 60, x, y);
		etiqueta.setSize(60, 60);
		etiqueta.setLocation(x, y);
		
		teclado = new manejador_teclado_jugador(this);
		puntaje=0;
		vidas=4;
		inmunidad=false;
		nivel=1;
	}


	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean puede_disparar() {
		// TODO Auto-generated method stub
		return false;
	}


	public manejador_teclado_jugador getTeclado() {
		return teclado;
	}
	
	

}
