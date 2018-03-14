package interfaces;

import java.util.Map;

public interface MapController extends ColecctionController {
	
	public void crearColeccionController();
	public void crearColecionCustomController();
	public Map<Integer, Integer> crearColeccion();
	public Map<Integer, Integer> crearColecionCustom();
	public void verContenido(Map<Integer, Integer> map);
	public boolean ContieneElemento(Map<Integer, Integer> map, int valor);
	public void compararVelocidad(Map<Integer, Integer> map);
	public void encuesta(Map<Integer, Integer> map);
	
	
}
