package Enemigos;

import java.util.Random;

import Entidades_Moviles.EntidadMovil;
import Juego.Juego;
import Proyectil.ProyectilEnemigo;
import Visitor_Proyectiles.Visitor_Proyectil_enemigos;

public abstract class Enemigo extends EntidadMovil{
	
	protected int puntos;		//puntos que entrega
	protected int cant_movs;	//cantidad de movimientos seguidos que realizara
	protected int num_random;	//random que se genera, puede ser 0,1,2,3 y representa una direccion
	
	public Enemigo (int r, int vm, int vd, int ds, int p, Juego j)
	{
		super(r, vm, vd, ds, 's',j);
		cant_movs=0;
		puntos=p;
	}
	
	
	/**
	 * genera un valor aleatorio e intenta mover "cant_movs" veces al enemigo en esa direccion
	 */
	public void mover()
	{
		//random par ver si dispara
		Random ran = new Random();
		int aleatorio = ran.nextInt()%10;
		if (aleatorio<0) aleatorio*=-1;
		if (aleatorio==5) disparar();
		
		//random para ver si dispara
		  
		 
		
		if (cant_movs==0)
		{
			cant_movs=30;
			Random r = new Random();
			num_random = r.nextInt()%4;
			if (num_random<0) num_random*=-1;
		}
		else
			cant_movs--;
		
		switch(num_random)
		{
			case 0 : 
					{
						if (getJuego().getTerreno_logico().Puede_Avanzar(x, y - this.getVel_mov(), etiqueta.getWidth(), etiqueta.getHeight())
								&& !getJuego().getCont_ene().interseccion_entre_enemigos(this,x,y-this.getVel_mov()))
							adelante(); 
						else
							cant_movs=0; //en caso de que no pueda avanzar o de que este por chocar a otro enemigo entonces deja de moverse en esa direccion
							
						break;
					}
			case 1 : {
						if (getJuego().getTerreno_logico().Puede_Avanzar(x, y + this.getVel_mov(), etiqueta.getWidth(), etiqueta.getHeight())
								&& !getJuego().getCont_ene().interseccion_entre_enemigos(this,x,y+this.getVel_mov()))
							atras();
						else
							cant_movs=0;//en caso de que no pueda avanzar o de que este por chocar a otro enemigo entonces deja de moverse en esa direccion
						break;
					}
			case 2 : {
						if (getJuego().getTerreno_logico().Puede_Avanzar(x - this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight())
								&& !getJuego().getCont_ene().interseccion_entre_enemigos(this,x-this.getVel_mov(),y))
							izquierda();
						else
							cant_movs=0;//en caso de que no pueda avanzar o de que este por chocar a otro enemigo entonces deja de moverse en esa direccion
						break;
					}
			case 3 : {
						if (getJuego().getTerreno_logico().Puede_Avanzar(x + this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight())
								&& !getJuego().getCont_ene().interseccion_entre_enemigos(this,x+this.getVel_mov(),y))
							derecha();
						else
							cant_movs=0;//en caso de que no pueda avanzar o de que este por chocar a otro enemigo entonces deja de moverse en esa direccion
						break;
					}
		}
	}
	

	@Override
	public void disparar() 
	{
		/*
		 * if (disparos_en_pantalla<nivel.getDisparos_simultaneos())
		{
			disparos_en_pantalla++;
			
			//Proyectil p = new ProyectilJugador(this, direccion,this.getX(),this.getEtiqueta().getWidth(),this.getY(),this.getEtiqueta().getHeight(),getJuego(),nivel.getVel_disp());
			nivel.nuevo_disparo_jugador(this, direccion, this.getX(), this.getEtiqueta().getWidth(), this.getY(), this.getEtiqueta().getHeight(), getJuego());
		}
		 */
		if (disparos_en_pantalla<disparos_simultaneos)
		{
			disparos_en_pantalla++;
			new ProyectilEnemigo(this, direccion,this.getX(),this.getEtiqueta().getWidth(),this.getY(),this.getEtiqueta().getHeight(),getJuego(),vel_disp);
		}
		System.out.println("bang!");
		
	}
	
	public void destruirse()
	{
		getJuego().eliminar_enemigo(this);
	}

	
	/**
	 * al recibir un disparo se reduce en uno la resistencia
	 * @return
	 */
	public int recibirDisparo()
	{
		resistencia--;
		if (resistencia==0)
			destruirse();
		return puntos;
	}
	
	
	

	public abstract void accept(Visitor_Proyectil_enemigos v);
	

}
