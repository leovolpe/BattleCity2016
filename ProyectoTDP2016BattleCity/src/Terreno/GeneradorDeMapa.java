package Terreno;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Juego.Juego;
import Obstaculos.*;

/**Para cada mapa disponible (por ahora uno) carga el archivo de texto codificado en una matriz, y luego
 * crea los obstaculos correspondientes seteandoles su posicion
 * 
 *
 */
public class GeneradorDeMapa {

	
	private String[][] mapa; //aca se cargara la codificacion
	private final String archivo_mapa_1 = "src/mapascodificados/mapa1.txt";
	private Juego juego;
	
	/**
	 * Vacio=0
	 * acero=1
	 * arboles=2
	 * agua=3
	 * ladrillo=4
	 * aguila=5
	 */
	
	
	public GeneradorDeMapa(Juego j)
	{
		juego=j;
	}
	
	/**
	 * Genera una lista con los obtaculos del mapa cargandolos de un archivo de texto
	 * @return
	 */
	public LinkedList<Obstaculo> generarMapa1() 
	{
		LinkedList<Obstaculo> listaObs=new LinkedList<Obstaculo>();
		
		try {
			
			FileReader lector=new FileReader(archivo_mapa_1);
			BufferedReader contenido=new BufferedReader(lector);
			
			mapa = new String[10][13];
			
			//genera la primer fila vacia ya que alli por convención no habran obstaculos
			for (int i=0; i<13; i++)
				mapa[0][i]="0";
			
			
			//lleno la matriz con la codificación
			for (int i=1; i<10; i++)
			{
				String fila = contenido.readLine();
				mapa[i]= fila.split("-");		
			}
			
					
			//creo los obstaculos de acuerdo a la codificación del archivo
			for (int i=1; i<10; i++)
			{
				for(int j=0;j<mapa[0].length;j++)
				{
					Obstaculo obs=null;
					switch (mapa[i][j])
					{
						case "1":
						{
							obs=new ParedAcero(j*60,i*60,juego); //sabiendo que cada obstaculo mide 60x60 se calcula su ubicación
							break;
						}
						case "2":
						{
							obs=new Arbol(j*60,i*60,juego);
							break;
						}	
						case "3":
						{
							obs=new Agua(j*60,i*60,juego);
							break;
						}	
						case "4":
						{
							obs=new ParedLadrillo(j*60,i*60,juego);
							break;
						}
						case "5":
						{
							obs=new Base(j*60,i*60,juego);
							break;
						}							
					}
					if (obs!=null)
						listaObs.addLast(obs);
				}
			}
				
		contenido.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaObs;
		
	}
	
	
	

}
