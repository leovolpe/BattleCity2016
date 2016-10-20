package Graficas_Obstaculos;

import javax.swing.ImageIcon;

/**
 * Clase encargada de crear una imagen de cada obstaculo y brindar metodos para obtenerlas
 *
 */
public class graficos_obstaculo {

	protected ImageIcon ladrillo;
	protected ImageIcon ladrillo_fuego;
	protected ImageIcon acero;
	protected ImageIcon agua;
	protected ImageIcon arbol;
	protected ImageIcon base;

	public graficos_obstaculo()
	{
		ladrillo = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/ladrillo.png"));
		ladrillo_fuego = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/ladrillof.gif"));
		acero = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/acero.png"));
		agua = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/agua.png"));
		arbol = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/arbol.png"));
		base = new ImageIcon(getClass().getResource("/Imagenes/Obstaculo/base.png"));
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

	public ImageIcon getBase() {
		return base;
	}

	public ImageIcon getLadrillo_fuego() {
		return ladrillo_fuego;
	}

	
}
