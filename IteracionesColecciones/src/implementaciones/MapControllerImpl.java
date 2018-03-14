package implementaciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import interfaces.AppController;
import interfaces.ColecctionController;
import interfaces.Colectionfactory;
import interfaces.IteratorService;
import interfaces.MapController;
import utils.EntradaResolver;
import utils.EntradasRequest;

public class MapControllerImpl implements MapController {

	EntradaResolver resolver = new EntradaResolver();
	Colectionfactory factory = new ColectionFactoryImpl();
	AppController app = new AppControllerImpl();
	IteratorService service = new IteratorServiceImpl();
			
	Scanner sc = new Scanner(System.in);
	@Override
	public void inicio() {
		System.out.println("Has selecionado trabajar con Map");
		System.out.println("¿Es correcto?");
		
		String entrada = sc.next();
	
		if (resolver.IsSiNO(entrada)) {
			entrada = entrada.toUpperCase();
			switch (entrada) {
			case EntradasRequest.SI:
				crearColeccionController();
				break;
			case EntradasRequest.NO:
				app.iniciar();
				break;

			}
		}else inicio();

	}
	@Override
	public void crearColeccionController() {
		System.out.println("Podemos trabajar con un Map autogenerado de 100 elementos"
				+" o crear una nosotros mismos");
					System.out.println("¿quieres trabajar con el autogenerado?");
					String entrada = sc.next();
					
					if(resolver.IsSiNO(entrada)) {
						if(entrada.equalsIgnoreCase(EntradasRequest.SI)) {
							Map<Integer, Integer> map = factory.crearMapDeEnteros();
							encuesta(map);
						}else {
							crearColecionCustomController();;
						}
					}else {
						crearColeccionController();;
					}}

	@Override
	public void crearColecionCustomController() {
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println("Creando un Mapa");
		System.out.println("inroduce un entero que determinara el numero de elementos del mapa");
		String in = sc.next();
		if(resolver.isNumValido(in)) {
			 map = factory.crearMapDeEnterosConDimension(Integer.parseInt(in));
			
			 encuesta(map);
		}else crearColecionCustomController();
		
	}
	

	@Override
	public Map<Integer, Integer> crearColeccion() {
		
		System.out.println("Podemos trabajar con un Map autogenerado de 100 elementos"
	+" o crear una nosotros mismos");
		System.out.println("¿quieres trabajar con el autogenerado?");
		String entrada = sc.next();
		
		if(resolver.IsSiNO(entrada)) {
			if(entrada.equalsIgnoreCase(EntradasRequest.SI)) {
				Map<Integer, Integer> map = factory.crearMapDeEnteros();
				return map;
			}else {
				crearColecionCustom();
			}
		}else {
			crearColeccion();
		}
		
		return null;

	}
	
	@Override
	public Map<Integer, Integer> crearColecionCustom() {
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println("Creando un Mapa");
		System.out.println("inroduce un entero que determinara el numero de elementos del mapa");
		String in = sc.next();
		if(resolver.isNumValido(in)) {
			 map = factory.crearMapDeEnterosConDimension(Integer.parseInt(in));
			
			 return map;
		}else crearColecionCustom();
		return map;
	}

	@Override
	public void verContenido(Map<Integer, Integer> map) {
		service.pintar(map);
		
	}

	@Override
	public boolean ContieneElemento(Map<Integer, Integer> map, int valor) {
		System.out.println("introduce un elemento para buscar coincidencias");
		String entrada = sc.next();
		if(resolver.isNumValido(entrada)){
			if(service.contieneValor(map, valor)) {
			System.out.println(" la clave "+valor+" esta en el map");
			return true;
			}else {
				System.out.println(" la clave "+valor+" NO esta en el map");
				return false;
			}
		}else ContieneElemento(map, valor);
		return false;
	}

	@Override
	public void compararVelocidad(Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encuesta(Map<Integer, Integer> map) {
		System.out.println("Elige una de las siguientes opciones:");
		System.out.println("1- volver al inicio");
		System.out.println("2- Cosultar si contiene un valor");
		System.out.println("3- Comparar con otra coleccion");
		System.out.println("4- Finalizar programa");
		
		
	}

	

	



}
