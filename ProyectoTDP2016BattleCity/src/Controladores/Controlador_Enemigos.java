package Controladores;

import java.util.ArrayList;
import java.util.List;

import Enemigos.Enemigo;

public class Controlador_Enemigos implements Runnable 
{

	private List<Enemigo> lista_enemigos;
	private boolean terminar_hilo;
	
	
	public Controlador_Enemigos()
	{
		lista_enemigos = new ArrayList<Enemigo>();
		terminar_hilo=false;
	}
	
	public void add_Enemigo(Enemigo e)
	{
		lista_enemigos.add(e);
	}
	
	public void add_Enemigo()
	{
		
	}
	
	public void elim_enemigo(Enemigo e)
	{
		lista_enemigos.remove(e);
	}
	
	public void terminar_hilo()
	{
		terminar_hilo=true;
	}
	
	
	private void mover_enemigos()
	{
		for (Enemigo e: lista_enemigos)
			e.mover();
	}
	
	
	@Override
	public void run() 
	{
		while (!terminar_hilo)
		{
			mover_enemigos();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

}
