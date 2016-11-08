package PowerUps;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;

public class Granada extends PowerUp {

	public Granada(Juego j, int x, int y) {
		super(j);
		etiqueta = new JLabel(graficos.getGranada());
		etiqueta.setSize(60,60);
		
		this.setX(x);
		this.setY(y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contacto(Tanque_Jugador ta) 
	{
		ta.aumentarPuntaje(puntos);
		getJuego().getCont_ene().destruir_todos(getJuego());
		destruirse();
		
	}

	
	



}