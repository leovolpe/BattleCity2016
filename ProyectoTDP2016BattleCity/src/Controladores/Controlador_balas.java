package Controladores;

import java.util.ArrayList;
import java.util.List;

import Juego.Juego;
import Proyectil.Proyectil;

public class Controlador_balas implements Runnable 
{
	private Juego juego;
	private List<Proyectil> listaProyectiles; //proyectiles que estan en movimiento actualmente
	private List<Proyectil> listaProyectilesNuevos; //guarda temporalmente los proyectiles que se estan por agregar
	private List<Proyectil> listaProyectilesaEliminar;
	
	public Controlador_balas(Juego j)
	{
		juego=j;
		listaProyectiles = new ArrayList<Proyectil>();
		listaProyectilesNuevos = new ArrayList<Proyectil>();
		listaProyectilesaEliminar = new ArrayList<Proyectil>();
	}
	
	public void add_proyectil(Proyectil p)
	{
		listaProyectilesNuevos.add(p);
	}
	
	public void remove_proyectil(Proyectil p)
	{
		listaProyectilesaEliminar.add(p);
	}
	
	private void borrar_Proyectiles()
	{
		
		for (int i=0; i<listaProyectilesaEliminar.size();i++)
		{
			//juego.getGui().getGj().borrar_proyectil(listaProyectilesaEliminar.get(0));
			//listaProyectilesaEliminar.get(0).destruirse();
			Proyectil p = listaProyectilesaEliminar.remove(0);
			//juego.eliminar_proyectil(p);
			listaProyectiles.remove(p);
			
		}
				
		
	}
	
	private void agregar_Proyectiles()
	{
		for (int i=0; i<listaProyectilesNuevos.size();i++)
			listaProyectiles.add(listaProyectilesNuevos.remove(0));
	}
	
	//por ahora este es el unico metodo que accede a la parte grafica para conocer las dimensiones de la pantalla
	private boolean fuera_de_rango(Proyectil p)
	{

		if ( ( (p.getX()+p.getEtiqueta().getWidth())<0 || p.getX() > (juego.getGui().getGj().getPanel_tanque().getWidth()+p.getEtiqueta().getHeight()) ||
				(p.getY()+p.getEtiqueta().getHeight())<0 || p.getY()>(juego.getGui().getGj().getPanel_tanque().getHeight()+p.getEtiqueta().getHeight()) )) return true;
		else return false;

	}

	private void mover_Proyectiles() 
	{
		
		for (int i=0; i< listaProyectiles.size(); i++)
		{
			Proyectil p = listaProyectiles.get(i);
			p.mover();
			if (fuera_de_rango(p))
				p.destruirse();
			else
			{
				juego.getCont_ene().control_impacto_proyectil(p);
				juego.getTerreno_logico().control_balas(p);
			}
		}
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			agregar_Proyectiles();
			borrar_Proyectiles();
			mover_Proyectiles();
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	

}
