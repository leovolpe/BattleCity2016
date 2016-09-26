package Enemigos;

import javax.swing.JLabel;

import Graficas_Personajes.Enemigos.graficos_tanque_basico;

public class EnemigoBasico extends Enemigo
{

	public EnemigoBasico(int r, int vm, int vd, int ds, int dp, int p) {
		super(r, vm, vd, ds, dp, p);
		graficos = new graficos_tanque_basico();
		etiqueta=new JLabel(graficos.getAbajo());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(0);
		// TODO Auto-generated constructor stub
	}

}
