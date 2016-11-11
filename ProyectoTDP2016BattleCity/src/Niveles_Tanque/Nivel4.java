package Niveles_Tanque;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Proyectil.ProyectilJugador;
import Proyectil.Proyectil_Jugador_N4;

/**Nivel cuatro del tanque
 *
 */
public class Nivel4 extends Nivel 
{

	//resistencia, velocidad de movimiento, velocidad de disparo, disparos simultaneos permitidos
	public Nivel4(Tanque_Jugador t) 
	{
		super(4, 8, 12, 3);
		nueva_pos(t);
	}

	@Override
	public void nueva_pos(Tanque_Jugador t) 
	{
		int x = t.getX();
		int y = t.getY();
		//busco que la posicionq uede multiplo de la velocidad
		while(x%10!=0)
		{
			x++;
		}
		while((y%10!=0))
		{
			y++;
		}
		
		
		t.setX(x);
		t.setY(y);
		
	}

	@Override
	public void aumentar_nivel(Tanque_Jugador t) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuevo_disparo_jugador(Tanque_Jugador t, char d, int x, int ancho, int y, int largo, Juego j) 
	{
		// TODO Auto-generated method stub
		new Proyectil_Jugador_N4(t,d,x,ancho,y,largo,j,getVel_disp());
		
	}

}
