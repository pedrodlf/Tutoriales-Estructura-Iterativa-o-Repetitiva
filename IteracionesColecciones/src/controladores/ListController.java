package controladores;

import java.util.List;

public interface ListController extends ColecctionController {

	public void crearColeccionController();
	 public void crearColecionCustomController();
	 public List<Integer> crearColeccion();
	 public List<Integer> crearColecionCustom();
	 public void verContenido(List<Integer> list);
	 public void contieneElemento(List<Integer> list);
	 public void compararVelocidad(List<Integer> list);
	 public void encuesta(List<Integer> list);
	
	
}
