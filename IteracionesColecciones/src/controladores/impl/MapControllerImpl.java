package controladores.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controladores.AppController;
import controladores.MapController;
import services.IteratorService;
import services.impl.IteratorServiceImpl;
import utils.ColectionFactoryImpl;
import utils.Colectionfactory;
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
		} else
			inicio();

	}

	@Override
	public void crearColeccionController() {
		System.out
				.println("Podemos trabajar con un Map autogenerado de 100 elementos" + " o crear una nosotros mismos");
		System.out.println("¿quieres trabajar con el autogenerado?");
		String entrada = sc.next();

		if (resolver.IsSiNO(entrada)) {
			if (entrada.equalsIgnoreCase(EntradasRequest.SI)) {
				Map<Integer, Integer> map = factory.crearMapDeEnteros();
				encuesta(map);
			} else {
				crearColecionCustomController();
				;
			}
		} else {
			crearColeccionController();
			;
		}
	}

	@Override
	public void crearColecionCustomController() {
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println("Creando un Mapa");
		System.out.println("inroduce un entero que determinara el numero de elementos del mapa");
		String in = sc.next();
		if (resolver.isNumValido(in)) {
			map = factory.crearMapDeEnterosConDimension(Integer.parseInt(in));

			encuesta(map);
		} else
			crearColecionCustomController();

	}

	@Override
	public Map<Integer, Integer> crearColeccion() {

		System.out
				.println("Podemos trabajar con un Map autogenerado de 100 elementos" + " o crear una nosotros mismos");
		System.out.println("¿quieres trabajar con el autogenerado?");
		String entrada = sc.next();

		if (resolver.IsSiNO(entrada)) {
			if (entrada.equalsIgnoreCase(EntradasRequest.SI)) {
				Map<Integer, Integer> map = factory.crearMapDeEnteros();
				return map;
			} else {
				crearColecionCustom();
			}
		} else {
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
		if (resolver.isNumValido(in)) {
			map = factory.crearMapDeEnterosConDimension(Integer.parseInt(in));

			return map;
		} else
			crearColecionCustom();
		return map;
	}

	@Override
	public void verContenido(Map<Integer, Integer> map) {
		service.pintar(map);
		encuesta(map);
	}

	@Override
	public void contieneElemento(Map<Integer, Integer> map) {
		System.out.println("introduce un elemento para buscar coincidencias");
		String entrada = sc.next();
		if (resolver.isNumValido(entrada)) {
			if (service.contieneValor(map, Integer.parseInt(entrada))) {
				System.out.println(" la clave " + entrada + " esta en el map");

			} else {
				System.out.println(" la clave " + entrada + " NO esta en el map");

			}
		} else
			contieneElemento(map);
		encuesta(map);
	}

	@Override
	public void compararVelocidad(Map<Integer, Integer> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void encuesta(Map<Integer, Integer> map) {
		System.out.println("Elige una de las siguientes opciones:");
		System.out.println("1- volver al inicio");
		System.out.println("2- Consultar si contiene un valor");
		System.out.println("3- Comparar con otra coleccion");
		System.out.println("4- Finalizar Programa");
		System.out.println("4- Mostrar los datos");
		String res;
		if(sc.hasNext()) res = sc.nextLine();
		else res = sc.nextLine();
		res = res.toUpperCase();
		System.out.println("---------------" + res + "-----------------");
		if (resolver.isEntradaEncuesta(res)) {
			switch (res) {
			case EntradasRequest.PINTAR:
				verContenido(map);
				break;
			case EntradasRequest.FINALIZAR_PROGRAMA:
				app.finalizarPrograma();
				break;
			case EntradasRequest.COMPARAR:
				// TODO
				break;
			case EntradasRequest.VOLVER_AL_INICIO:
				app.iniciar();
				break;
			case EntradasRequest.CONTIENE:
				contieneElemento(map);
				break;

			}
		} else
			encuesta(map);

	}

}
