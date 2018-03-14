package implementaciones;

import java.util.Map;
import java.util.Scanner;

import interfaces.AppController;
import interfaces.ColecctionController;
import interfaces.Colectionfactory;
import interfaces.MapController;
import utils.EntradaResolver;
import utils.EntradasRequest;

public class MapControllerImpl implements MapController {

	EntradaResolver resolver = new EntradaResolver();
	AppController app = new AppControllerImpl();
	Scanner sc = new Scanner(System.in);
	@Override
	public void inicio() {
		System.out.println("Has selecionado trabajar con Map");
		System.out.println("�Es correcto?");
		
		String entrada = sc.next();
	
		if (resolver.IsSiNO(entrada)) {
			entrada = entrada.toUpperCase();
			switch (entrada) {
			case EntradasRequest.SI:
				crearColeccion();
				break;
			case EntradasRequest.NO:
				app.iniciar();
				break;

			}
		}else inicio();

	}

	@Override
	public void crearColeccion() {
		Colectionfactory factory = new ColectionFactoryImpl();
		System.out.println("Podemos trabajar con un Map autogenerado de 100 elementos"
	+" o crear una nosotros mismos");
		System.out.println("�quieres trabajar con el autogenerado?");
		String entrada = sc.next();
		
		if(resolver.IsSiNO(entrada)) {
			if(entrada.equalsIgnoreCase(EntradasRequest.SI)) {
				Map<Integer, Integer> map = factory.crearMapDeEnteros();
				encuesta(map);
			}else {
				System.out.println("Creando un Mapa");
				System.out.println("inroduce un entero que determinara eol numero de elementos del mapa");
				String in = sc.next();
			}
		}else {
			crearColeccion();
		}
		
		

	}

	@Override
	public void verContenido(Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ContieneElemento(Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void compararVelocidad(Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encuesta(Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
	}



}
