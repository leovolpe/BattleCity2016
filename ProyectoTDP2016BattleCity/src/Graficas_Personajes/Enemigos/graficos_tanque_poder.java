package Graficas_Personajes.Enemigos;

import javax.swing.ImageIcon;

import Graficas_Personajes.graficos_entidad;

/**Graficos del tanque de poder
 * 
 *
 */
public class graficos_tanque_poder extends graficos_entidad 
{
	
	public graficos_tanque_poder()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueDePoder/tanqueDePoder1.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueDePoder/tanqueDePoder3.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueDePoder/tanqueDePoder2.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueDePoder/tanqueDePoder4.png"));	
	}

}
