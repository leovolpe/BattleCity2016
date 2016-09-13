package Entidades_Moviles;

import java.awt.Point;

import Graficas_Personajes.graficos_entidad;
import ObjetosDeJuego.ObjetoDeJuego;

public abstract class EntidadMovil extends ObjetoDeJuego {
	
	private int resistencia;
	private int vel_mov;
	private int vel_disp;
	private int disparos_simultaneos;
	private int disparos_en_pantalla;
	protected graficos_entidad graficos;
	private char direccion; //'n' 's' 'e' 'o'
	
	public EntidadMovil(int r, int vm, int vd, int ds, int dp, char dir)
	{
		
		resistencia = r;
		vel_mov=vm;
		vel_disp=vd;
		disparos_simultaneos = ds;
		disparos_en_pantalla = dp;
		direccion = dir;
	}
	
	public void adelante()
	{
		if (direccion=='n')
		{
			y = y - vel_mov;
			this.mostrar_coordenada();
			etiqueta.setLocation(x,y);
		}
		else
		{
			etiqueta.setIcon(graficos.getArriba());
			direccion = 'n';
		}
		
		
	}
	
	public void atras()
	{
		
		if (direccion=='s')
		{
			y= y + vel_mov;
			this.mostrar_coordenada();
			etiqueta.setLocation(x,y);
		}
		else
		{
			etiqueta.setIcon(graficos.getAbajo());
			direccion='s';
		}
		
	}
	
	public void izquierda()
	{
		if (direccion=='i')
		{
			x = x - vel_mov;
			this.mostrar_coordenada();
			etiqueta.setLocation(x,y);
		}
		else
		{
			etiqueta.setIcon(graficos.getIzquierda());
			direccion='i';
		}
	}
	
	public void derecha()
	{
		if (direccion=='d')
		{
			x= x + vel_mov;
			this.mostrar_coordenada();
			etiqueta.setLocation(x,y);
		}
		else
		{
			etiqueta.setIcon(graficos.getDerecha());
			direccion='d';
		}
	}
	
	
	
	public abstract void disparar();
	
	public abstract boolean puede_disparar();
	

}
