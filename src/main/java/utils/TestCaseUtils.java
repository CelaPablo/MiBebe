package utils;

import enums.AccionRecomendada;
import model.Ambiente;
import model.Bebe;
import model.Recomendacion;

public class TestCaseUtils {
	public static void print(String title) {
		System.out.println(title);
	}

	public static void print() {
		print("");
	}

	public static void print(Bebe bebe, Ambiente ambiente) {
		print("DATOS:");
		print("Bebe: " + bebe);
		print("Ambiente: " + ambiente);
		print();
	}

	public static void assertResults(Recomendacion recomendacion, AccionRecomendada valorEsperado) {
		AccionRecomendada accion = recomendacion.getAccion();
		printResults(accion.toString(), valorEsperado.toString());
		assert(accion.isa(valorEsperado));
	}

	private static void printResults(String result,String expected) {
		print("\n\tResultados");
		print("Esperado: " + expected);
		print("Recibido: " + result);
		Boolean isOk = result.equals(expected);
		String condition = isOk ? "Ok" : "Fallo";
		print("Caso de prueba: "+ condition);
	}
}
