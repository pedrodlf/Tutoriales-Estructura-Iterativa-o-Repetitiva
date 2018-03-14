package interfaces;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface Colectionfactory {

	public List<Integer> crearListadeEnteros();

	public Map<Integer, Integer> crearMapDeEnteros();

	public HashSet<Integer> crearHashSetDeEnteros();

	public List<Integer> crearListadeEnterosConDimension(int numeroDeElementos);

	public Map<Integer, Integer> crearMapDeEnterosConDimension(int numeroDeElementos);

	public HashSet<Integer> crearHashSetDeEnterosConDimension(int numeroDeElementos);

}
