package Juego;

import Entidades_Moviles.Tanque_Jugador;
import Gui.Gui_Juego;

public class Juego 
{
	
	private Gui_Juego gui;
	private Tanque_Jugador tanque;
	
	public Juego()
	{
		tanque = new Tanque_Jugador(5, 5, 5, 5, 5);
		Gui_Juego  g = new Gui_Juego(this, tanque);
		g.setVisible(true);
		
		
		
	}

	public Gui_Juego getGui() {
		return gui;
	}

	public Tanque_Jugador getTanque() {
		return tanque;
	}

}
