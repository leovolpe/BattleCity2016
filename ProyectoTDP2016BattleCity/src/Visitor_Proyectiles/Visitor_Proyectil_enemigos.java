package Visitor_Proyectiles;

import Enemigos.*;
import Proyectil.Proyectil;

public abstract class Visitor_Proyectil_enemigos 
{
	protected Proyectil proy;
	
	public abstract void visitar(EnemigoBasico e);
	public abstract void visitar(EnemigoBlindado e);
	public abstract void visitar(EnemigoDePoder e);
	public abstract void visitar(EnemigoRapido e);
	
	

}
