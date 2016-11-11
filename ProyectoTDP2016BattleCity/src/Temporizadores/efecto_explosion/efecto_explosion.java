package Temporizadores.efecto_explosion;

import Juego.Juego;

public class efecto_explosion 
{
	private Efecto_explosion_grafico g;
	private Juego juego;
	
	
	public efecto_explosion(Juego j)
	{
		juego=j;
		g = new Efecto_explosion_grafico();
	}
	
	public void explotar60x60(int x, int y)
	{
		new Thread(new Efecto_explosion_hilo(x,y,g.getExplosion(),juego)).start();
	}

}
