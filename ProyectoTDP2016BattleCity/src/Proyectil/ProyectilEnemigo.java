package Proyectil;

import javax.swing.JLabel;

import Enemigos.Enemigo;
import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import Obstaculos.Obstaculo;
import Visitor_Proyectiles.Visitor_proyectil_enemigo_obstaculo;

/**Proyectil que es lanzado por los enemigos, es el mismo proyectil para todos
 *
 */
public class ProyectilEnemigo extends Proyectil {

	
	private Enemigo enemigo;
	
	public ProyectilEnemigo(Enemigo e,char d,int x, int ancho, int y, int largo, Juego j, int vd) 
	{
		super(vd,d,j);
		enemigo=e;
		etiqueta = new JLabel(gb.getBala_E4());
		etiqueta.setSize(10,10);
		
		super.setPosicion_inicial(d, x, y, ancho, largo);
		getJuego().agregar_proyectil(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impactar(Tanque_Jugador t) 
	{
		t.reducir_vida();
		destruirse();
	}

	@Override
	public void impactar(Obstaculo o) 
	{
		o.aceptar_visitor_proyectil(new Visitor_proyectil_enemigo_obstaculo(this,getJuego()));
		
	}

	@Override
	public void destruirse() 
	{
		enemigo.reducir_disparo();
		getJuego().eliminar_proyectil(this);
		
	}

	@Override
	public void impactar(Enemigo e) 
	{
		//si se dispara a si mismo entonces la bala desaparece pero no hace daño
		destruirse();
		// TODO Auto-generated method stub
		
	}

}
