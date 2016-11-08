package Controladores;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import Enemigos.Enemigo;
import Juego.Juego;
import Proyectil.Proyectil;

/**Controla a los enemigos
 * 
 *
 */
public class Controlador_Enemigos implements Runnable 
{
	
	private List<Enemigo> lista_enemigos;
	private List<Enemigo> lista_enemigos_borrar;
	private List<Enemigo> lista_enemigos_agregar;
	private boolean terminar_hilo;
	private boolean pausa;
	
	
	public Controlador_Enemigos()
	{
		pausa=false;
		lista_enemigos = new ArrayList<Enemigo>();
		lista_enemigos_borrar = new ArrayList<Enemigo>();
		lista_enemigos_agregar = new ArrayList<Enemigo>();
		terminar_hilo=false;
	}
	
	public void destruir_todos(Juego j)
	{
		for (int i=0; i<lista_enemigos.size();i++)
		{
			j.eliminar_enemigo(lista_enemigos.get(i));
		}
	}
	
	public void set_pausa(Boolean b)
	{
		pausa=b;
	}
	
	//retorna true si se puede agregar un enemigo en este lugar
	//el y recibido es cero
	public boolean se_puede_agregar(int x, int y,int l, int a)
	{
		boolean puede=true;
		Rectangle r = new Rectangle(x,y,l,a);
		Area area = new Area(r);
		
		for (int i=0; i<lista_enemigos.size(); i++)
		{
			Area ae = new Area(lista_enemigos.get(i).getEtiqueta().getBounds());
			if (area.intersects(ae.getBounds2D()))
				puede=false;
		}
		return puede;
	}
	
	/**
	 * indica que el enemigo e debe ser agregado
	 * @param e
	 */
	public void add_Enemigo(Enemigo e)
	{
		lista_enemigos_agregar.add(e);
	}
	
	/**
	 * Agraga los enemigos que se indico que debian ser agregados
	 */
	public void agregar_enemigos()
	{
		for (int i=0; i<lista_enemigos_agregar.size(); i++)
		{
			lista_enemigos.add(lista_enemigos_agregar.remove(0));
		}
	}
	
	
	/**
	 * Indica que el enemigo e debenser borrado
	 * @param e
	 */
	public void elim_enemigo(Enemigo e)
	{
		lista_enemigos_borrar.add(e);
	}
	
	/**
	 * Elimina los enemigos que se indico que debian eliminarse
	 */
	public void eliminar_enemigos()
	{
		
		for (int i=0; i<lista_enemigos_borrar.size();i++)
		{
			lista_enemigos.remove(lista_enemigos_borrar.remove(0));
		}
	}
	
	
	public void terminar_hilo()
	{
		terminar_hilo=true;
	}
	
	
	
	private void mover_enemigos()
	{
		for (int i=0; i<lista_enemigos.size(); i++)
			lista_enemigos.get(i).mover();
	}
	
	/**
	 * Recibe un proyectil y controla si choca con algun enemigo, en caso de
	 * chocar, se llama al metodo intersectar de proyectil
	 * @param p
	 */
	public void control_impacto_proyectil(Proyectil p)
	{
		Area a_proy = new Area(p.getEtiqueta().getBounds());
		
		for (int i=0; i<lista_enemigos.size();i++)
		{
			Enemigo e = lista_enemigos.get(i);
			Area a_ene = new Area(e.getEtiqueta().getBounds());
			if (a_proy.intersects(a_ene.getBounds2D()))
			{
				p.impactar(e);
			}
		}
		
	}
	
	/**dado un enemigo, y una posicion (x,y) que corresponde a la posicion de "e" si se realizara cierto movimiento
	 * controla si tras ese posible movimiento, el enemigo e choca con otro de los enemigos
	 * 
	 * @param e
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean interseccion_entre_enemigos(Enemigo e, int x, int y)
	{
		Rectangle r = new Rectangle(x,y,e.getEtiqueta().getWidth(),e.getEtiqueta().getHeight());
		Area a_ene = new Area(r.getBounds());
		boolean intersecta = false;
		for (int i=0; i<lista_enemigos.size(); i++)
		{
			Enemigo ene = lista_enemigos.get(i);
			if (ene!=e)
			{
				Area a2 = new Area(ene.getEtiqueta().getBounds());
				if (a_ene.intersects(a2.getBounds2D()))
					intersecta=true;
			}
		}
		return intersecta;
	}
	
	@Override
	public void run() 
	{
		while (!terminar_hilo)
		{
			eliminar_enemigos();		//elimina los eliminables
			agregar_enemigos();			//agrega los agregables
			if (!pausa)
			{
				mover_enemigos();			//mueve los enemigos
			}	
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
