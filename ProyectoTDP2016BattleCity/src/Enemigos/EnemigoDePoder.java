package Enemigos;

import javax.swing.JLabel;

import Graficas_Personajes.Enemigos.graficos_tanque_poder;

public class EnemigoDePoder extends Enemigo
{

	public EnemigoDePoder(int r, int vm, int vd, int ds, int dp, int p) {
		super(r, vm, vd, ds, dp, p);
		graficos = new graficos_tanque_poder();
		etiqueta=new JLabel(graficos.getAbajo());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(0);
	}

}
