package Controladores;

import java.util.ArrayList;
import java.util.List;

import Juego.Juego;
import Proyectil.Proyectil;

/**controla a los proyectiles
 * 
 *
 */
public class Controlador_balas implements Runnable 
{
	private Juego juego;
	private boolean terminar_hilo;
	private List<Proyectil> listaProyectiles; //proyectiles que estan en movimiento actualmente
	private List<Proyectil> listaProyectilesNuevos; //guarda temporalmente los proyectiles que se estan por agregar
	private List<Proyectil> listaProyectilesaEliminar;
	
	public Controlador_balas(Juego j)
	{
		juego=j;
		terminar_hilo=false;
		listaProyectiles = new ArrayList<Proyectil>();
		listaProyectilesNuevos = new ArrayList<Proyectil>();
		listaProyectilesaEliminar = new ArrayList<Proyectil>();
	}
	
	
	/**
	 * Agrega una bala en la lista de agregables, luego se agregara
	 * @param p
	 */
	public void add_proyectil(Proyectil p)
	{
		listaProyectilesNuevos.add(p);
	}
	
	/**
	 * Agrega un proyectil a la lista de borrables, luego se eliminara
	 * @param p
	 */
	public void remove_proyectil(Proyectil p)
	{
		listaProyectilesaEliminar.add(p);
	}
	
	/**
	 * elimina los proyectiles que se se indico que deben borrarse
	 */
	private void borrar_Proyectiles()
	{
		for (int i=0; i<listaProyectilesaEliminar.size();i++)
		{
			Proyectil p = listaProyectilesaEliminar.remove(0);
			listaProyectiles.remove(p);
		}	
	}
	
	/**
	 * agrega los proyectiles que se indico que deben ser agregados
	 */
	private void agregar_Proyectiles()
	{
		for (int i=0; i<listaProyectilesNuevos.size();i++)
			listaProyectiles.add(listaProyectilesNuevos.remove(0));
	}
	
	
	//por ahora este es el unico metodo que accede a la parte grafica para conocer las dimensiones de la pantalla
	/**
	 * controla si el proyectil p esta fuera de rango
	 * @param p
	 * @return
	 */
	private boolean fuera_de_rango(Proyectil p)
	{

		if ( ( (p.getX()+p.getEtiqueta().getWidth())<0 || p.getX() > (juego.getGui().getGj().getPanel_tanque().getWidth()+p.getEtiqueta().getHeight()) ||
				(p.getY()+p.getEtiqueta().getHeight())<0 || p.getY()>(juego.getGui().getGj().getPanel_tanque().getHeight()+p.getEtiqueta().getHeight()) )) return true;
		else return false;

	}

	/**
	 * mueve los proyectiles y controla intersecciones
	 */
	private void mover_Proyectiles() 
	{
		
		for (int i=0; i< listaProyectiles.size(); i++)
		{
			Proyectil p = listaProyectiles.get(i);
			p.mover();			//MUEVE
			if (fuera_de_rango(p)) //SI ESTA FUERA DE RANGO LO BORRA
				p.destruirse();
			else
			{
				juego.getCont_ene().control_impacto_proyectil(p); //CONTROLA SI IMPACTA CON UN ENEMIGO
				juego.getTerreno_logico().control_balas(p);			//CONTROLA SI IMPACTA CON UN OBSTACULO
			}
		}
		
	}
	
	/**
	 * finaliza el hilo
	 */
	public void terminar_hilo()
	{
		terminar_hilo=true;
	}
	
	
	@Override
	public void run() 
	{
		
		while(!terminar_hilo)
		{
			agregar_Proyectiles();		//agrega los que se deben agregar
			borrar_Proyectiles();		//elimian los que se deben eliminar
			mover_Proyectiles();		//mueve los proyectiles
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("X = "+juego.getTanque().getX()+" - "+juego.getTanque().getY());
		}
	}

	

}
