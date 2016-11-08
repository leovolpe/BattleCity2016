package PowerUps;

import javax.swing.JLabel;

import Entidades_Moviles.Tanque_Jugador;
import Inmunidad.Temporizador_inmunidad;
import Juego.Juego;

public class Casco extends PowerUp{

	
	
	public Casco(Juego j, int x, int y) {
		super(j);
		etiqueta = new JLabel(graficos.getCasco());
		etiqueta.setSize(60,60);
		
		this.setX(x);
		this.setY(y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contacto(Tanque_Jugador ta) 
	{
		ta.aumentarPuntaje(puntos);
		Temporizador_inmunidad t = new Temporizador_inmunidad(10,ta);
		new Thread(t).start();
		destruirse();
		
	}

	
	

	
}
