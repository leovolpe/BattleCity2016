package Temporizadores;

import java.util.ArrayList;
import java.util.List;

import Juego.Juego;
import Obstaculos.Obstaculo;
import Obstaculos.ParedAcero;
import Obstaculos.ParedLadrillo;



public class Temporizador_intercambio_paredes implements Runnable 
{

	private int segundos;
	private int cont;
	private List<Obstaculo> listaObstaculos;
	private Juego juego;
	
	public Temporizador_intercambio_paredes(List<Obstaculo> listaobs, Juego j, int seg)
	{
		segundos=seg;
		if(segundos>50) segundos=50;	//le pongo un maximo
		cont=0;
		juego=j;
		listaObstaculos = listaobs;
		set_paredes();
		
		
	}
	
	private void set_paredes()
	{
		
		List<Obstaculo> eliminables = new ArrayList<Obstaculo>();
		List<Obstaculo> agregables = new ArrayList<Obstaculo>();
		for(int i=0; i<listaObstaculos.size();i++)
		{
			Obstaculo o = listaObstaculos.get(i);
			int x = o.getX();
			int y = o.getY();
			
			
			if ((x==300 && y==480) || (x==360 && y==480) || (x==420 && y==480) || (x==420 && y==540) || (x==300 && y==540))
			{
				eliminables.add(o);
				agregables.add(new ParedAcero(x,y,juego));
				//juego.eliminar_obstaculo(o);
				//Obstaculo obs = new ParedAcero(x,y,juego);
				//listaObstaculos.add(obs);
				//juego.agregar_obstaculo_graficamente(obs);
			}
			
		}
		
		for(int i=0; i<eliminables.size();i++)
		{
			juego.eliminar_obstaculo(eliminables.get(i));
		}
		
		for(int i=0; i<agregables.size();i++)
		{
			Obstaculo o = agregables.get(i);
			listaObstaculos.add(o);
			juego.agregar_obstaculo_graficamente(o);
		}
		
	}
	
	private void reset_paredes()
	{
		List<Obstaculo> eliminables = new ArrayList<Obstaculo>();
		List<Obstaculo> agregables = new ArrayList<Obstaculo>();
		for(int i=0; i<listaObstaculos.size();i++)
		{
			Obstaculo o = listaObstaculos.get(i);
			int x = o.getX();
			int y = o.getY();
			
			
			if ((x==300 && y==480) || (x==360 && y==480) || (x==420 && y==480) || (x==420 && y==540) || (x==300 && y==540))
			{
				eliminables.add(o);
				agregables.add(new ParedLadrillo(x,y,juego));
				
			}
			
		}
		
		for(int i=0; i<eliminables.size();i++)
		{
			juego.eliminar_obstaculo(eliminables.get(i));
		}
		
		for(int i=0; i<agregables.size();i++)
		{
			Obstaculo o = agregables.get(i);
			listaObstaculos.add(o);
			juego.agregar_obstaculo_graficamente(o);
		}
		
	}
	
	@Override
	public void run() 
	{
		System.out.println("inidico paredes");
		while (segundos!=cont)
		{
			cont++;
			try {
				Thread.sleep(segundos*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(segundos==cont)
				reset_paredes();
		}
	
		System.out.println("fin paredes");
		 
		
		
	}

}
