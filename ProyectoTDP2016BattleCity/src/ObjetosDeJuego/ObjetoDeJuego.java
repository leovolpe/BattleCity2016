package ObjetosDeJuego;

import javax.swing.JLabel;

import Juego.Juego;

/**Clase que captura todos las caracteristicas de los objetos que participaran
 * en el juego como la posicion y su objeto grafico.
 *
 */
public class ObjetoDeJuego {
	
	protected int x;		//posicion x
	protected int y;		//posicion y
	protected JLabel etiqueta;	//etiqueta grafica
	private Juego juego;
	
	public ObjetoDeJuego(Juego j)
	{
		juego=j;
	}
	
	/**
	 * 
	 * @return posicion x
	 */
	public int getX() 
	{
		return x;
	}
	
	/**
	 * 
	 * @param x posicion x que se desea setear
	 */
	public void setX(int x) 
	{
		this.x = x;
		etiqueta.setLocation(x,y);
	}
	
	/**
	 * 
	 * @return posicion y
	 */
	public int getY() 
	{
		return y;
	}
	
	/**
	 * 
	 * @param y posicion y que se desea setear
	 */
	public void setY(int y) 
	{
		this.y = y;
		etiqueta.setLocation(x,y);
	}
	
	/**
	 * 
	 * @return etiqueta del objeto de juego
	 */
	public JLabel getEtiqueta() 
	{
		return etiqueta;
	}
	

	
	protected Juego getJuego() 
	{
		return juego;
	}
	

}
