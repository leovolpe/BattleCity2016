package PowerUps;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Temporizadores.Temporizador_detener;


public class Timer extends PowerUp {

	public Timer(Juego j, int x, int y) {
		super(j);
		etiqueta = new JLabel(graficos.getTimer());
		etiqueta.setSize(60,60);
		
		this.setX(x);
		this.setY(y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contacto(Tanque_Jugador ta) 
	{
		ta.aumentarPuntaje(puntos);
		Temporizador_detener t = new Temporizador_detener(getJuego(),10);
		new Thread(t).start();
		destruirse();
		
	}

	


}