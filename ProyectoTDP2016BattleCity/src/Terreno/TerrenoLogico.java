package Terreno;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.LinkedList;
import java.util.List;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Obstaculos.Obstaculo;
import PowerUps.PowerUp;
import Proyectil.Proyectil;
import Temporizadores.Temporizador_intercambio_paredes;



public class TerrenoLogico {

	//mantengo la lista de los obtaculos
	protected LinkedList<Obstaculo> listaObstaculos;
	protected List<PowerUp>	pwps_en_pantalla;
	protected Juego juego;
	protected GeneradorDeMapa generador;
	
	
	public TerrenoLogico(Juego j, int n)
	{
		juego=j;
		generador=new GeneradorDeMapa(juego);	//creo un generador de mapa
		
		switch(n)
		{
			case 1 : {listaObstaculos=generador.generarMapa1(); break;}
			case 2 : {listaObstaculos=generador.generarMapa2(); break;}
			case 3 : {listaObstaculos=generador.generarMapa3(); break;}
			case 4 : {listaObstaculos=generador.generarMapa4(); break;}
			default: {listaObstaculos=generador.generarMapa1(); break;}
		}
		
		 //obtengo los obtaculos correspondientes al mapa 1
		pwps_en_pantalla = new LinkedList<PowerUp>();
		
		//agrego en pantalla los obstaculos
		for (Obstaculo o : listaObstaculos)
		{
			juego.agregar_obstaculo_graficamente(o);
		}		
	}
	
	
	//se fija si no fue atrapado y lo borra
	public void intentar_borrar(PowerUp p)
	{
		if (pwps_en_pantalla.contains(p))
			removePwp(p);
	}
	
	
	public void paredes_acero()
	{
		Temporizador_intercambio_paredes t = new Temporizador_intercambio_paredes(listaObstaculos,juego,10);
		new Thread(t).start();
	}
	
	
	public void addPwp(PowerUp p)
	{
		pwps_en_pantalla.add(p);
		juego.agregar_powerup_graficamente(p);
	}
	
	
	public void removePwp(PowerUp p)
	{
		pwps_en_pantalla.remove(p);
	}
	
	
	/**Controla si el proyectil p intersecta con algun obstaculo, 
	 * en caso de que esto ocurra se ejecuta el metodo intersectar de proyectil
	 * 
	 * @param p proyectil
	 */
	public void control_balas(Proyectil p)
	{
		Area ap = new Area(p.getEtiqueta().getBounds());
		
		for (int i=0; i<listaObstaculos.size(); i++)
		{
			Obstaculo obs = listaObstaculos.get(i);
			Area ao = new Area(obs.getEtiqueta().getBounds());
			if (ap.intersects(ao.getBounds2D()))//si la bala y el obstaculo estan en el mismo lugar
				p.impactar(obs);
		}
	}
	
	/**	Elimina el obstaculo de la lista que lo contiene
	 * 	
	 * @param o obstaculo
	 */
	public void eliminar_obstaculo(Obstaculo o)
	{
		listaObstaculos.remove(o);
	}
	

	
	//Rectangle(int x, int y, int width, int height)
	/**
	 * consulta usada por las entidades moviles al intentar avanzar
	 * Recibe la posicion (x,y), el largo y verifica si pueden avanzar a ese lugar en el mapa
	 * @param x
	 * @param y
	 * @param ancho
	 * @param largo
	 * @return
	 */
	public boolean Puede_Avanzar(int x, int y, int ancho, int largo)
	{
		Rectangle r = new Rectangle(x,y,ancho,largo);
		Area area_entidad = new Area(r);
		
		Boolean puede_avanzar=true;
		
		//cada obstaculo implementa el metodo atravezable el cual indica si puede ser transpasado por una entidad movil
		for (int i=0; i< listaObstaculos.size(); i++)
		{
			Obstaculo o = listaObstaculos.get(i);
			Area area_obstaculo = new Area(o.getEtiqueta().getBounds());
			if (area_entidad.intersects(area_obstaculo.getBounds2D()))
				puede_avanzar = puede_avanzar && o.atravesable();		
			//en el caso de que algun obstaculo con el que chocaria le impide avanzar, entonces el valor de puede_avanzar sera falso
		}
		
		//no se le permite a la entidad movil sobrepasar los limites
		if (x<0 || x > (juego.getGui().getGj().getPanel_tanque().getWidth()-60) ||
			y <0 || y>(juego.getGui().getGj().getPanel_tanque().getHeight()-60) ) puede_avanzar=false;
		
		return puede_avanzar;
	}
	
	//este metodo esta para que el tanque no deba encajar perfecto entre paredes
	//sino que se incrustan un poco en los obstaculos
	public boolean Puede_Avanzar_relajado_para_tanque(int x, int y, int ancho, int largo)
	{
		Rectangle r = new Rectangle(x,y,ancho-10,largo-10);
		Area area_entidad = new Area(r);
		
		Boolean puede_avanzar=true;
		
		//cada obstaculo implementa el metodo atravezable el cual indica si puede ser transpasado por una entidad movil
		for (int i=0; i< listaObstaculos.size(); i++)
		{
			Obstaculo o = listaObstaculos.get(i);
			Rectangle r2 = new Rectangle(o.getX(),o.getY(),o.getEtiqueta().getWidth()-10,o.getEtiqueta().getHeight()-10);
			
			Area area_obstaculo = new Area(r2);
			
			if (area_entidad.intersects(area_obstaculo.getBounds2D()))
				puede_avanzar = puede_avanzar && o.atravesable();		
			//en el caso de que algun obstaculo con el que chocaria le impide avanzar, entonces el valor de puede_avanzar sera falso
		}
		
		//no se le permite a la entidad movil sobrepasar los limites
		if (x<0 || x > (juego.getGui().getGj().getPanel_tanque().getWidth()-60) ||
			y <0 || y>(juego.getGui().getGj().getPanel_tanque().getHeight()-60) ) puede_avanzar=false;
		
		return puede_avanzar;
	}
	
	//se fija si el tanque toca un powerup
	public void control_tanque_pwp(Tanque_Jugador t)
	{
		Area atanque = new Area(t.getEtiqueta().getBounds());
		for (int i=0; i<pwps_en_pantalla.size();i++)
		{
			PowerUp p = pwps_en_pantalla.get(i);
			Area apwp = new Area(p.getEtiqueta().getBounds());
			if (atanque.intersects(apwp.getBounds2D()))
			{
				p.contacto(t);
			}
		}
	}
	
		
}


