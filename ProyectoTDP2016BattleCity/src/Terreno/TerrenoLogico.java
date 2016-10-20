package Terreno;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.LinkedList;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Graficas_paneles.grafico_juego;
import Juego.Juego;
import Obstaculos.Obstaculo;
import Proyectil.Proyectil;


public class TerrenoLogico {

	//mantengo la lista de los obtaculos
	protected LinkedList<Obstaculo> listaObstaculos;
	//mantengo los graficos correspondientes al juego
	protected Juego juego;
	//protected grafico_juego gj;
	//protected Tanque_Jugador tanque;
	
	protected GeneradorDeMapa generador;
	
	
	public TerrenoLogico(Juego j)
	{
		juego=j;
		//tanque=t;
	//	gj = g;
		generador=new GeneradorDeMapa(this);
		listaObstaculos=generador.generarMapa();
		
		//agrego en pantalla los obstaculos
		for (Obstaculo o : listaObstaculos)
		{
			//gj.agregar_obstaculo(o);
			juego.getGui().getGj().agregar_obstaculo(o);
		}		
		//control();
	}
	
	public LinkedList<Obstaculo> getLista()
	{
		return listaObstaculos;
	}
	
	public void control_balas(Proyectil p)
	{
		Area ap = new Area(p.getEtiqueta().getBounds());
		
		for (int i=0; i<listaObstaculos.size(); i++)
		{
			Obstaculo obs = listaObstaculos.get(i);
			Area ao = new Area(obs.getEtiqueta().getBounds());
			if (ap.intersects(ao.getBounds2D()))
				p.impactar(obs);
		}
	}
	
	public void eliminar_obstaculo(Obstaculo o)
	{
		listaObstaculos.remove(o);
	}
	
	public void quitarObstaculo()
	{
		
		
		if (listaObstaculos.size()>0)
			listaObstaculos.removeFirst().destruirse();
		
		
		
		//juego.getGui().getGj().getPanel_obstaculos().remove(listaObstaculos.removeFirst().getEtiqueta());
		
		//juego.getGui().getGj().getPanel_obstaculos().repaint();
		System.out.println(listaObstaculos.size());
		/*
		gj.getPanel_obstaculos().remove(listaObstaculos.getFirst().getEtiqueta());
		
		int x=listaObstaculos.getFirst().getX();
		int y=listaObstaculos.getFirst().getY();
		
		generador.borrar(x, y);
		
		listaObstaculos.removeFirst();
		*/
		
	}
	
	//Rectangle(int x, int y, int width, int height)
	public boolean Puede_Avanzar(int x, int y, int ancho, int largo)
	{
		Rectangle r = new Rectangle(x,y,ancho,largo);
		Area area_entidad = new Area(r);
		Boolean puede_avanzar=true;
		
		
		for (int i=0; i< listaObstaculos.size(); i++)
		{
			Obstaculo o = listaObstaculos.get(i);
			Area area_obstaculo = new Area(o.getEtiqueta().getBounds());
			if (area_entidad.intersects(area_obstaculo.getBounds2D()))
				puede_avanzar = puede_avanzar && o.atravezable();
		}
		
		if (x<0 || x > (juego.getGui().getGj().getPanel_tanque().getWidth()-60) ||
			y <0 || y>(juego.getGui().getGj().getPanel_tanque().getHeight()-60) ) puede_avanzar=false;
		
		return puede_avanzar;
	}
	
	/*
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
	*/
	
	public Juego getJuego()
	{
		return juego;
	}
		
}


