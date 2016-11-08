package Visitor_Proyectiles;

import Juego.Juego;
import Obstaculos.Agua;
import Obstaculos.Arbol;
import Obstaculos.Base;
import Obstaculos.ParedAcero;
import Obstaculos.ParedLadrillo;
import Proyectil.Proyectil;

public class Visitor_proyectil_enemigo_obstaculo extends Visitor_Proyectil_obstaculo 
{
	
	public Visitor_proyectil_enemigo_obstaculo(Proyectil p,Juego j)
	{
		proy=p;
		juego=j;
	}

	@Override
	public void visitar(Agua a) {
		// TODO Auto-generated method stub
		//nnada
	}

	@Override
	public void visitar(Arbol a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Base b) {
		// TODO Auto-generated method stub
		proy.destruirse();
		juego.perder();
		
	}

	@Override
	public void visitar(ParedAcero p) 
	{
		// TODO Auto-generated method stub
		proy.destruirse();
	}

	@Override
	public void visitar(ParedLadrillo p) 
	{
		p.reducir_energia();
		proy.destruirse();
		
	}

}
