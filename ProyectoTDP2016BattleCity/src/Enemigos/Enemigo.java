package Enemigos;

import java.util.Random;

import javax.swing.JLabel;

import Entidades_Moviles.EntidadMovil;
import Graficas_Personajes.Enemigos.graficos_tanque_basico;
import Graficas_Personajes.Tanque.graficos_tanque;
import Gui.Gui_Juego;
import Juego.Juego;

public class Enemigo extends EntidadMovil{
	
	protected int puntos;
	protected int cant_movs;
	protected int num_random;
	
	public Enemigo (int r, int vm, int vd, int ds, int dp, int p, Juego j)
	{
		super(r, vm, vd, ds, dp, 's',j);
		cant_movs=0;
		puntos=p;
		
	}
	
	
	public void mover()
	{
		
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
							cant_movs=0;
							
						break;
					}
			case 1 : {
						if (getJuego().getTerreno_logico().Puede_Avanzar(x, y + this.getVel_mov(), etiqueta.getWidth(), etiqueta.getHeight())
								&& !getJuego().getCont_ene().interseccion_entre_enemigos(this,x,y+this.getVel_mov()))
							atras();
						else
							cant_movs=0;
						break;
					}
			case 2 : {
						if (getJuego().getTerreno_logico().Puede_Avanzar(x - this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight())
								&& !getJuego().getCont_ene().interseccion_entre_enemigos(this,x-this.getVel_mov(),y))
							izquierda();
						else
							cant_movs=0;
						break;
					}
			case 3 : {
						if (getJuego().getTerreno_logico().Puede_Avanzar(x + this.getVel_mov(), y, etiqueta.getWidth(), etiqueta.getHeight())
								&& !getJuego().getCont_ene().interseccion_entre_enemigos(this,x+this.getVel_mov(),y))
							derecha();
						else
							cant_movs=0;
						break;
					}
		}
	}
	

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
	public void destruirse()
	{
		getJuego().eliminar_enemigo(this);
	}

	public void destruirse(Juego j) 
	{	
		//j.getGui().getGj().getPanel_tanque().remove(this.getEtiqueta());
		
	}

	@Override
	public boolean puede_disparar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int recibirDisparo()
	{
		destruirse();
		return puntos;
	}

	

}
