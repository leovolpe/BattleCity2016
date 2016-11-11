package Temporizadores.efecto_explosion;

import javax.swing.ImageIcon;

public class Efecto_explosion_grafico 
{
	private static ImageIcon explosion;
	
	public Efecto_explosion_grafico()
	{
		
	}
	
	public ImageIcon getExplosion()
	{
		if (explosion==null)
			explosion = new ImageIcon(getClass().getResource("/Imagenes/efectos/explosion.gif"));
		
		return explosion;
	}
	

}
