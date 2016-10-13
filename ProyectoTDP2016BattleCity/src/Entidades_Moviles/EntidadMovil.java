package Entidades_Moviles;


import Graficas_Personajes.graficos_entidad;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;

public abstract class EntidadMovil extends ObjetoDeJuego {
	
	
	private int resistencia;
	private int vel_mov;
	private int vel_disp;
	private int disparos_simultaneos;
	protected int disparos_en_pantalla;
	protected graficos_entidad graficos;
	protected char direccion; //'n' 's' 'e' 'o'
	
	
	public EntidadMovil(int r, int vm, int vd, int ds, int dp, char dir, Juego j)
	{
		super(j);
		resistencia = r;
		vel_mov=vm;
		vel_disp=vd;
		disparos_simultaneos = ds;
		disparos_en_pantalla = dp;
		direccion = dir;
	}
	
	/*
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
	*/
	
	public void adelante()
	{
		
			if (direccion=='n')
			{
				if (getJuego().getTerreno_logico().Puede_Avanzar(x, y - this.getVel_mov(), etiqueta.getWidth(), etiqueta.getHeight()))
				{
					y = y - getVel_mov();
					etiqueta.setLocation(x,y);
				}
			}
			else
			{
				etiqueta.setIcon(graficos.getArriba());
				direccion = 'n';
			}
		
			//this.mostrar_coordenada();
		
	}
	
	public void atras()
	{
		
		if (direccion=='s')
		{
			if (getJuego().getTerreno_logico().Puede_Avanzar(x, y + this.getVel_mov(), etiqueta.getWidth(), etiqueta.getHeight()))
			{
				y= y + getVel_mov();
				etiqueta.setLocation(x,y);
			}
		}
		else
		{
			etiqueta.setIcon(graficos.getAbajo());
			direccion='s';
		}
		//this.mostrar_coordenada();
	}
	
	public void izquierda()
	{
		if (direccion=='i')
		{
			if (getJuego().getTerreno_logico().Puede_Avanzar(x - this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight()))
			{
				x = x - getVel_mov();
				etiqueta.setLocation(x,y);
			}
		}
		else
		{
			etiqueta.setIcon(graficos.getIzquierda());
			direccion='i';
		}
		//this.mostrar_coordenada();
	}
	
	public void derecha()
	{
		if (direccion=='d')
		{
			if (getJuego().getTerreno_logico().Puede_Avanzar(x + this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight()))
			{
				x= x + getVel_mov();
				etiqueta.setLocation(x,y);
			}
		}
		else
		{
			etiqueta.setIcon(graficos.getDerecha());
			direccion='d';
		}
		//this.mostrar_coordenada();
	}
	
	
	
	public int getVel_mov()
	{
		return vel_mov;
	}
	
	public void reducir_disparo()
	{
			disparos_en_pantalla--;
			if (disparos_en_pantalla<0)
				disparos_en_pantalla=0;
	}
	
	
	public abstract void disparar();
	
	public abstract void destruirse();
	
	public abstract boolean puede_disparar();

	
	

}
