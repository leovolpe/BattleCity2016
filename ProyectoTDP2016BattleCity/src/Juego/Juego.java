package Juego;

import Enemigos.Enemigo;
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
	private boolean hayEnemigo;
	private Enemigo EnemigoEnPantalla;
	
	public Juego()
	{
		tanque = new Tanque_Jugador(15, 5, 5, 5, 5, this);
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

	public void agregarEnemigo()
	{
		Enemigo enemigo=new Enemigo (15, 5, 5, 5, 5, 5);
		EnemigoEnPantalla=enemigo;
		gui.getGj().agregar_enemigo(enemigo);
	}
	
	public void quitarEnemigo()
	{
		EnemigoEnPantalla.destruirse(gui);
		gui.getGj().getPanel_tanque().repaint();
		EnemigoEnPantalla=null;
	}
	
	public void setHayEnem(boolean h)
	{
		hayEnemigo=h;
	}
	
	public boolean hayEnemigo()
	{
		return hayEnemigo;
	}
}
