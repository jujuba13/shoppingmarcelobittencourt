package util;

public class Funcoes {
	
	public static Double removeCifraoDevolveDouble(String texto) {
		texto = texto.replace("$", "");
		return Double.parseDouble(texto);
		
	}
public static int removeTextoItemDevolveInt(String texto) {
	texto = texto.replace(" items", "");
	return Integer.parseInt(texto);
}
}
