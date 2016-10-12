package Controladores;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import Enemigos.Enemigo;
import Juego.Juego;
import Proyectil.Proyectil;

public class Controlador_Enemigos implements Runnable 
{
	private Juego juego;
	private List<Enemigo> lista_enemigos;
	private List<Enemigo> lista_enemigos_borrar;
	private List<Enemigo> lista_enemigos_agregar;
	private boolean terminar_hilo;
	
	
	public Controlador_Enemigos(Juego j)
	{
		juego=j;
		lista_enemigos = new ArrayList<Enemigo>();
		lista_enemigos_borrar = new ArrayList<Enemigo>();
		lista_enemigos_agregar = new ArrayList<Enemigo>();
		terminar_hilo=false;
	}
	
	public void add_Enemigo(Enemigo e)
	{
		lista_enemigos_agregar.add(e);
	}
	
	public void agregar_enemigos()
	{
		for (int i=0; i<lista_enemigos_agregar.size(); i++)
		{
			lista_enemigos.add(lista_enemigos_agregar.remove(0));
		}
	}
	
	
	public void elim_enemigo(Enemigo e)
	{
		lista_enemigos_borrar.add(e);
	}
	
	public void eliminar_enemigos()
	{
		for (int i=0; i<lista_enemigos_borrar.size();i++)
		{
			//juego.eliminar_enemigo(lista_enemigos_borrar.get(0));
			lista_enemigos.remove(lista_enemigos_borrar.remove(0));
		}
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
	
	
	public void control_impacto_proyectil(Proyectil p)
	{
		Area a_proy = new Area(p.getEtiqueta().getBounds());
		for (Enemigo e : lista_enemigos)
		{
			Area a_ene = new Area(e.getEtiqueta().getBounds());
			if (a_proy.intersects(a_ene.getBounds2D()))
			{
				p.impactar(e);
			}
		}
		
	}
	
	@Override
	public void run() 
	{
		while (!terminar_hilo)
		{
			eliminar_enemigos();
			agregar_enemigos();
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
