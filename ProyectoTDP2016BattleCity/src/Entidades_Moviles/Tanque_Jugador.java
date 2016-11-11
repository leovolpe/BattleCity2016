package Entidades_Moviles;

import javax.swing.JLabel;

import Graficas_Personajes.Tanque.graficos_tanque;
import Graficas_Personajes.Tanque.graficos_tanque_inmunidad;
import Juego.Juego;
import Niveles_Tanque.*;


public class Tanque_Jugador extends EntidadMovil {

	private int puntaje;
	private int puntaje_temporal;
	private int vidas;
	private boolean inmunidad;
	private Nivel nivel;
	
	
	
	public Tanque_Jugador(Juego j) 
	{
		super(1, 1, 1, 1,'n',j); //valores por defecto que no se usaran
		
		
		graficos = new graficos_tanque();
		
		etiqueta = new JLabel(graficos.getArriba());
		etiqueta.setSize(60, 60);
		setNivel1();
		
		puntaje=0;
		puntaje_temporal=0;
		vidas=4;
		inmunidad=false;
		
	}


	@Override
	public void disparar() 
	{
		if (disparos_en_pantalla<nivel.getDisparos_simultaneos())
		{
			getJuego().getSounds().disparo_t();
			disparos_en_pantalla++;
			nivel.nuevo_disparo_jugador(this, direccion, this.getX(), this.getEtiqueta().getWidth(), this.getY(), this.getEtiqueta().getHeight(), getJuego());
		}
	}

	
	
	public void aumentar_vida()
	{
		vidas++;
		getJuego().set_vidas(vidas);
	}

	
	public void aumentarNivel()
	{
		nivel.aumentar_nivel(this);
		getJuego().getSounds().cambio_nivel();
	}
	
	
	
	/**
	 * setea nivel 1
	 */
	public void setNivel1()
	{
		nivel = new Nivel1(this);
		getJuego().aumentar_nivel_graficamente(1);
	}
	
	
	/**
	 * setea nivel 2
	 */
	public void setNivel2()
	{
		nivel = new Nivel2(this);
		getJuego().aumentar_nivel_graficamente(2);
	}
	
	
	/**
	 * setea nivel 3
	 */
	public void setNivel3()
	{
		nivel = new Nivel3(this);
		getJuego().aumentar_nivel_graficamente(3);
	}
	
	
	/**
	 * setea nivel 4
	 */
	public void setNivel4()
	{
		nivel = new Nivel4(this);
		getJuego().aumentar_nivel_graficamente(4);
	}
	
	
	/**
	 * aumenta el puntaje
	 * @param p
	 */
	public void aumentarPuntaje(int p)
	{
		puntaje+=p;
		puntaje_temporal+=p;
		if (puntaje_temporal>20000)
		{
			this.aumentar_vida();
			puntaje_temporal-=20000;
		}
		getJuego().setPuntajeJugador(puntaje);
	}
	
	
	/**
	 * retorna el puntaje
	 * @return
	 */
	public int getPuntaje()
	{
		return puntaje;
	}
	
	
	public void setInmunidad(boolean b)
	{
		inmunidad=b;
		if (inmunidad)
		{
			graficos = new graficos_tanque_inmunidad();
			switch(direccion)
			{
				case 'n' : {this.getEtiqueta().setIcon(graficos.getArriba()); break;}
				case 's' : {this.getEtiqueta().setIcon(graficos.getAbajo()); break;}
				case 'i' : {this.getEtiqueta().setIcon(graficos.getIzquierda()); break;}
				case 'd' : {this.getEtiqueta().setIcon(graficos.getDerecha()); break;}
			}
		}
		else
		{
			graficos = new graficos_tanque();
			switch(direccion)
			{
				case 'n' : {this.getEtiqueta().setIcon(graficos.getArriba()); break;}
				case 's' : {this.getEtiqueta().setIcon(graficos.getAbajo()); break;}
				case 'i' : {this.getEtiqueta().setIcon(graficos.getIzquierda()); break;}
				case 'd' : {this.getEtiqueta().setIcon(graficos.getDerecha()); break;}
			}
		}
	}
	
	
	
	public void reducir_vida()
	{
		if (!inmunidad)
		{
			vidas--;
			if (vidas==0) 
				{
					getJuego().perder();
				}
			else
			{
				getJuego().efecto_exp_tanque();
				getJuego().set_vidas(vidas);
				setNivel1();
				this.getEtiqueta().setIcon(graficos.getArriba());
				direccion='n';
				getJuego().getSounds().explosion();
			}
		}
	}
	
	
	
	/**
	 * redefinido para que la velocidad se obtenga del nivel (patron state)
	 */
	public int getVel_mov()
	{
		return nivel.getVel_mov();
	}
	
	
	//metodos de movimiento redefinidos
	
	public void adelante()
	{
		
			if (direccion=='n')
			{
				//le preguna al terreno logico si puede avanzar en esa direccion
				if (getJuego().getTerreno_logico().Puede_Avanzar_relajado_para_tanque(x, y - this.getVel_mov(), etiqueta.getWidth(), etiqueta.getHeight()))
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
			getJuego().getTerreno_logico().control_tanque_pwp(this);
	}
	
	
	public void atras()
	{
		
		if (direccion=='s')
		{
			//le preguna al terreno logico si puede avanzar en esa direccion
			if (getJuego().getTerreno_logico().Puede_Avanzar_relajado_para_tanque(x, y + this.getVel_mov(), etiqueta.getWidth(), etiqueta.getHeight()))
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
		getJuego().getTerreno_logico().control_tanque_pwp(this);
	}
	
	
	
	public void izquierda()
	{
		if (direccion=='i')
		{
			//le preguna al terreno logico si puede avanzar en esa direccion
			if (getJuego().getTerreno_logico().Puede_Avanzar_relajado_para_tanque(x - this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight()))
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
		getJuego().getTerreno_logico().control_tanque_pwp(this);
	}
	
	
	public void derecha()
	{
		if (direccion=='d')
		{
			//le preguna al terreno logico si puede avanzar en esa direccion
			if (getJuego().getTerreno_logico().Puede_Avanzar_relajado_para_tanque(x + this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight()))
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
		getJuego().getTerreno_logico().control_tanque_pwp(this);
	}


	@Override
	protected void destruirse() 
	{
		// TODO Auto-generated method stub
		
	}

}
