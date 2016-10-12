package Entidades_Moviles;

import javax.swing.JLabel;

import ControladorDeTeclado.manejador_teclado_jugador;
import Graficas_Personajes.Tanque.graficos_tanque;
import Juego.Juego;
import Niveles_Tanque.*;
import Proyectil.Proyectil;
import Proyectil.ProyectilJugador;

public class Tanque_Jugador extends EntidadMovil {

	private int puntaje;
	private int vidas;
	private boolean inmunidad;
	private int num_niv;
	private Nivel nivel;
	
	
	private manejador_teclado_jugador teclado;
	
	public Tanque_Jugador(Juego j) 
	{
		super(1, 1, 1, 1, 0,'n',j); //valores por defecto que no se usaran
		
		
		graficos = new graficos_tanque();
		
		etiqueta = new JLabel(graficos.getArriba());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(540);
		
		//creo el oyente de teclado para manipular el tanque
		teclado = new manejador_teclado_jugador(this);
		
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
			Proyectil p = new ProyectilJugador(this, direccion,this.getX(),this.getEtiqueta().getWidth(),this.getY(),this.getEtiqueta().getHeight(),getJuego());
		}
		System.out.println("disparos en pantalla = " +disparos_en_pantalla);
		
	}


	@Override
	public boolean puede_disparar() {
		// TODO Auto-generated method stub
		return false;
	}


	/*
	 * Retorna el oyente encargado de detectar las teclas presionadas
	 */
	public manejador_teclado_jugador getTeclado() {
		return teclado;
	}


	
	
	@Override
	public void destruirse() {
		// TODO Auto-generated method stub
		
	}
	
	public void recibirDisparo()
	{
		
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
	
	private void reestablecer_posicion()
	{
		setX(0);
		setY(540);
		this.getEtiqueta().setIcon(graficos.getArriba());
		direccion='n';
	}
	
	public void setNivel1()
	{
		num_niv=1;
		nivel = new Nivel1();
	}
	
	public void setNivel2()
	{
		num_niv=2;
		nivel = new Nivel2();
	}
	
	public void setNivel3()
	{
		num_niv=3;
		nivel = new Nivel3();
		
	}
	
	public void setNivel4()
	{
		num_niv=4;
		nivel = new Nivel4();
	}
	
	public void aumentarPuntaje(int p)
	{
		puntaje+=p;
		getJuego().setPuntajeJugador(puntaje);
	}
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
