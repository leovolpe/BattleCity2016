package Terreno;

import java.awt.geom.Area;
import java.util.LinkedList;

import Entidades_Moviles.Tanque_Jugador;
import Graficas_paneles.grafico_juego;
import Obstaculos.Obstaculo;


public class TerrenoLogico {

	//mantengo la lista de los obtaculos
	protected LinkedList<Obstaculo> listaObstaculos;
	//mantengo los graficos correspondientes al juego
	protected grafico_juego gj;
	protected Tanque_Jugador tanque;
	
	protected GeneradorDeMapa generador;
	
	
	public TerrenoLogico(grafico_juego g, Tanque_Jugador t)
	{
		tanque=t;
		gj = g;
		generador=new GeneradorDeMapa();
		listaObstaculos=generador.generarMapa();
		
		//agrego en pantalla los obstaculos
		for (Obstaculo o : listaObstaculos)
		{
			gj.agregar_obstaculo(o);
		}		
		//control();
	}
	
	public LinkedList<Obstaculo> getLista()
	{
		return listaObstaculos;
	}
	
	public void quitarObstaculo()
	{
		gj.getPanel_obstaculos().remove(listaObstaculos.removeFirst().getEtiqueta());
		
		gj.getPanel_obstaculos().repaint();
		System.out.println(listaObstaculos.size());
		/*
		gj.getPanel_obstaculos().remove(listaObstaculos.getFirst().getEtiqueta());
		
		int x=listaObstaculos.getFirst().getX();
		int y=listaObstaculos.getFirst().getY();
		
		generador.borrar(x, y);
		
		listaObstaculos.removeFirst();
		*/
		
	}
	
	public void control()
	{
		while (true)
		{
			Area a = new Area(tanque.getEtiqueta().getBounds());
			for (Obstaculo o : listaObstaculos)
			{
				Area a_obs = new Area(o.getEtiqueta().getBounds());
				if (a.intersects(a_obs.getBounds2D()))
				{
					o.contacto(tanque);
				}
			}
			//tanque.mostrar_coordenada();
		}
	}
		
}


