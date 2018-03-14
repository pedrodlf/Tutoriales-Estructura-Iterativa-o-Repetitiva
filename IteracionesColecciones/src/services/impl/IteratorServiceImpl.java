package services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import services.IteratorService;

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

	@Override
	public void pintar(List<Integer> entrada) {
		System.out.println("Pintando lista de "+entrada.size()+" elementos");
		entrada.forEach(i -> System.out.println("posicion "+i+" = "+i));
		
	}

	@Override
	public void pintar(Map<Integer, Integer> entrada) {
		System.out.println("Pintando Map de "+entrada.size()+ " elementos");
		entrada.forEach((k,v) -> System.out.println("Map<\""+k+"\","+v+">"));
		
	}

	@Override
	public void pintar(HashSet<Integer> entrada) {
		System.out.println("Pintando HasSet de "+entrada.size()+" elementos");
		entrada.forEach(i -> System.out.println("posicion "+i+" = "+i));
		
	}

}
