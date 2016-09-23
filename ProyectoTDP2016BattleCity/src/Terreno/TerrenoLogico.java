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
	
	public TerrenoLogico(grafico_juego g, Tanque_Jugador t)
	{
		tanque=t;
		gj = g;
		GeneradorDeMapa generador=new GeneradorDeMapa();
		listaObstaculos=generador.generarMapa();
		
		//agrego en pantalla los obstaculos
		for (Obstaculo o : listaObstaculos)
		{
			gj.agregar_obstaculo(o);
		}		
		control();
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
			tanque.mostrar_coordenada();
		}
	}
		
}


