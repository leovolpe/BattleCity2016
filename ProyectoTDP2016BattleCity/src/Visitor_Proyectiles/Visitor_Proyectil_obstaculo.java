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
	
	public abstract void visitar(Agua a);
	public abstract void visitar(Arbol a);
	public abstract void visitar(Base b);
	public abstract void visitar(ParedAcero p);
	public abstract void visitar(ParedLadrillo p);

}
