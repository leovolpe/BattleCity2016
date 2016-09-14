package Terreno;

import java.util.Iterator;
import java.util.LinkedList;


import Obstaculos.Obstaculo;

public class TerrenoLogico {

	protected LinkedList<Obstaculo> listaObs;
	
	
	public TerrenoLogico()
	{
		GeneradorDeMapa generador=new GeneradorDeMapa();
		listaObs=generador.generarMapa();
		
		
		Iterator<Obstaculo> iterable = listaObs.iterator();
		while (iterable.hasNext())
		{

			System.out.println(iterable.next());
			
		}
	}
	
	
}


