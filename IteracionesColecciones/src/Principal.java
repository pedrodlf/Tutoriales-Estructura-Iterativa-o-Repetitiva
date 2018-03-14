


import controladores.AppController;
import controladores.impl.AppControllerImpl;

public class Principal {

	
	
	public static void main(String[] args) {
		AppController controller = new AppControllerImpl();
		System.out.println("--------INICIO DEL TESTEADOR DE COLECCIONES------------");
		controller.iniciar();
		
		

	}

}
