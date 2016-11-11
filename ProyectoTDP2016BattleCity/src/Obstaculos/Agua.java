package Obstaculos;

import javax.swing.JLabel;

import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

/**Obstaculo agua
 * 
 *
 */
public class Agua extends Obstaculo
{

	public Agua(int xx, int yy, Juego j) 
	{
		super(2,j);
		etiqueta=new JLabel(graficos.getAgua());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}



	@Override
	public boolean atravesable() 
	{
		return false;
		//el agua no es atravesable
	}

	
	@Override
	public void aceptar_visitor_proyectil(Visitor_Proyectil_obstaculo v) 
	{
		v.visitar(this);
	}


}
