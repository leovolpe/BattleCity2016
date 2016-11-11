package PowerUps;

import Entidades_Moviles.Tanque_Jugador;
import Graficas_powerup.graficos_powerup;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;

/**Clase que representa aun powerup el cual al ser tocado realizara cierta accion
 * 
 */
public abstract class PowerUp extends ObjetoDeJuego 
{
	
protected final int puntos=500;
protected graficos_powerup graficos;


protected PowerUp(Juego j)
{
	super(j);
	graficos = new graficos_powerup();
}


/**Metodo que es llamado cuando un tanque "ta" toca al powerup
 * 
 * @param ta
 */
public abstract void contacto(Tanque_Jugador ta);


/**
 * Elimina al powerup
 */
protected void destruirse() 
{
	getJuego().destruir_pwp(this);
	
}
	
}
