package controladores.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controladores.AppController;
import controladores.ListController;
import services.IteratorService;
import services.impl.IteratorServiceImpl;
import utils.ColectionFactoryImpl;
import utils.Colectionfactory;
import utils.EntradaResolver;
import utils.EntradasRequest;

public class ListControllerImpl implements ListController {

	
	EntradaResolver resolver = new EntradaResolver();
	 Colectionfactory factory = new ColectionFactoryImpl();
	 AppController app = new AppControllerImpl();
	 IteratorService service = new IteratorServiceImpl();

	 Scanner sc = new Scanner(System.in);

	 @Override
	 public void inicio() {
	  System.out.println("Has selecionado trabajar con List");
	  System.out.println("�Es correcto?");

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
	    .println("Podemos trabajar con un List autogenerado de 100 elementos" + " o crear una nosotros mismos");
	  System.out.println("�quieres trabajar con el autogenerado?");
	  String entrada = sc.next();

	  if (resolver.IsSiNO(entrada)) {
	   if (entrada.equalsIgnoreCase(EntradasRequest.SI)) {
	    List<Integer> list = factory.crearListadeEnteros();
	    encuesta(list);
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
	  List<Integer> list = new ArrayList<Integer>();
	  System.out.println("Creando una Lista");
	  System.out.println("Introduce un entero que determinara el numero de elementos de la Lista");
	  String in = sc.next();
	  if (resolver.isNumValido(in)) {
	   list = factory.crearListadeEnterosConDimension(Integer.parseInt(in));

	   encuesta(list);
	  } else
	   crearColecionCustomController();

	 }

	 @Override
	 public List<Integer> crearColeccion() {
	  System.out
	    .println("Podemos trabajar con un List autogenerado de 100 elementos" + " o crear una nosotros mismos");
	  System.out.println("�quieres trabajar con el autogenerado?");
	  String entrada = sc.next();

	  if (resolver.IsSiNO(entrada)) {
	   if (entrada.equalsIgnoreCase(EntradasRequest.SI)) {
	    List<Integer> list = factory.crearListadeEnteros();
	    return list;
	   } else {
	    crearColecionCustom();
	   }
	  } else {
	   crearColeccion();
	  }

	  return null;
	 }

	 @Override
	 public List<Integer> crearColecionCustom() {
	  List<Integer> list = new ArrayList<Integer>();
	  System.out.println("Creando una Lista");
	  System.out.println("Introduce un entero que determinara el numero de elementos del mapa");
	  String in = sc.next();
	  if (resolver.isNumValido(in)) {
	   list = factory.crearListadeEnterosConDimension(Integer.parseInt(in));

	   return list;
	  } else
	   crearColecionCustom();
	  return list;
	 }

	 @Override
	 public void verContenido(List<Integer> list) {
	  service.pintar(list);
	  encuesta(list);

	 }

	 @Override
	 public void contieneElemento(List<Integer> list) {
	  System.out.println("Introduce un elemento para buscar coincidencias");
	  String entrada = sc.next();
	  if (resolver.isNumValido(entrada)) {
	   if (service.contieneValor(list, Integer.parseInt(entrada))) {
	    System.out.println(" la clave " + entrada + " esta en el list");

	   } else {
	    System.out.println(" la clave " + entrada + " NO esta en el list");

	   }
	  } else
	   contieneElemento(list);
	  encuesta(list);

	 }

	 @Override
	 public void compararVelocidad(List<Integer> list) {
	  // TODO Auto-generated method stub

	 }

	 @Override
	 public void encuesta(List<Integer> list) {
	  System.out.println("Elige una de las siguientes opciones:");
	  System.out.println("1- volver al inicio");
	  System.out.println("2- Consultar si contiene un valor");
	  System.out.println("3- Comparar con otra coleccion");
	  System.out.println("4- Finalizar Programa");
	  System.out.println("4- Mostrar los datos");
	  String res;
	  if (sc.hasNext())
	   res = sc.nextLine();
	  else
	   res = sc.nextLine();
	  res = res.toUpperCase();
	  System.out.println("---------------" + res + "-----------------");
	  if (resolver.isEntradaEncuesta(res)) {
	   switch (res) {
	   case EntradasRequest.PINTAR:
	    verContenido(list);
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
	    contieneElemento(list);
	    break;

	   }
	  } else
	   encuesta(list);

	 }
	
}
