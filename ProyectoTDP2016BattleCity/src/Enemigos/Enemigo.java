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
	
	public Enemigo (int r, int vm, int vd, int ds, int dp, int p, Juego j)
	{
		super(r, vm, vd, ds, dp, 's',j);
		puntos=p;
		
	}
	
	
	public void mover()
	{
		Random r = new Random();
		int n = r.nextInt()%8;
		if (n<0) n*=-1;
		System.out.println("randommmmmm................................."+n);
		switch(n)
		{
			case 0 : {adelante(); break;}
			case 1 : {atras(); break;}
			case 2 : {atras(); break;}
			case 3 : {atras(); break;}
			case 4 : {atras(); break;}
			case 5 : {atras(); break;}
			case 6 : {izquierda(); break;}
			case 7 : {derecha(); break;}
		}
	}
	

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
	public void destruirse()
	{
		
	}

	public void destruirse(Juego j) 
	{	
		j.getGui().getGj().getPanel_tanque().remove(this.getEtiqueta());
		
	}

	@Override
	public boolean puede_disparar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int recibirDisparo()
	{
		return puntos;
	}

	

}
