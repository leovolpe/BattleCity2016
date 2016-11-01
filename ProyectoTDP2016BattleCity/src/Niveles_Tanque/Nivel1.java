package Niveles_Tanque;

import Entidades_Moviles.Tanque_Jugador;

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
	
	

}
