package Niveles_Tanque;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Proyectil.ProyectilJugador;

/**Nivel 1 del tanque
 * 
 */
public class Nivel1 extends Nivel {

	//resistencia, velocidad de movimiento, velocidad de disparo, disparos simultaneos permitidos
	public Nivel1(Tanque_Jugador t) 
	{
		super(1, 2, 4, 1);
		nueva_pos(t);
	}

	@Override
	public void nueva_pos(Tanque_Jugador t) 
	{
		t.setX(0);
		t.setY(540);
		
	}

	@Override
	public void aumentar_nivel(Tanque_Jugador t) 
	{
		t.setNivel2();
	}

	@Override
	public void nuevo_disparo_jugador(Tanque_Jugador t, char d, int x, int ancho, int y, int largo, Juego j) 
	{
		new ProyectilJugador(t,d,x,ancho,y,largo,j,getVel_disp());
	}
	
}
