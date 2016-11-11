package PowerUps;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;

public class Pala extends PowerUp {

	public Pala(Juego j, int x, int y) 
	{
		super(j);
		etiqueta = new JLabel(graficos.getPala());
		etiqueta.setSize(60,60);
		
		this.setX(x);
		this.setY(y);
	}

	
	@Override
	public void contacto(Tanque_Jugador ta) 
	{
		ta.aumentarPuntaje(puntos);
		getJuego().getTerreno_logico().paredes_acero();
		destruirse();
	}

	
	
}


