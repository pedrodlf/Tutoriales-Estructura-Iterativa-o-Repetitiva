package controladores;

import java.util.HashSet;

public interface HasSetController extends ColecctionController{

	
	public void crearColeccionController();
	public void crearColecionCustomController();
	public HashSet<Integer> crearColeccion();
	public HashSet<Integer> crearColecionCustom();
	public void verContenido(HashSet<Integer> has);
	public void contieneElemento(HashSet<Integer> has);
	public void compararVelocidad(HashSet<Integer> has);
	public void encuesta(HashSet<Integer> has);
	
}
