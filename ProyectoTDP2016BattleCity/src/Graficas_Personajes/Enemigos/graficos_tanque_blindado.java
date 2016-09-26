package Graficas_Personajes.Enemigos;

import javax.swing.ImageIcon;

import Graficas_Personajes.graficos_entidad;

public class graficos_tanque_blindado extends graficos_entidad 
{
	
	public graficos_tanque_blindado()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBlindado/blindado1.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBlindado/blindado3.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBlindado/blindado2.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/TanqueBlindado/blindado4.png"));	
	}
	
}

//arriba = new ImageIcon(getClass().getResource("/Imagenes/Tanque/t_ar.png"));