package Controladores;

import java.util.ArrayList;
import java.util.List;

import Proyectil.Proyectil;

public class Controlador_balas implements Runnable 
{
	
	private List<Proyectil> balas;
	
	public Controlador_balas()
	{
		balas = new ArrayList<Proyectil>();
	}
	
	public void add_proyectil(Proyectil p)
	{
		balas.add(p);
	}

	private synchronized void mover_balas() 
	{
		for(Proyectil p: balas)
		{
			p.mover();
		}
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			mover_balas();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("golaaa");
		}
	}

	

}
