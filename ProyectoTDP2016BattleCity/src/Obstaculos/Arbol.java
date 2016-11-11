package Obstaculos;

import javax.swing.JLabel;

import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

/**Obstaculo arbol
 *
 */
public class Arbol extends Obstaculo
{
	
	public Arbol(int xx, int yy, Juego j) {
		super(2,j);
		etiqueta=new JLabel(graficos.getArbol());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}


	@Override
	public boolean atravesable() 
	{
		return true;
		//el arbol es atravesable
	}


	@Override
	public void aceptar_visitor_proyectil(Visitor_Proyectil_obstaculo v) 
	{
		v.visitar(this);
		
	}
	
}
