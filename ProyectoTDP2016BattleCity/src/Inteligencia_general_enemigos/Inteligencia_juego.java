package Inteligencia_general_enemigos;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.Random;

import Enemigos.*;
import Juego.Juego;
import PowerUps.*;
import Temporizadores.Temporizador_pwp;

public class Inteligencia_juego implements Runnable 
{
	private boolean pausa;
	private int enemigos_muertos;
	private final int cant_maxima_ene = 4;
	private final int cant_minima_ene = 2;
	private int cant_ene;
	private Juego juego;
	private Random r;
	private boolean fin_hilo;
	private int cant_para_ganar;
	
	public Inteligencia_juego(Juego j, int cant_ene_para_ganar)
	{
		juego=j;
		cant_para_ganar = cant_ene_para_ganar;
		pausa=false;
		enemigos_muertos=0;
		cant_ene=0;
		fin_hilo=false;
		
		r = new Random();
	}
	
	
	public void setpausa(boolean b)
	{
		pausa=b;
	}
	
	
	private int num_aleatorio04()
	{
		int n = r.nextInt()%4;
		if (n<0) n*=-1;
		return n;
	}
	
	
	public void enemigo_muerto()
	{
		enemigos_muertos++;
		if(enemigos_muertos==cant_para_ganar)
		{
			juego.ganar();
		}
		else
		{
			if (enemigos_muertos%4==0)
				agregar_powerup();
				
			cant_ene--;
		}
	}
	
	
	public void agregar()
	{
		if (cant_ene<cant_minima_ene)//se asegura que hay dos por pantalla
		{
				int n = num_aleatorio04();
				generar_ene_aleatorio(n);
		}
		else
		{
			if (cant_ene<cant_maxima_ene)
			{
				int num = r.nextInt()%4;
				if (num==2)
				{
					int n = num_aleatorio04();
					generar_ene_aleatorio(n);
				}
			}
		}
		
	}
	
	
	private void agregar_powerup()
	{
		
			int n = r.nextInt()%9;
			if (n<0) n*=-1;
			PowerUp p = null;
			switch(n)
			{
				case 0 : {p = new Casco(juego,0,0); break;}
				case 1 : {p = new Estrella(juego,0,0); break;}
				case 2 : {p = new Granada(juego,0,0); break;}
				case 3 : {p = new Pala(juego,0,0); break;}
				case 4 : {p = new Tanque(juego,0,0); break;}
				case 5 : {p = new Timer(juego,0,0); break;}
				case 6 : {p = new Estrella(juego,0,0); break;}
				case 7 : {p = new Estrella(juego,0,0); break;}
				case 8 : {p = new Estrella(juego,0,0); break;}
			}
			buscar_posicion_pwp(p);
			new Thread(new Temporizador_pwp(juego,p,10)).start();
			juego.getTerreno_logico().addPwp(p);
	}
	
	
	private void buscar_posicion_pwp(PowerUp p) 
	{
		//posiciones posibles (0,0)	(360,0) (720,0) // (0,240) (360,240) (720,240) // (0,360)	(360,360) (720,360)
		int n = r.nextInt()%9;
		if(n<0) n*=-1;
		
		switch(n)
		{
			case 0 : {p.setX(0); p.setY(0); break;}
			case 1 : {p.setX(360); p.setY(0); break;}
			case 2 : {p.setX(720); p.setY(0); break;}
			case 3 : {p.setX(0); p.setY(240); break;}
			case 4 : {p.setX(360); p.setY(240); break;}
			case 5 : {p.setX(720); p.setY(240); break;}
			case 6 : {p.setX(0); p.setY(360); break;}
			case 7 : {p.setX(360); p.setY(360); break;}
			case 8 : {p.setX(720); p.setY(360); break;}
		}
	}

	
	private void generar_ene_aleatorio(int n)
	{
		switch(n)
		{
			case 0 : { generar_pos_y_agregar(new EnemigoBasico(juego)); break;}
			case 1 : { generar_pos_y_agregar(new EnemigoBlindado(juego)); break;}
			case 2 : { generar_pos_y_agregar(new EnemigoDePoder(juego)); break;}
			case 3 : { generar_pos_y_agregar(new EnemigoRapido(juego)); break;}
		}
	}
	
	
	private void generar_pos_y_agregar(Enemigo e)
	{
		boolean agregue=false;
		while (!agregue)
		{
			int posx = (r.nextInt()%13)*60;
			if (posx<0) posx*=-1;
			if (juego.getCont_ene().se_puede_agregar(posx,0,e.getEtiqueta().getHeight() , e.getEtiqueta().getWidth()))
			{
				//veo si justo esta el tanque en ese lugar
				if (!intersecta_con_Tanque(posx,0,e.getEtiqueta().getHeight() , e.getEtiqueta().getWidth()))
				{
					agregue=true;
					e.setX(posx);
					e.setY(0);
					cant_ene++;
					juego.agregar_enemigo(e);
				}
				
			}
		}
	}
	


	private boolean intersecta_con_Tanque(int x,int y, int h, int w) 
	{
		boolean inter=false;
		
		Rectangle r = new Rectangle(x,y,h,w);
		Area ae = new Area(r.getBounds());
		Area at = new Area(juego.getTanque().getEtiqueta().getBounds());
		if (ae.intersects(at.getBounds2D()))
			inter=true;
		
		return inter;
	}
	
	public void fin_hilo()
	{
		fin_hilo=true;
	}

	@Override
	public void run() 
	{
		while (!fin_hilo)
		{
			if (!pausa)
				agregar();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

	public int get_cant_p_ganar() 
	{
		return cant_para_ganar;
	}

	public int get_ene_muertos() 
	{
		return enemigos_muertos;
	}

}
