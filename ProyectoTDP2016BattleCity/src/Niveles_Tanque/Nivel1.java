package Niveles_Tanque;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Proyectil.ProyectilJugador;

/**Nivel 1 del tanque
 * 
 */
public class Nivel1 extends Nivel {

	//resistencia, velocidad de movimiento, velocidad de disparo, disparos simultaneos permitidos
	public Nivel1() 
	{
		super(1, 2, 3, 1);
	}

	@Override
	public void nueva_pos(Tanque_Jugador t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aumentar_nivel(Tanque_Jugador t) 
	{
		t.setNivel2();
	}

	@Override
	public void nuevo_disparo_jugador(Tanque_Jugador t, char d, int x, int ancho, int y, int largo, Juego j) 
	{
		//new ProyectilJugador(this, direccion,this.getX(),this.getEtiqueta().getWidth(),this.getY(),this.getEtiqueta().getHeight(),getJuego(),nivel.getVel_disp());
		new ProyectilJugador(t,d,x,ancho,y,largo,j,getVel_disp());
		
	}
	
	

}
