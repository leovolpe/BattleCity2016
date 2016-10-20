package Visitor_Proyectiles;

import Obstaculos.Agua;
import Obstaculos.Arbol;
import Obstaculos.Base;
import Obstaculos.ParedAcero;
import Obstaculos.ParedLadrillo;
import Proyectil.Proyectil;



public class Visitor_proyectil_jugador extends Visitor_Proyectil
{
	
	public Visitor_proyectil_jugador(Proyectil p)
	{
		proy = p;
	}

	@Override
	public void visitar(Agua a) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Arbol a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Base b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ParedAcero p) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ParedLadrillo p) 
	{
		p.reducir_energia();
		proy.destruirse();
		
	}
	

}
