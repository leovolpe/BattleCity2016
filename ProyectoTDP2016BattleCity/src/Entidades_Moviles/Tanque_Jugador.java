package Entidades_Moviles;

import javax.swing.JLabel;

import Graficas_Personajes.Tanque.graficos_tanque;
import Juego.Juego;
import Niveles_Tanque.*;
import Proyectil.Proyectil;
import Proyectil.ProyectilJugador;

public class Tanque_Jugador extends EntidadMovil {

	private int puntaje;
	@SuppressWarnings("unused")
	private int vidas;
	@SuppressWarnings("unused")
	private boolean inmunidad;
	private int num_niv;
	private Nivel nivel;
	
	
	
	
	public Tanque_Jugador(Juego j) 
	{
		super(1, 1, 1, 1,'n',j); //valores por defecto que no se usaran
		
		
		graficos = new graficos_tanque();
		
		etiqueta = new JLabel(graficos.getArriba());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(540);
		
		
		puntaje=0;
		vidas=4;
		inmunidad=false;
		setNivel1();
	}


	@Override
	public void disparar() 
	{
		
		if (disparos_en_pantalla<nivel.getDisparos_simultaneos())
		{
			disparos_en_pantalla++;
			@SuppressWarnings("unused")
			Proyectil p = new ProyectilJugador(this, direccion,this.getX(),this.getEtiqueta().getWidth(),this.getY(),this.getEtiqueta().getHeight(),getJuego(),nivel.getVel_disp());
		}
		
	}


	

	@Override
	public void destruirse() 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void aumentarNivel()
	{
		if (num_niv==1 || num_niv==2 || num_niv==3)
		{
			reestablecer_posicion();
		}
		
		if (num_niv==1)
			setNivel2();
		else if (num_niv==2)
			setNivel3();
		else if (num_niv == 3)
			setNivel4();
		
		
	}
	
	/**
	 * ubica al tanque en su lugar original
	 */
	private void reestablecer_posicion()
	{
		setX(0);
		setY(540);
		this.getEtiqueta().setIcon(graficos.getArriba());
		direccion='n';
	}
	
	/**
	 * setea nivel 1
	 */
	public void setNivel1()
	{
		num_niv=1;
		nivel = new Nivel1();
	}
	
	/**
	 * setea nivel 2
	 */
	public void setNivel2()
	{
		num_niv=2;
		nivel = new Nivel2();
	}
	
	/**
	 * setea nivel 3
	 */
	public void setNivel3()
	{
		num_niv=3;
		nivel = new Nivel3();
		
	}
	
	/**
	 * setea nivel 4
	 */
	public void setNivel4()
	{
		num_niv=4;
		nivel = new Nivel4();
	}
	
	
	/**
	 * aumenta el puntaje
	 * @param p
	 */
	public void aumentarPuntaje(int p)
	{
		puntaje+=p;
		getJuego().setPuntajeJugador(puntaje);
	}
	
	/**
	 * retorna el puntaje
	 * @return
	 */
	public int getPuntaje()
	{
		
		return puntaje;
	}
	
	
	public void setInmunidad(boolean b)
	{
		
	}
	
	
	/**
	 * redefinido para que la velocidad se obtenga del nivel (patron state)
	 */
	public int getVel_mov()
	{
		return nivel.getVel_mov();
	}
	

}
