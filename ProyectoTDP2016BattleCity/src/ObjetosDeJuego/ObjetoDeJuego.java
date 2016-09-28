package ObjetosDeJuego;

import javax.swing.JLabel;

import Juego.Juego;

/**Clase que captura todos las caracteristicas de los objetos que participaran
 * en el juego como la posicion y su objeto grafico.
 *
 */
public class ObjetoDeJuego {
	
	protected int x;
	protected int y;
	protected JLabel etiqueta;
	private Juego juego;
	
	public ObjetoDeJuego(Juego j)
	{
		juego=j;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
		etiqueta.setLocation(x,y);
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
		etiqueta.setLocation(x,y);
	}
	
	public JLabel getEtiqueta() {
		return etiqueta;
	}
	
	public void setEtiqueta(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public void mostrar_coordenada()
	{
		System.out.println(" x = "+x+" y = "+y);
	}
	
	protected Juego getJuego() {
		return juego;
	}
	

}
