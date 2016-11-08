package Entidades_Moviles;


import Graficas_Personajes.graficos_entidad;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;

/**Representa a las entidades que se mueven por pantalla (tanque y tanques enemigos)
 * 
 *
 */
public abstract class EntidadMovil extends ObjetoDeJuego {
	
	
	protected int resistencia;
	private int vel_mov;
	protected int vel_disp;
	protected int disparos_simultaneos;
	protected int disparos_en_pantalla;
	protected graficos_entidad graficos;
	protected char direccion; //'n' 's' 'e' 'o'
	
	
	public EntidadMovil(int r, int vm, int vd, int ds, char dir, Juego j)
	{
		super(j);
		resistencia = r;
		vel_mov=vm;
		vel_disp=vd;
		disparos_simultaneos = ds;
		disparos_en_pantalla = 0;
		direccion = dir;
	}
	

	
	public void adelante()
	{
		
			if (direccion=='n')
			{
				//le preguna al terreno logico si puede avanzar en esa direccion
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
	}
	
	public void atras()
	{
		
		if (direccion=='s')
		{
			//le preguna al terreno logico si puede avanzar en esa direccion
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
	}
	
	public void izquierda()
	{
		if (direccion=='i')
		{
			//le preguna al terreno logico si puede avanzar en esa direccion
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
	}
	
	
	public void derecha()
	{
		if (direccion=='d')
		{
			//le preguna al terreno logico si puede avanzar en esa direccion
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
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
	
	
	/**
	 * la entidad movil realiza un disparo
	 */
	public abstract void disparar();
	
	
	/**
	 * la entidad movil se destruye
	 */
	public abstract void destruirse();
	
	
	

	
	

}
