package Juego;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.Random;

import Control_Teclado.ManejadorDeTeclas;

import Controladores.Controlador_Enemigos;
import Controladores.Controlador_balas;
import Enemigos.*;
import Entidades_Moviles.Tanque_Jugador;
import Gui.Gui_Juego;
import Gui.Gui_informacionInicialFinal;
import Inteligencia_general_enemigos.Inteligencia_juego;
import Obstaculos.Obstaculo;

import PowerUps.*;
import Proyectil.Proyectil;
import Temporizadores.efecto_explosion.efecto_explosion;
import Terreno.TerrenoLogico;


/*
 * Clase que inicializa la parte grafica, el tanque, y el terreno logico, y se encarga de comunicar la
 * logica con la grafica
 */
public class Juego 
{
	private Gui_informacionInicialFinal guippal;
	private Gui_Juego gui;					//gui del juego, parte grafica
	private Tanque_Jugador tanque;			//tanque del jugador
	private TerrenoLogico terreno_logico;	//terreno logico que maneja los obstaculos
	
	private Controlador_balas cont_balas;	//controla a los proyectiles
	private Thread hilo_balas;
	
	private Controlador_Enemigos cont_ene;	//controla a los enemigos
	private Thread hilo_enemigos;
	
	private Inteligencia_juego intjuego;
	private Thread hilo_int;
	
	private efecto_explosion exp;
	
	
	//se usa para crear el enemigo, sera borrado mas tarde
	private Enemigo EnemigoEnPantalla;
	
	
	
	private final int cant_ene_para_ganar = 10;
	
	private ManejadorDeTeclas manejador_tec;
	
	
	public Juego()
	{
		guippal = new Gui_informacionInicialFinal(this);
		guippal.setInicio();
		guippal.setVisible(true);
		
	}
	
	public void iniciar_juego(int n)
	{
		exp = new efecto_explosion(this);
		guippal.setVisible(false);
		
		
		gui = new Gui_Juego(cant_ene_para_ganar);		//creo la gui
		tanque = new Tanque_Jugador(this);		//creo el tanque
		gui.add_Tanque(tanque);
		gui.setVisible(true);
		
		
		//POR AHORA TENGO DOS MANEJADORES DE TECLADO QUE LUEGO SERAN UNO
		
		//teclado = new manejador_teclado_jugador(tanque);
		//gui.agregar_manejador_teclado(teclado);
		
		manejador_tec = new ManejadorDeTeclas(tanque);
		gui.agregar_manejador_teclado(manejador_tec);
		
		
		
		terreno_logico = new TerrenoLogico(this,n);
		//////////////////////////////////////////////////////
		 
		
		cont_balas = new Controlador_balas(this);
		hilo_balas = new Thread(cont_balas);
		hilo_balas.start();
		
		cont_ene = new Controlador_Enemigos(this);
		hilo_enemigos = new Thread(cont_ene);
		hilo_enemigos.start();
		
		intjuego = new Inteligencia_juego(this,cant_ene_para_ganar);
		hilo_int = new Thread(intjuego);
		hilo_int.start();
	}
	
	public void perder()
	{
		
		cont_ene.terminar_hilo();
		intjuego.fin_hilo();
		cont_balas.terminar_hilo();
		gui.setVisible(false);
		
		
		guippal.derrota(tanque.getPuntaje());
		guippal.setVisible(true);
		
	}
	
	public void ganar()
	{
		
		
		
		cont_ene.terminar_hilo();
		intjuego.fin_hilo();
		cont_balas.terminar_hilo();
		gui.setVisible(false);
		
		guippal.victoria(tanque.getPuntaje());
		guippal.setVisible(true);
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
			if (cont_ene.se_puede_agregar(posx,0,EnemigoEnPantalla.getEtiqueta().getHeight() , EnemigoEnPantalla.getEtiqueta().getWidth()))
			{
				//veo si justo esta el tanque en ese lugar
				if (!intersecta_con_Tanque(posx,0,EnemigoEnPantalla.getEtiqueta().getHeight() , EnemigoEnPantalla.getEtiqueta().getWidth()))
				{
					agregue=true;
					EnemigoEnPantalla.setX(posx);
					gui.getGj().agregar_enemigo(EnemigoEnPantalla);
					cont_ene.add_Enemigo(EnemigoEnPantalla);
				}
			}
		}	
	}
	
	
	
	private boolean intersecta_con_Tanque(int x,int y, int h, int w) 
	{
		boolean inter=false;
		
		Rectangle r = new Rectangle(x,y,h,w);
		Area ae = new Area(r.getBounds());
		Area at = new Area(getTanque().getEtiqueta().getBounds());
		if (ae.intersects(at.getBounds2D()))
			inter=true;
		
		return inter;
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
		intjuego.enemigo_muerto();
		gui.getGi().setRestantes(intjuego.get_cant_p_ganar()-intjuego.get_ene_muertos());
		cont_ene.elim_enemigo(e);
		gui.getGj().borrar_enemigo(e);
		exp.explotar60x60(e.getX(), e.getY());
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
		exp.explotar60x60(o.getX(), o.getY());
	}
	
	
	/**Agrega graficamente al obstaculo o
	 * 
	 * @param o
	 */
	public void agregar_obstaculo_graficamente(Obstaculo o)
	{
		getGui().getGj().agregar_obstaculo(o);
	}
	
	public void agregar_powerup_graficamente(PowerUp p)
	{
		getGui().getGj().agregar_pwp(p);
	}


	public void agregar_pwp() 
	{
		
		PowerUp p = new Timer(this,0,0);
		terreno_logico.addPwp(p);
		//aca va a ir la creacion y se agregara en sus lugares correspondientes
		
	}


	public void destruir_pwp(PowerUp p) 
	{
		terreno_logico.removePwp(p);
		getGui().getGj().borrar_pwp(p);
		
	}


	public void set_vidas(int vidas) 
	{
		gui.getGi().setVidas(vidas);
	}


	public void agregar_enemigo(Enemigo e) 
	{
		gui.getGj().agregar_enemigo(e);
		cont_ene.add_Enemigo(e);
		
	}


	public Inteligencia_juego getIntjuego() {
		return intjuego;
	}
	
	public void efecto_exp_tanque()
	{
		exp.explotar60x60(tanque.getX(), tanque.getY());
	}
	
	public void aumentar_nivel_graficamente(int n)
	{
		gui.getGi().setNivel(n);
	}
	
}
