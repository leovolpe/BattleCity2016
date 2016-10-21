package Obstaculos;

import javax.swing.JLabel;

import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

/**Obstaculo base
 *
 */
public class Base extends Obstaculo 
{
	

	public Base(int xx, int yy, Juego j) 
	{
		super(1,j);
		etiqueta=new JLabel(graficos.getBase());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}



	@Override
	public boolean atravesable() 
	{
		return false;
		//la base no es atravesable
	}



	

	@Override
	public void aceptar_visitor_proyectil(Visitor_Proyectil_obstaculo v) 
	{
		v.visitar(this);
		
	}
	

}
