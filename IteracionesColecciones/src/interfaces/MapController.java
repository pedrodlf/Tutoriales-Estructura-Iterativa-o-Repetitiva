package interfaces;

import java.util.Map;

public interface MapController extends ColecctionController {

	public void verContenido(Map<Integer, Integer> map);
	public boolean ContieneElemento(Map<Integer, Integer> map);
	public void compararVelocidad(Map<Integer, Integer> map);
	public void encuesta(Map<Integer, Integer> map);
	
	
}
