package Enemigos;

import javax.swing.JLabel;

import Graficas_Personajes.Enemigos.graficos_tanque_rapido;
import Juego.Juego;

public class EnemigoRapido extends Enemigo
{

	public EnemigoRapido(int r, int vm, int vd, int ds, int dp, int p, Juego j) {
		super(r, vm, vd, ds, dp, p, j);
		graficos = new graficos_tanque_rapido();
		etiqueta=new JLabel(graficos.getAbajo());
		etiqueta.setSize(60, 60);
		this.setX(0);
		this.setY(0);
	}

}
