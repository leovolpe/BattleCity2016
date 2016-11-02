package Obstaculos;

import javax.swing.JLabel;

import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

/**Obstaculo pared de acero
 * 
 */
public class ParedAcero extends Obstaculo
{

	
	
	public ParedAcero(int xx, int yy, Juego j) 
	{
		super(4,j);
		etiqueta=new JLabel(graficos.getAcero());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}

	


	@Override
	public boolean atravesable() 
	{
		return false;
		//la pared de acero no es atravesable
	}



	@Override
	public void reducir_energia()
	{
		resistencia--;
		if (resistencia==2)
			this.getEtiqueta().setIcon(graficos.getAcerof());
		if (resistencia==0)
			super.destruirse();
	}
	
	

	@Override
	public void aceptar_visitor_proyectil(Visitor_Proyectil_obstaculo v) 
	{
		v.visitar(this);
		
	}
	
}
