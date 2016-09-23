package Entidades_Moviles;

import javax.swing.JLabel;

import ControladorDeTeclado.manejador_teclado_jugador;
import Graficas_Personajes.graficos_entidad;
import Graficas_Personajes.Tanque.graficos_tanque;

public class Tanque_Jugador extends EntidadMovil {

	private int puntaje;
	private int vidas;
	private boolean inmunidad;
	private int nivel;
	
	
	private manejador_teclado_jugador teclado;
	
	public Tanque_Jugador(int r, int vm, int vd, int ds, int dp) {
		super(r, vm, vd, ds, dp,'n');
		
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
		nivel=1;
	}


	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
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
		
	}
	
	public void setNivel1()
	{
		
	}
	
	public void setNivel2()
	{
		
	}
	
	public void setNivel3()
	{
		
	}
	
	public void setNivel4()
	{
		
	}
	
	public void aumentarPuntaje(int p)
	{
		
	}
	
	public void setInmunidad(boolean b)
	{
		
	}

}
