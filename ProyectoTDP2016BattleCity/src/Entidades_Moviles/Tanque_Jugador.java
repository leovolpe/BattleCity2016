package Entidades_Moviles;

import javax.swing.JLabel;

import Graficas_Personajes.Tanque.graficos_tanque;
import Graficas_Personajes.Tanque.graficos_tanque_inmunidad;
import Juego.Juego;
import Niveles_Tanque.*;
import Proyectil.Proyectil;
import Proyectil.ProyectilJugador;

public class Tanque_Jugador extends EntidadMovil {

	private int puntaje;
	private int puntaje_temporal;
	private int vidas;
	private boolean inmunidad;
	//private int num_niv;
	private Nivel nivel;
	
	
	
	
	public Tanque_Jugador(Juego j) 
	{
		super(1, 1, 1, 1,'n',j); //valores por defecto que no se usaran
		
		
		graficos = new graficos_tanque();
		
		etiqueta = new JLabel(graficos.getArriba());
		etiqueta.setSize(60, 60);
		//this.setX(0);
		//this.setY(540);
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
			disparos_en_pantalla++;
			
			//Proyectil p = new ProyectilJugador(this, direccion,this.getX(),this.getEtiqueta().getWidth(),this.getY(),this.getEtiqueta().getHeight(),getJuego(),nivel.getVel_disp());
			nivel.nuevo_disparo_jugador(this, direccion, this.getX(), this.getEtiqueta().getWidth(), this.getY(), this.getEtiqueta().getHeight(), getJuego());
		}
		
	}

	public void aumentar_vida()
	{
		vidas++;
		getJuego().set_vidas(vidas);
	}

	

	@Override
	public void destruirse() 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void aumentarNivel()
	{
		nivel.aumentar_nivel(this);
	}
	
	/**
	 * ubica al tanque en su lugar original
	 */
	/*
	private void reestablecer_posicion()
	{
		
		setX(0);
		setY(540);
		this.getEtiqueta().setIcon(graficos.getArriba());
		direccion='n';
	}
	*/
	
	/**
	 * setea nivel 1
	 */
	public void setNivel1()
	{
		//num_niv=1;
		nivel = new Nivel1(this);
	}
	
	/**
	 * setea nivel 2
	 */
	public void setNivel2()
	{
		//num_niv=2;
		nivel = new Nivel2(this);
	}
	
	/**
	 * setea nivel 3
	 */
	public void setNivel3()
	{
		//num_niv=3;
		nivel = new Nivel3(this);
		
	}
	
	/**
	 * setea nivel 4
	 */
	public void setNivel4()
	{
		//num_niv=4;
		nivel = new Nivel4(this);
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
			if (vidas==0) getJuego().perder();
			else
			{
				getJuego().set_vidas(vidas);
				setNivel1();
				this.getEtiqueta().setIcon(graficos.getArriba());
				direccion='n';
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
	
	/*
	public void adelante()
	{
		//extendiendo funcionalidad
		super.adelante();
		getJuego().getTerreno_logico().control_tanque_pwp(this);
	}
	
	public void atras()
	{
		super.atras();
		getJuego().getTerreno_logico().control_tanque_pwp(this);
	}
	
	public void izquierda()
	{
		super.izquierda();
		getJuego().getTerreno_logico().control_tanque_pwp(this);
	}
	
	public void derecha()
	{
		super.derecha();
		getJuego().getTerreno_logico().control_tanque_pwp(this);
	}
	*/
	
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
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
		//System.out.println("x= "+this.getX()+" - y= "+this.getY());
	}

}
