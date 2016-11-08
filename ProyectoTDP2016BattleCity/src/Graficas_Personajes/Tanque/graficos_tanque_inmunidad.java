package Graficas_Personajes.Tanque;

import javax.swing.ImageIcon;

public class graficos_tanque_inmunidad extends graficos_tanque
{
	
	public graficos_tanque_inmunidad()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Tanque_inmunidad/t_ar.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Tanque_inmunidad/t_ab.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Tanque_inmunidad/t_d.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Tanque_inmunidad/t_i.png"));	
	}

}
