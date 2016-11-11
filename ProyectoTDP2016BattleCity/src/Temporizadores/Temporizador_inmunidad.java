package Temporizadores;

import Entidades_Moviles.Tanque_Jugador;

public class Temporizador_inmunidad implements Runnable 
{

	private int segundos;
	private int cont;
	private Tanque_Jugador tanque;
	
	public Temporizador_inmunidad(int segs, Tanque_Jugador t)
	{
		tanque=t;
		segundos= segs;
		if(segundos>50) segundos=50;	//le pongo un maximo
		cont=0;
		tanque.setInmunidad(true);
	}
	
	@Override
	public void run() 
	{

		while(segundos!=cont)
		{
			cont++;
			
			
			try {
				Thread.sleep(segundos*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (segundos==cont)
				tanque.setInmunidad(false);
		}
	}
}
