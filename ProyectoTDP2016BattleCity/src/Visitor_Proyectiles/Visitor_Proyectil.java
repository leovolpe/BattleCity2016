package Visitor_Proyectiles;

import Obstaculos.*;
import Proyectil.Proyectil;

public abstract class Visitor_Proyectil 
{
	protected Proyectil proy;
	
	public abstract void visitar(Agua a);
	public abstract void visitar(Arbol a);
	public abstract void visitar(Base b);
	public abstract void visitar(ParedAcero p);
	public abstract void visitar(ParedLadrillo p);

}
