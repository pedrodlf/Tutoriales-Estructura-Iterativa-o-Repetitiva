package interfaces;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface IteratorService {
	
	public boolean contieneValor(List<Integer> entrada,int valor);
	public boolean contieneValor(Map<Integer, Integer> entrada,int valor);
	public boolean contieneValor(HashSet<Integer> entrada, int valor);
	
	
	
	
	

}
