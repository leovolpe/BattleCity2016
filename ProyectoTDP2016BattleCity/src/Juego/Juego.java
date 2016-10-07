package Juego;

import java.util.Random;

import ControladorDeTeclado.manejador_auxiliar_teclado;
import Controladores.Controlador_Enemigos;
import Controladores.Controlador_balas;
import Enemigos.Enemigo;
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
	
	private Controlador_balas cont_balas;
	private Thread hilo_balas;
	
	private Controlador_Enemigos cont_ene;
	private Thread hilo_enemigos;
	
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
		terreno_logico = new TerrenoLogico(this);
		//le envia por parametro los graficos del sector dodnde se desarrolla el juego
		//es decir contiene el panel donde estaran los tanques, enemigos, etc.
		 
		hayEnemigo=false;
		
		//Agregar despues!
		cont_balas = new Controlador_balas();
		hilo_balas = new Thread(cont_balas);
		hilo_balas.start();
		
		cont_ene = new Controlador_Enemigos();
		hilo_enemigos = new Thread(cont_ene);
		hilo_enemigos.start();
		

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
		
		Random  rnd = new Random();
		//int posx = (int) (rnd.nextDouble() * 13)*60 ;
		
		int posx = (rnd.nextInt()%13)*60;
		if (posx<0) posx*=-1;
		System.out.println(posx);
		
		
		EnemigoEnPantalla.setX(posx);
		gui.getGj().agregar_enemigo(EnemigoEnPantalla);
		cont_ene.add_Enemigo(EnemigoEnPantalla);
	}
	
	public void quitarEnemigo()
	{
		hayEnemigo=false;
		EnemigoEnPantalla.destruirse(this);
		gui.getGi().getPanel_info().repaint();
		gui.getGj().getPanel_tanque().repaint();
		tanque.aumentarPuntaje(EnemigoEnPantalla.recibirDisparo());
		cont_ene.elim_enemigo(EnemigoEnPantalla);
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
