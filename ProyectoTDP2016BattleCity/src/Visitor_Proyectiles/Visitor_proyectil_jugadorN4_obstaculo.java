package Visitor_Proyectiles;

import Obstaculos.Agua;
import Obstaculos.Arbol;
import Obstaculos.Base;
import Obstaculos.ParedAcero;
import Obstaculos.ParedLadrillo;
import Proyectil.Proyectil;

public class Visitor_proyectil_jugadorN4_obstaculo extends Visitor_Proyectil_obstaculo 
{
	public Visitor_proyectil_jugadorN4_obstaculo(Proyectil p)
	{
		proy=p;
	}
	

	@Override
	public void visitar(Agua a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Arbol a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Base b) {
		// TODO Auto-generated method stub
		System.out.println("perdi");
		proy.destruirse();
	}

	@Override
	public void visitar(ParedAcero p) 
	{
		// TODO Auto-generated method stub
		p.reducir_energia();
		proy.destruirse();
		
	}

	@Override
	public void visitar(ParedLadrillo p) 
	{
		// TODO Auto-generated method stub
		p.reducir_energia();
		proy.destruirse();
	}

}
