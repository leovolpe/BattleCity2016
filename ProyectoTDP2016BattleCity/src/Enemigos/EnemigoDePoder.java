package Enemigos;

import javax.swing.JLabel;

import Graficas_Personajes.Enemigos.graficos_tanque_poder;
import Juego.Juego;
import Visitor_Proyectiles.Visitor_Proyectil_enemigos;

/**Enemigo de poder
 * 
 *
 */
public class EnemigoDePoder extends Enemigo
{

	public EnemigoDePoder( Juego j) 
	{
		super(1, 6, 1, 1,300, j);
		graficos = new graficos_tanque_poder();
		etiqueta=new JLabel(graficos.getAbajo());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(0);
	}

	@Override
	public void accept(Visitor_Proyectil_enemigos v) 
	{
		v.visitar(this);
		
	}

}
