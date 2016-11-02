package Proyectil;

import javax.swing.JLabel;

import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Obstaculos.Obstaculo;
import Visitor_Proyectiles.Visitor_proyectil_jugador_enemigos;
import Visitor_Proyectiles.Visitor_proyectil_jugador_obstaculo;

/**Proyectil que es lanzado por un jugador
 * 
 *
 */
public class ProyectilJugador extends Proyectil 
{
	private Tanque_Jugador tanque;

	/**
	 * 
	 * @param t	tanque que dispara la bala
	 * @param d	direccion de la bala "n" "s" "i" "d"
	 * @param x	posicion x del tanque
	 * @param ancho	ancho del tanque
	 * @param y	posicion y del tanque
	 * @param largo	largo del tanque
	 * @param j	juego
	 * @param vd 	velocidad del proyectil
	 */
	public ProyectilJugador(Tanque_Jugador t,char d,int x, int ancho, int y, int largo, Juego j, int vd) {
		super(vd,d,j);
		tanque=t;
		etiqueta = new JLabel(gb.getBala_jugador());
		this.getEtiqueta().setSize(10,10);
		
		//calcula donde se ubicara el proyectil en el mapa (va super aca o solo set?)
		super.setPosicion_inicial(d,x,y,ancho,largo);
		//le pide al juego que agregue el proyectil
		getJuego().agregar_proyectil(this);
		
	
	}
	
	

	
	@Override
	public void impactar(Tanque_Jugador t) 
	{
		//vacio, si un tanque toca a su proyectil no se vera afectado
		
		
	}

	@Override
	public void impactar(Obstaculo o) 
	{
		//si se detecto una interseccion entre obstaculo y bala entonces 
		//el obstaculo sera afectado de acuerdo a lo definido en el visitor_proyectil_jugador
		o.aceptar_visitor_proyectil(new Visitor_proyectil_jugador_obstaculo(this));
	}

	@Override
	public void destruirse() 
	{
		//le avisa al tanque que hay un disparo menos en pantalla
		tanque.reducir_disparo();
		//le pide al juego que elimine el proyectil de forma logica y grafica
		getJuego().eliminar_proyectil(this);
	}

	@Override
	public void impactar(Enemigo e) 
	{
		//en caso de impactar un enemigo 
		e.accept(new Visitor_proyectil_jugador_enemigos(this,tanque));
		destruirse();
	}

}
