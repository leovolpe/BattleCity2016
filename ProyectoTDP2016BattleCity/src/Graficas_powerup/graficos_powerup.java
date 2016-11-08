package Graficas_powerup;

import javax.swing.ImageIcon;

public class graficos_powerup 
{
	protected ImageIcon	granada;
	protected ImageIcon	casco;
	protected ImageIcon	pala;
	protected ImageIcon	estrella;
	protected ImageIcon	tanque;
	protected ImageIcon	timer;
	
	public graficos_powerup()
	{
		granada = new ImageIcon(getClass().getResource("/Imagenes/Powerups/granada.png"));
		casco = new ImageIcon(getClass().getResource("/Imagenes/Powerups/casco.png"));
		pala = new ImageIcon(getClass().getResource("/Imagenes/Powerups/pala.png"));
		estrella = new ImageIcon(getClass().getResource("/Imagenes/Powerups/star.png"));
		tanque = new ImageIcon(getClass().getResource("/Imagenes/Powerups/tank.png"));
		timer = new ImageIcon(getClass().getResource("/Imagenes/Powerups/timer.png"));
	}

	public ImageIcon getGranada() {
		return granada;
	}

	public ImageIcon getCasco() {
		return casco;
	}

	public ImageIcon getPala() {
		return pala;
	}

	public ImageIcon getEstrella() {
		return estrella;
	}

	public ImageIcon getTanque() {
		return tanque;
	}

	public ImageIcon getTimer() {
		return timer;
	}

}
