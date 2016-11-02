package Niveles_Tanque;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Proyectil.ProyectilJugador;

/**Nivel tres del tanque
 * 
 */
public class Nivel3 extends Nivel 
{

	//resistencia, velocidad de movimiento, velocidad de disparo, disparos simultaneos permitidos
	public Nivel3(Tanque_Jugador t) 
	{
		super(2, 6, 7, 2);
		nueva_pos(t);
		
	}

	@Override
	public void nueva_pos(Tanque_Jugador t) 
	{
		int x = t.getX();
		int y = t.getY();
		//busco que la posicionq uede multiplo de la velocidad
		while(x%6!=0)
		{
			x++;
		}
		while((y%6!=0))
		{
			y++;
		}
		
		
		t.setX(x);
		t.setY(y);
		
	}

	@Override
	public void aumentar_nivel(Tanque_Jugador t) 
	{
		t.setNivel4();
	}

	@Override
	public void nuevo_disparo_jugador(Tanque_Jugador t, char d, int x, int ancho, int y, int largo, Juego j) 
	{
		// TODO Auto-generated method stub
		new ProyectilJugador(t,d,x,ancho,y,largo,j,getVel_disp());
		
	}

}
