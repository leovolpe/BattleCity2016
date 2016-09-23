package Graficas_Personajes.Enemigos;

import javax.swing.ImageIcon;

import Graficas_Personajes.graficos_entidad;

public class graficos_tanque_blindado extends graficos_entidad 
{
	
	public graficos_tanque_blindado()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/blindado1.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/blindado3.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/blindado2.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBasico/blindado4.png"));	
	}

}
