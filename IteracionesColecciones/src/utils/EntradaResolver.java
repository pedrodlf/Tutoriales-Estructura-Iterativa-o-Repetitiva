package utils;

public class EntradaResolver {

	private String entrada;

	public EntradaResolver(String entrada) {

		this.entrada = entrada;
	}

	public EntradaResolver() {
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public boolean IsEntrada(String in) {
		String uper = in.toUpperCase();
		if (uper.equals(EntradasRequest.HASSET) || uper.equals(EntradasRequest.LIST)
				|| uper.equals(EntradasRequest.MAP))
			return true;

		else
			System.out.println("la opcion selecionada no es correcta ");

		return false;

	}
	
	public boolean IsSiNO(String in) {
		String uper = in.toUpperCase();
		if(uper.equals(EntradasRequest.SI)|| uper.equals(EntradasRequest.NO))
			return true;
		else System.out.println("la opcion selecionada no es correcta responde si o no ");
			return false;
	}
	
	public boolean isNumValido(String in) {
		
		try {
			int a = Integer.parseInt(in);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("El valor introducido no es correcto ");
		}
		return false;
	}
	
	

}
