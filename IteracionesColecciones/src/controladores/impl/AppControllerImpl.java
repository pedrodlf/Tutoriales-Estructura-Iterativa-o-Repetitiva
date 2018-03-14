package controladores.impl;

import java.util.Scanner;

import controladores.AppController;
import controladores.ColecctionController;
import utils.EntradaResolver;
import utils.EntradasRequest;

public class AppControllerImpl implements AppController {

	
	EntradaResolver resolver = new EntradaResolver();

	@Override
	public void iniciar() {
		
		System.out.println("¿Que tipo de coleccion quieres testear?");
		System.out.println("1-Map");
		System.out.println("2-List");
		System.out.println("3-HasSet");
		Scanner sc = new Scanner(System.in);
		String entrada = sc.next();
	
		if (resolver.IsEntrada(entrada)) {
			entrada = entrada.toUpperCase();
			switch (entrada) {
			case EntradasRequest.HASSET:
				analizarHasSet();
				break;
			case EntradasRequest.LIST:
				analizarList();
				break;
			case EntradasRequest.MAP:
				analizarMap();
				break;
			}
		} else
			iniciar();
	}

	@Override
	public void analizarMap() {
		ColecctionController controller = new MapControllerImpl();
		controller.inicio();
	}

	@Override
	public void analizarList() {
		ColecctionController controller = null;
		controller.inicio();
	}

	@Override
	public void analizarHasSet() {
		ColecctionController controller = null;
		controller.inicio();
	}

	@Override
	public void finalizarPrograma() {
		System.out.println("----------- FIN DE PROGRAMA----------------");
		System.exit(0);
		
	}

}
