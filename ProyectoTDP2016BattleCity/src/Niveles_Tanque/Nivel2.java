package Niveles_Tanque;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Proyectil.ProyectilJugador;

/**Nivel dos del tanque
 * 
 *
 */
public class Nivel2 extends Nivel 
{

	//resistencia, velocidad de movimiento, velocidad de disparo, disparos simultaneos permitidos
	public Nivel2(Tanque_Jugador t) 
	{
		super(1, 4, 6, 1);
		nueva_pos(t);
	}

	@Override
	public void nueva_pos(Tanque_Jugador t) 
	{
		int x = t.getX();
		int y = t.getY();
		//busco que la posicionq uede multiplo de la velocidad
		while(x%4!=0)
		{
			x++;
		}
		while((y%4!=0))
		{
			y++;
		}
		
		
		t.setX(x);
		t.setY(y);
		
	}

	@Override
	public void aumentar_nivel(Tanque_Jugador t) 
	{
		t.setNivel3();
	}

	@Override
	public void nuevo_disparo_jugador(Tanque_Jugador t, char d, int x, int ancho, int y, int largo, Juego j) 
	{
		// TODO Auto-generated method stub
		new ProyectilJugador(t,d,x,ancho,y,largo,j,getVel_disp());
	}

}
