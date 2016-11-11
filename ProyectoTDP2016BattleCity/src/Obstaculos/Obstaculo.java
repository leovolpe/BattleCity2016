package Obstaculos;

import Graficas_Obstaculos.graficos_obstaculo;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

/**
 * Clase que representa un obstaculo un obstaculo
 *
 */
public abstract class Obstaculo extends ObjetoDeJuego 
{
	
	protected int resistencia;
	protected graficos_obstaculo graficos;
	
	
	protected Obstaculo(int r, Juego j)
	{
		super(j);
		resistencia=r;
		graficos=new graficos_obstaculo();
	}
	
	
	/**Los obstaculos concretos deben implementar este metodo para indicar si una entidad movil lo puede atravesar
	 * 
	 */
	public abstract boolean atravesable();
	
	
	
	/**
	 * Le pide al juego que se elimine de forma grafica y logica
	 */
	public void destruirse()
	{
		getJuego().eliminar_obstaculo(this);
	}
	
	
	/**
	 * Reduce la resistencia en uno
	 */
	public void reducir_energia()
	{
		resistencia--;
		if (resistencia==0)
			destruirse();
	}
	
	
	/**Acepta un visitor de una bala
	 * 
	 * @param v visitor_proyectil_obstaculo
	 */
	public abstract void aceptar_visitor_proyectil(Visitor_Proyectil_obstaculo v);
}
