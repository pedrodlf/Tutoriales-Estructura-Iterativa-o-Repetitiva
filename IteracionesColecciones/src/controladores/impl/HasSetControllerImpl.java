package controladores.impl;

import java.util.HashSet;

import java.util.Scanner;

import controladores.AppController;
import controladores.HasSetController;
import services.IteratorService;
import services.impl.IteratorServiceImpl;
import utils.ColectionFactoryImpl;
import utils.Colectionfactory;
import utils.EntradaResolver;
import utils.EntradasRequest;

public class HasSetControllerImpl implements HasSetController {

	EntradaResolver resolver = new EntradaResolver();
	Colectionfactory factory = new ColectionFactoryImpl();
	AppController app = new AppControllerImpl();
	IteratorService service = new IteratorServiceImpl();

	Scanner sc = new Scanner(System.in);

	@Override
	public void inicio() {
		System.out.println("Has selecionado trabajar con HasSet");
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
		System.out.println(
				"Podemos trabajar con un HasSet autogenerado de 100 elementos" + " o crear una nosotros mismos");
		System.out.println("¿quieres trabajar con el autogenerado?");
		String entrada = sc.next();

		if (resolver.IsSiNO(entrada)) {
			if (entrada.equalsIgnoreCase(EntradasRequest.SI)) {
				HashSet<Integer> has = factory.crearHashSetDeEnteros();
				encuesta(has);
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
		HashSet<Integer> has = new HashSet<>();
		System.out.println("Creando un Mapa");
		System.out.println("inroduce un entero que determinara el numero de elementos del Hasset");
		String in = sc.next();
		if (resolver.isNumValido(in)) {
			has = factory.crearHashSetDeEnterosConDimension(Integer.parseInt(in));

			encuesta(has);
		} else
			crearColecionCustomController();

	}

	@Override
	public HashSet<Integer> crearColeccion() {
		System.out.println(
				"Podemos trabajar con un HasSet autogenerado de 100 elementos" + " o crear una nosotros mismos");
		System.out.println("¿quieres trabajar con el autogenerado?");
		String entrada = sc.next();

		if (resolver.IsSiNO(entrada)) {
			if (entrada.equalsIgnoreCase(EntradasRequest.SI)) {
				HashSet<Integer> has = factory.crearHashSetDeEnteros();
				return has;
			} else {
				crearColecionCustom();
			}
		} else {
			crearColeccion();
		}

		return null;

	}

	@Override
	public HashSet<Integer> crearColecionCustom() {
		HashSet<Integer> has = new HashSet<>();
		System.out.println("Creando un Mapa");
		System.out.println("inroduce un entero que determinara el numero de elementos del HasSet");
		String in = sc.next();
		if (resolver.isNumValido(in)) {
			has = factory.crearHashSetDeEnterosConDimension(Integer.parseInt(in));

			return has;
		} else
			crearColecionCustom();
		return null;
	}

	@Override
	public void verContenido(HashSet<Integer> has) {
		service.pintar(has);
		encuesta(has);

	}

	@Override
	public void contieneElemento(HashSet<Integer> has) {
		System.out.println("introduce un elemento para buscar coincidencias");
		String entrada = sc.next();
		if (resolver.isNumValido(entrada)) {
			if (service.contieneValor(has, Integer.parseInt(entrada))) {
				System.out.println( entrada + " esta en el map");

			} else {
				System.out.println( entrada + " NO esta en el HasMap");

			}
		} else
			contieneElemento(has);
		encuesta(has);
	}

	@Override
	public void compararVelocidad(HashSet<Integer> has) {
		// TODO Auto-generated method stub

	}

	@Override
	public void encuesta(HashSet<Integer> has) {
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
				verContenido(has);
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
				contieneElemento(has);
				break;

			}
		} else
			encuesta(has);

	}

}
