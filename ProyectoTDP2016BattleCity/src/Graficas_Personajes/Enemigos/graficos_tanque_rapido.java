package Graficas_Personajes.Enemigos;

import javax.swing.ImageIcon;

import Graficas_Personajes.graficos_entidad;

public class graficos_tanque_rapido extends graficos_entidad {
	
	public graficos_tanque_rapido()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/rapido1.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/rapido3.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/rapido2.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/rapido4.png"));	
	}

}