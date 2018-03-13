package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ColectionFactory {

	
	
	public static List<Integer> crearListadeEnteros(){
		List<Integer> resultado = new ArrayList<>();
		
		for(int i = 1;i <=100;i++)resultado.add(i);
		
		
		return resultado;
	} 
	
	public static Map<Integer, Integer> crearMapDeEnteros(){
		Map<Integer, Integer> resultado = new HashMap<>();
		
		for(int i = 1;i <=100;i++)resultado.put(i, i);
		
		return resultado;
	}
	
	public static HashSet<Integer> crearHashSetDeEnteros(){
		HashSet<Integer> resultado = new HashSet<>();
		
		for(int i =1; i<=100;i++)resultado.add(i);
		
		return resultado;
	}
	
}
