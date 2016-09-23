package Entidades_Moviles;


import Graficas_Personajes.graficos_entidad;
import ObjetosDeJuego.ObjetoDeJuego;
import Obstaculos.Obstaculo;

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
	
	
	public void deshacer_mov(Obstaculo o)
	{
		switch(direccion)
		{
			case 'n':
			{
				y=o.getEtiqueta().getY()+o.getEtiqueta().getHeight();
				//System.out.println(y+" -  "+o.getEtiqueta().getY()+o.getEtiqueta().getHeight());
				etiqueta.setLocation(x,y);
				break;
			}
			case 's':
			{
				y=o.getEtiqueta().getY()-this.getEtiqueta().getHeight();
				//y=o.getEtiqueta().getY()-o.getEtiqueta().getHeight();
				etiqueta.setLocation(x,y);
				break;
			}
			case 'i':
			{
				//x=x+vel_mov;
				x = o.getEtiqueta().getX()+o.getEtiqueta().getWidth();
				etiqueta.setLocation(x,y);
				break;
			}
			case 'd':
			{
				//x=x+vel_mov;
				x = o.getEtiqueta().getX()-this.getEtiqueta().getWidth();
				etiqueta.setLocation(x,y);
				break;
			}
		}
	}
	
	public void adelante()
	{
		if (direccion=='n')
		{
			y = y - vel_mov;
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
			etiqueta.setLocation(x,y);
		}
		else
		{
			etiqueta.setIcon(graficos.getDerecha());
			direccion='d';
		}
		
	}
	
	
	
	public abstract void disparar();
	
	public abstract void destruirse();
	
	public abstract boolean puede_disparar();
	

}
