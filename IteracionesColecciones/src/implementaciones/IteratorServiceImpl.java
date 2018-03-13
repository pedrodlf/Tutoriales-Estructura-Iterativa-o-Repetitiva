package implementaciones;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import interfaces.IteratorService;

public class IteratorServiceImpl implements IteratorService {

	@Override
	public boolean contieneValor(List<Integer> entrada, int valor) {
		for (Integer integer : entrada) {
			if(integer == valor) return true;
		}
		return false;
	}

	@Override
	public boolean contieneValor(Map<Integer, Integer> entrada, int valor) {
		if(entrada.containsKey(valor))return true;
		else return false;
	}

	@Override
	public boolean contieneValor(HashSet<Integer> entrada, int valor) {
		if(entrada.add(valor)) return true;
		else return false;
	}

}
