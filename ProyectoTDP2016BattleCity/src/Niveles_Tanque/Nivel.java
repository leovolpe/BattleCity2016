package Niveles_Tanque;

import Entidades_Moviles.Tanque_Jugador;

/**Usando el patron de diseño state, un nivel representa un estado interno del tanque
 *
 *
 */
public abstract class Nivel 
{
	
	private int resistencia;
	private int vel_mov;
	private int vel_disp;
	private int disparos_simultaneos;
	
	public Nivel(int r, int vm, int vd, int ds)
	{
		resistencia = r;
		vel_mov = vm;
		vel_disp = vd;
		disparos_simultaneos = ds;
	}
	
	public int getResistencia() 
	{
		return resistencia;
	}
	
	public int getVel_mov() 
	{
		return vel_mov;
	}
	
	public int getVel_disp() 
	{
		return vel_disp;
	}
	
	public int getDisparos_simultaneos() 
	{
		return disparos_simultaneos;
	}
	
	public abstract void nueva_pos(Tanque_Jugador t);
	
	public abstract void aumentar_nivel(Tanque_Jugador t);
	
	


}
