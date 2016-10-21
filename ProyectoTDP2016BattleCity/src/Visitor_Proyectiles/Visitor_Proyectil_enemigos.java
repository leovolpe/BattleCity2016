package Visitor_Proyectiles;

import Enemigos.*;
import Proyectil.Proyectil;

/**Se encarga de manejar los contactos entre las balas y los distintos tipos de enemigos
 * 
 *
 */
public abstract class Visitor_Proyectil_enemigos 
{
	protected Proyectil proy;
	
	/**Visita de un proyectil con un enemigo basico
	 * 
	 * @param e enemigo basico
	 */
	public abstract void visitar(EnemigoBasico e);
	
	/**Visita de un proyectil con un enemigo blindado
	 * 
	 * @param e enemigo blindado
	 */
	public abstract void visitar(EnemigoBlindado e);
	
	/**Visita de un proyectil con un enemigo de poder
	 * 
	 * @param e enemigo de poder
	 */
	public abstract void visitar(EnemigoDePoder e);
	
	/**Visita de un proyectil con un enemigo rapido
	 * 
	 * @param e enemigo rapido
	 */
	public abstract void visitar(EnemigoRapido e);
	
	

}
