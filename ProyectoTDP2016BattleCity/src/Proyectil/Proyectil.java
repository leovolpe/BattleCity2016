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
