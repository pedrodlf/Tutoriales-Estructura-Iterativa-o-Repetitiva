package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import interfaces.Colectionfactory;

public class ColectionFactoryImpl implements Colectionfactory {

	
	@Override
	public  List<Integer> crearListadeEnteros(){
		List<Integer> resultado = new ArrayList<>();
		
		for(int i = 1;i <=100;i++)resultado.add(i);
		
		
		return resultado;
	} 
	@Override
	public Map<Integer, Integer> crearMapDeEnteros(){
		Map<Integer, Integer> resultado = new HashMap<>();
		
		for(int i = 1;i <=100;i++)resultado.put(i, i);
		
		return resultado;
	}
	
	@Override
	public HashSet<Integer> crearHashSetDeEnteros(){
		HashSet<Integer> resultado = new HashSet<>();
		
		for(int i =1; i<=100;i++)resultado.add(i);
		
		return resultado;
	}
	
}
