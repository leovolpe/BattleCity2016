package Juego;

import ControladorDeTeclado.manejador_auxiliar_teclado;
import ControladorDeTeclado.manejador_teclado_jugador;
import Enemigos.Enemigo;
import Enemigos.EnemigoBasico;
import Enemigos.EnemigoBlindado;
import Enemigos.EnemigoDePoder;
import Enemigos.EnemigoRapido;
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
	
	
	//temporal!!
	private boolean hayEnemigo;
	private Enemigo EnemigoEnPantalla;
	//temporal
	
	public Juego()
	{
		tanque = new Tanque_Jugador(this);
		gui = new Gui_Juego(this, tanque);
		gui.setVisible(true);
		
		gui.addKeyListener(new manejador_auxiliar_teclado(this));
		terreno_logico = new TerrenoLogico(gui.getGj(), tanque);
		//le envia por parametro los graficos del sector dodnde se desarrolla el juego
		//es decir contiene el panel donde estaran los tanques, enemigos, etc.
		 
		hayEnemigo=false;
		
	}

	public Gui_Juego getGui() {
		return gui;
	}

	public void quitarObstaculo()
	{
		terreno_logico.quitarObstaculo();
	}
	
	
	public Tanque_Jugador getTanque() {
		return tanque;
	}

	public void agregarEnemigo()
	{
		hayEnemigo=true;
		EnemigoEnPantalla=new EnemigoRapido(15, 5, 5, 5, 5, 5, this);
		gui.getGj().agregar_enemigo(EnemigoEnPantalla);
	}
	
	public void quitarEnemigo()
	{
		hayEnemigo=false;
		EnemigoEnPantalla.destruirse(this);
		gui.getGi().getPanel_info().repaint();
		gui.getGj().getPanel_tanque().repaint();
		tanque.aumentarPuntaje(EnemigoEnPantalla.recibirDisparo());
		EnemigoEnPantalla=null;
	}
	
	public Enemigo getEnemigoEnPantalla()
	{
		return EnemigoEnPantalla;
	}
	
	
	
	public boolean hayEnemigo()
	{
		return hayEnemigo;
	}

	public TerrenoLogico getTerreno_logico() {
		return terreno_logico;
	}
}
