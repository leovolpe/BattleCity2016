package Proyectil;

import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Obstaculos.Obstaculo;

/**Proyectil que es lanzado por los enemigos, es el mismo proyectil para todos
 *
 */
public class ProyectilEnemigo extends Proyectil {

	
	//ATENCION
	//Esta clase no esta implementada correctamente aun!
	
	public ProyectilEnemigo(Tanque_Jugador t, Juego j) 
	{
		super(3,'s',j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impactar(Tanque_Jugador t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void impactar(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruirse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void impactar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

}
