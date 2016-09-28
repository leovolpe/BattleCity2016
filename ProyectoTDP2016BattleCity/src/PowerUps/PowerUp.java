package PowerUps;

import Entidades_Moviles.Tanque_Jugador;
import Juego.Juego;
import ObjetosDeJuego.ObjetoDeJuego;

public abstract class PowerUp extends ObjetoDeJuego {
	
protected int puntos;

public PowerUp(int p, Juego j)
{
	super(j);
	puntos=p;
}

public abstract void contacto(Tanque_Jugador ta);

protected abstract void destruirse();

 

	
}
