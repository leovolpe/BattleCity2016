package Temporizadores;

import Juego.Juego;
import PowerUps.PowerUp;

public class Temporizador_pwp implements Runnable 
{
	private Juego juego;
	private PowerUp pwp;
	private int segundos;
	private int cont;

	public Temporizador_pwp(Juego j,PowerUp p, int segs)
	{
		juego=j;
		segundos=segs;
		if(segundos>50) segundos=50;	//le pongo un maximo
		cont=0;
		pwp=p;
	}
	
	@Override
	public void run() 
	{
		System.out.println("inicio pwp");
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
			{
				juego.destruir_pwp(pwp);
			}
		
		}
		System.out.println("fin pwp");
		// TODO Auto-generated method stub
		
	}

}
