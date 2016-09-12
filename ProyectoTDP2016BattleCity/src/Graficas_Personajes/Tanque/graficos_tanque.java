package Graficas_Personajes.Tanque;

import javax.swing.ImageIcon;

import Graficas_Personajes.graficos_entidad;

public class graficos_tanque extends graficos_entidad {
	
	public graficos_tanque()
	{
		arriba = new ImageIcon(getClass().getResource("/Imagenes/Tanque/t_ar.png"));
		abajo = new ImageIcon(getClass().getResource("/Imagenes/Tanque/t_ab.png"));
		derecha = new ImageIcon(getClass().getResource("/Imagenes/Tanque/t_d.png"));
		izquierda = new ImageIcon(getClass().getResource("/Imagenes/Tanque/t_i.png"));	
	}

}
