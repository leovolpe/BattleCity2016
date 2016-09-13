package ObjetosDeJuego;

import javax.swing.JLabel;

public class ObjetoDeJuego {
	
	protected int x;
	protected int y;
	protected JLabel etiqueta;
	
	
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
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
	

}
