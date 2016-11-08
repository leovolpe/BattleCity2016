package logica_pwp_timer;

import Juego.Juego;

public class Temporizador_detener implements Runnable
{
	private Juego juego;
	private int segundos;
	private int cont;
	
	public Temporizador_detener(Juego j, int segs)
	{
		juego=j;
		segundos=segs;
		if(segundos>50) segundos=50;	//le pongo un maximo
		cont=0;
		juego.getCont_ene().set_pausa(true);
	}

	@Override
	public void run() 
	{
		System.out.println("inidico deten");
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
				juego.getCont_ene().set_pausa(false);
		}
	
		System.out.println("fin deten");
		
	}

}
