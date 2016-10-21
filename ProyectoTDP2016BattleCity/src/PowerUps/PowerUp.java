package PowerUps;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;

/**Clase que representa aun powerup el cual al ser tocado realizara cierta accion
 * 
 */
public abstract class PowerUp extends ObjetoDeJuego {
	
protected int puntos;

//ATENCION
//LOS POWERUPS NO ESTAN IMPLEMENTADOS AUN

public PowerUp(int p, Juego j)
{
	super(j);
	puntos=p;
}


/**Metodo que es llamado cuando un tanque "ta" toca al powerup
 * 
 * @param ta
 */
public abstract void contacto(Tanque_Jugador ta);


/**
 * Elimina al powerup
 */
protected abstract void destruirse();

 

	
}
