package Juego;

import java.util.Random;

import ControladorDeTeclado.manejador_auxiliar_teclado;
import ControladorDeTeclado.manejador_teclado_jugador;
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
 * Clase que inicializa la parte grafica, el tanque, y el terreno logico, y se encarga de comunicar la
 * logica con la grafica
 */
public class Juego 
{
	
	private Gui_Juego gui;					//gui del juego, parte grafica
	private Tanque_Jugador tanque;			//tanque del jugador
	private TerrenoLogico terreno_logico;	//terreno logico que maneja los obstaculos
	
	private Controlador_balas cont_balas;	//controla a los proyectiles
	private Thread hilo_balas;
	
	private Controlador_Enemigos cont_ene;	//controla a los enemigos
	private Thread hilo_enemigos;	
	
	
	//se usa para crear el enemigo, sera borrado mas tarde
	private Enemigo EnemigoEnPantalla;
	
	//manejador de teclado
	private manejador_teclado_jugador teclado;
	
	
	public Juego()
	{
		tanque = new Tanque_Jugador(this);		//creo el tanque
		gui = new Gui_Juego(tanque);		//creo la gui
		gui.setVisible(true);
		
		//POR AHORA TENGO DOS MANEJADORES DE TECLADO QUE LUEGO SERAN UNO
		
		teclado = new manejador_teclado_jugador(tanque);
		gui.agregar_manejador_teclado(teclado);
		
		gui.addKeyListener(new manejador_auxiliar_teclado(this));
		terreno_logico = new TerrenoLogico(this);
		//////////////////////////////////////////////////////
		 
		
		cont_balas = new Controlador_balas(this);
		hilo_balas = new Thread(cont_balas);
		hilo_balas.start();
		
		cont_ene = new Controlador_Enemigos();
		hilo_enemigos = new Thread(cont_ene);
		hilo_enemigos.start();
		
		

	}

	
	public Gui_Juego getGui() 
	{
		return gui;
	}

	
	
	
	public Tanque_Jugador getTanque() 
	{
		return tanque;
	}

	/**Agrega un enemigo
	 * 
	 */
	public void agregarEnemigo()
	{
		
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
	

	public TerrenoLogico getTerreno_logico() 
	{
		return terreno_logico;
	}
	
	
	/**Agrega de forma logica y grafica un proyectil
	 * 
	 * @param p
	 */
	public void agregar_proyectil(Proyectil p)
	{
		gui.getGj().agregar_proyectil(p);
		this.cont_balas.add_proyectil(p);
	}
	
	/**Elimina de forma logica y grafica un proyectil
	 * 
	 * @param p
	 */
	public void eliminar_proyectil(Proyectil p)
	{
		cont_balas.remove_proyectil(p);
		gui.getGj().borrar_proyectil(p);
	}
	
	
	/**Elimina de forma logica y grafica un enemigo
	 * 
	 * @param e
	 */
	public void eliminar_enemigo(Enemigo e)
	{
		cont_ene.elim_enemigo(e);
		gui.getGj().borrar_enemigo(e);
	}

	
	public Controlador_Enemigos getCont_ene() 
	{
		return cont_ene;
	}
	
	/**Setea graficamente el puntaje actual
	 * 
	 * @param pts
	 */
	public void setPuntajeJugador(int pts)
	{
		gui.getGi().setPuntaje(pts);
	}
	
	/**Elimina el obstaculo de forma logica y grafica
	 * 
	 * @param o
	 */
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
