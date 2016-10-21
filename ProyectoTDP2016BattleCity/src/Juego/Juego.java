package Juego;

import java.util.Random;

import ControladorDeTeclado.manejador_auxiliar_teclado;
import Controladores.Controlador_Enemigos;
import Controladores.Controlador_balas;
import Enemigos.Enemigo;
import Enemigos.EnemigoBlindado;
import Enemigos.*;
import Entidades_Moviles.Tanque_Jugador;
import Gui.Gui_Juego;
import Obstaculos.Obstaculo;
import Proyectil.Proyectil;
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
		cont_balas = new Controlador_balas(this);
		hilo_balas = new Thread(cont_balas);
		hilo_balas.start();
		
		cont_ene = new Controlador_Enemigos(this);
		hilo_enemigos = new Thread(cont_ene);
		hilo_enemigos.start();
		

	}

	public Gui_Juego getGui() {
		return gui;
	}

	
	
	
	public Tanque_Jugador getTanque() {
		return tanque;
	}

	public void agregarEnemigo()
	{
		//hayEnemigo=true;
		
		Random r = new Random();
		int num_random = r.nextInt()%4;
		if (num_random<0) num_random*=-1;
		
		switch(num_random)
		{
			case 0: {EnemigoEnPantalla=new EnemigoBasico(this); break;}
			case 1: {EnemigoEnPantalla=new EnemigoBlindado(this); break;}
			case 2: {EnemigoEnPantalla=new EnemigoDePoder(this); break;}
			case 3: {EnemigoEnPantalla=new EnemigoRapido(this); break;}
			
		}
		
		
		
		Random  rnd = new Random();
		//int posx = (int) (rnd.nextDouble() * 13)*60 ;
		
		boolean agregue=false;
		while (!agregue)
		{
			int posx = (rnd.nextInt()%13)*60;
			if (posx<0) posx*=-1;
			if (cont_ene.se_puede_agregar(posx,EnemigoEnPantalla.getEtiqueta().getHeight() , EnemigoEnPantalla.getEtiqueta().getWidth()))
			{
				System.out.println("agregue");
				agregue=true;
				EnemigoEnPantalla.setX(posx);
				gui.getGj().agregar_enemigo(EnemigoEnPantalla);
				cont_ene.add_Enemigo(EnemigoEnPantalla);
			}
		}	
	}
	
	
	public void quitarEnemigo()
	{
		//hayEnemigo=false;
		//EnemigoEnPantalla.destruirse(this);
		//gui.getGi().getPanel_info().repaint();
		//gui.getGj().getPanel_tanque().repaint();
		//tanque.aumentarPuntaje(EnemigoEnPantalla.recibirDisparo());
		//cont_ene.elim_enemigo(EnemigoEnPantalla);
		//EnemigoEnPantalla=null;
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
	
	
	public void agregar_proyectil(Proyectil p)
	{
		gui.getGj().agregar_proyectil(p);
		this.cont_balas.add_proyectil(p);
	}
	
	public void eliminar_proyectil(Proyectil p)
	{
		cont_balas.remove_proyectil(p);
		gui.getGj().borrar_proyectil(p);
	}
	
	public void eliminar_enemigo(Enemigo e)
	{
		cont_ene.elim_enemigo(e);
		gui.getGj().borrar_enemigo(e);
	}

	public Controlador_Enemigos getCont_ene() {
		return cont_ene;
	}
	
	public void setPuntajeJugador(int pts)
	{
		gui.getGi().setPuntaje(pts);
	}
	
	public void eliminar_obstaculo(Obstaculo o)
	{
		gui.getGj().getPanel_obstaculos().remove(o.getEtiqueta());
		gui.getGj().getPanel_obstaculos().repaint();
		terreno_logico.eliminar_obstaculo(o);
	}
	
	/**Agrega graficamente al obstaculo o
	 * 
	 * @param o
	 */
	public void agregar_obstaculo_graficamente(Obstaculo o)
	{
		getGui().getGj().agregar_obstaculo(o);
	}
}
