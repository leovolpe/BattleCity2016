package Graficas_Personajes;

import javax.swing.ImageIcon;

/**Clase que se encarga de brindar imagenes para todas las direcciones de las entidades moviles
 * 
 *
 */
public abstract class graficos_entidad {
	
	protected ImageIcon arriba;
	protected ImageIcon abajo;
	protected ImageIcon izquierda;
	protected ImageIcon derecha;
	
	public ImageIcon getArriba() 
	{
		return arriba;
	}
	
	public ImageIcon getAbajo() 
	{
		return abajo;
	}
	
	public ImageIcon getIzquierda() 
	{
		return izquierda;
	}
	
	public ImageIcon getDerecha() 
	{
		return derecha;
	}
	
	

}
