package Graficas_Personajes.Enemigos;

import javax.swing.ImageIcon;

import Graficas_Personajes.graficos_entidad;

/**Graficos del tanque rapido
 * 
 *
 */
public class graficos_tanque_rapido extends graficos_entidad {
	
	public graficos_tanque_rapido()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueRapido/rapido1.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueRapido/rapido3.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueRapido/rapido2.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueRapido/rapido4.png"));	
	}

}
