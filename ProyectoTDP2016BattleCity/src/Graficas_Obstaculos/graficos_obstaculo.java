package Graficas_Obstaculos;

import javax.swing.ImageIcon;

public class graficos_obstaculo {

	protected ImageIcon ladrillo;
	protected ImageIcon acero;
	protected ImageIcon agua;
	protected ImageIcon arbol;

	public graficos_obstaculo()
	{
		ladrillo = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/ladrillo.png"));
		acero = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/acero.png"));
		agua = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/agua.png"));
		arbol = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/arbol.png"));;
	}
	
	public ImageIcon getLadrillo() {
		return ladrillo;
	}
	public ImageIcon getAcero() {
		return acero;
	}
	public ImageIcon getAgua() {
		return agua;
	}
	public ImageIcon getArbol() {
		return arbol;
	}

	
}
