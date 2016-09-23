package Juego;

import Entidades_Moviles.Tanque_Jugador;
import Gui.Gui_Juego;
import Terreno.TerrenoLogico;


/*
 * Clase que inicializa la parte grafica, el tanque, y el terreno logico
 */
public class Juego 
{
	
	private Gui_Juego gui;
	private Tanque_Jugador tanque;
	private TerrenoLogico terreno_logico;
	
	public Juego()
	{
		tanque = new Tanque_Jugador(15, 5, 5, 5, 5);
		gui = new Gui_Juego(this, tanque);
		gui.setVisible(true);
		
		//le envia por parametro los graficos del sector dodnde se desarrolla el juego
		//es decir contiene el panel donde estaran los tanques, enemigos, etc.
		terreno_logico = new TerrenoLogico(gui.getGj(), tanque); 
	
		
	}

	public Gui_Juego getGui() {
		return gui;
	}

	public Tanque_Jugador getTanque() {
		return tanque;
	}

}
