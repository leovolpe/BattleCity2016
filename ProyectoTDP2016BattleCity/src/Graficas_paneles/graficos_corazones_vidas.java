package Graficas_paneles;


import javax.swing.ImageIcon;

/**Graficos de los corazones que representan las vidas
 * 
 *
 */
public class graficos_corazones_vidas 
{
	
	private ImageIcon imagen_actual;
	
	public ImageIcon getC1()
	{
		imagen_actual = new ImageIcon(getClass().getResource("/Imagenes/Corazones/c1.png")); 
		return imagen_actual;		
	}
	
	public ImageIcon getC2()
	{
		imagen_actual = new ImageIcon(getClass().getResource("/Imagenes/Corazones/c2.png")); 
		return imagen_actual;		
	}
	
	public ImageIcon getC3()
	{
		imagen_actual = new ImageIcon(getClass().getResource("/Imagenes/Corazones/c3.png")); 
		return imagen_actual;		
	}
	
	public ImageIcon getC4()
	{
		imagen_actual = new ImageIcon(getClass().getResource("/Imagenes/Corazones/c4.png")); 
		return imagen_actual;		
	}

}
