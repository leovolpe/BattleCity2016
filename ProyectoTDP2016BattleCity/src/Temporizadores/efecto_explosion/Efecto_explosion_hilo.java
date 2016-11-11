package Temporizadores.efecto_explosion;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Juego;

public class Efecto_explosion_hilo implements Runnable 
{
	
	private JLabel l;
	private Juego juego;
	private int segundos;
	private int cont;
	
	
	public Efecto_explosion_hilo(int x, int y, ImageIcon i, Juego j)
	{
		juego=j;
		segundos = 4;
		cont=0;
		l = new JLabel(i);
		l.setBounds(x, y, 60, 60);
		juego.getGui().getGj().addexplosion60x60(l);
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
				juego.getGui().getGj().removeexplosion60x60(l);
		}
	}

}
