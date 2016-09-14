package Terreno;

import java.util.LinkedList;
import Graficas_paneles.grafico_juego;
import Obstaculos.Obstaculo;


public class TerrenoLogico {

	//mantengo la lista de los obtaculos
	protected LinkedList<Obstaculo> listaObstaculos;
	//mantengo los graficos correspondientes al juego
	protected grafico_juego gj;
	
	public TerrenoLogico(grafico_juego g)
	{
		gj = g;
		GeneradorDeMapa generador=new GeneradorDeMapa();
		listaObstaculos=generador.generarMapa();
		
		//agrego en pantalla los obstaculos
		for (Obstaculo o : listaObstaculos)
		{
			gj.agregar_obstaculo(o);
		}		
	}
}


