package Graficas_Personajes.Enemigos;

import javax.swing.ImageIcon;

import Graficas_Personajes.graficos_entidad;

/**Graficos del tanque basico
 * 
 *
 */
public class graficos_tanque_basico extends graficos_entidad {
	
	public graficos_tanque_basico()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/basico1.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/basico3.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/basico2.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/basico4.png"));	
	}

}
