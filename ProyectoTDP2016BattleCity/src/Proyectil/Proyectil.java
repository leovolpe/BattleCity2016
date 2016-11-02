package Proyectil;

import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;
import Obstaculos.Obstaculo;
import graficos_balas.graficos_balas;

/**Clase que representa un proyectil que se mueve por pantalla y puede impactar a otras entidades
 * 
 *
 */
public abstract class Proyectil extends ObjetoDeJuego {
	
	protected int velocidad;
	protected char direccion;
	protected graficos_balas gb;
	
	/**El proyectil posee cuatro direcciones posibles y sera correspondiente a la direccion del tanque cuando la dispare
	 * 
	 * @param vel	velocidad del proyectil
	 * @param d		direccion "n" "s" "i" "d"
	 * @param j		Juego
	 */
	public Proyectil(int vel, char d, Juego j)
	{
		super(j);
		direccion=d;
		velocidad=vel;
		gb = new graficos_balas();
	}
	
	
	/**De acuerdo a la direccion, el proyectil se mueve
	 * 
	 */
	public void mover()
	{
		switch(direccion)
		{
			case 'n' :
			{
				this.setY(this.getY()-velocidad);
				break;
			}
			case 's' :
			{
				this.setY(this.getY()+velocidad);
				break;
			}
			case 'i' :
			{
				this.setX(this.getX()-velocidad);
				break;
			}
			case 'd' :
			{
				this.setX(this.getX()+velocidad);
				break;
			}
		}
	}
	
	/**Basado en las coordenadas y el tamaño del tanque, ubica el proyectil en el mapa
	 * 
	 * @param d	direccion
	 * @param x	posicion x del tanque
	 * @param y	posicion y del tanque
	 * @param a	ancho del tanque
	 * @param l	largo del tanque
	 */
	protected void setPosicion_inicial(char d, int x, int y, int a, int l)
	{
		switch(d)
		{
			case'n' :
			{
				this.setX(x+(a/2)-5);
				this.setY(y-10);
				break;
			}
			case 's' :
			{
				this.setX(x+(a/2)-5);
				this.setY(y+60);
				break;
			}
			case 'd':
			{
				this.setX(x+60);
				this.setY(y+(l/2)-5);
				break;
			}
			case 'i':
			{
				this.setX(x-10);
				this.setY(y+(l/2)-5);
				break;
			}
		}
	}
	
	
	
	/**
	 * Implementa lo que sucede cuando una bala impacta al tanque jugador
	 * @param t
	 */
	public abstract void impactar(Tanque_Jugador t);
	
	/**Implementa lo que sucede cuando una bala impacta a un enemigo
	 * 
	 * @param e
	 */
	public abstract void impactar(Enemigo  e);
	
	/**Implementa lo que sucede cuando una bala impacta a un obstaculo
	 * 
	 * @param o
	 */
	public abstract void impactar(Obstaculo o);
	
	/**
	 * Destruye la bala
	 */
	public abstract void destruirse();
	

}
