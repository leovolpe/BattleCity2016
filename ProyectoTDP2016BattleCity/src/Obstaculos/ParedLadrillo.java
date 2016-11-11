package Obstaculos;

import javax.swing.JLabel;

import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_obstaculo;

/**Obstaculo pared de ladrillo
 * 
 *
 */
public class ParedLadrillo extends Obstaculo
{

	public ParedLadrillo(int xx, int yy, Juego j) 
	{
		super(4,j);
		etiqueta=new JLabel(graficos.getLadrillo());
		this.setX(xx);
		this.setY(yy);
		etiqueta.setSize(60, 60);
	}

	

	@Override
	public boolean atravesable() 
	{
		//no es atravesable
		return false;
	}



	//redefinido para setear un nuevo grafico cuando esta con la resistencia a la mitad
	public void reducir_energia()
	{
		resistencia--;
		if (resistencia==2)
			this.getEtiqueta().setIcon(graficos.getLadrillo_fuego());
		if (resistencia==0)
			super.destruirse();
	}


	
	public void aceptar_visitor_proyectil(Visitor_Proyectil_obstaculo v) 
	{
		v.visitar(this);
	}
	

}
