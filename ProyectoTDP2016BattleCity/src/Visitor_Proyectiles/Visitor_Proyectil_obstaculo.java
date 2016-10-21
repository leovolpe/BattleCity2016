package Visitor_Proyectiles;

import Obstaculos.*;
import Proyectil.Proyectil;

/**Visitor para que los proyectiles puedan afectar a los obstaculos
 * 
 *
 */
public abstract class Visitor_Proyectil_obstaculo 
{
	protected Proyectil proy;
	
	/**Visita de un proyectil con el obstaculo agua
	 * 
	 * @param a	agua
	 */
	public abstract void visitar(Agua a);
	
	/**Visita de un proyectil con el obstaculo arbol
	 * 
	 * @param a arbol
	 */
	public abstract void visitar(Arbol a);
	
	/**Visita de un proyectil con el obstaculo Base
	 * 
	 * @param b base
	 */
	public abstract void visitar(Base b);
	
	/**Visita de un proyectil con el obstaculo pared de acero
	 * 
	 * @param p pared de acero
	 */
	public abstract void visitar(ParedAcero p);
	
	/**Visita de un proyectil con el obstaculo pared de ladrillo
	 * 
	 * @param p pared de ladrillo
	 */
	public abstract void visitar(ParedLadrillo p);

}
