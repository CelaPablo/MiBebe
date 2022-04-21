package model;

import enums.AccionRecomendada;

public class RecomendacionPreliminar {

	public AccionRecomendada resultado;
	public DiagnosticoHambre hambre;
	public DiagnosticoLesiones lesiones;
	public DiagnosticoAburrimiento aburrimiento;
	public DiagnosticoSuciedadPanial panial;
	public DiagnosticoGases gases;
	public DiagnosticoCansancio cansancio;
	public DiagnosticoTempCorporal tempCorporal;
	
	public RecomendacionPreliminar() {
		hambre = new DiagnosticoHambre();
		lesiones = new DiagnosticoLesiones();
		aburrimiento = new DiagnosticoAburrimiento();
		panial = new DiagnosticoSuciedadPanial();
		gases = new DiagnosticoGases();
		cansancio = new DiagnosticoCansancio();
		tempCorporal = new DiagnosticoTempCorporal();
		resultado = AccionRecomendada.NoDeterminado;
	}

	public AccionRecomendada getResultado() {
		return resultado;
	}

	public void setResultado(AccionRecomendada resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "[\n\t\t\tResultado=" + resultado + ",\n\t\t\tHambre=" + hambre + ",\n\t\t\tLesiones=" + lesiones
				+ ",\n\t\t\tAburrimiento=" + aburrimiento + ",\n\t\t\tPanial=" + panial + ",\n\t\t\tGases=" + gases + ",\n\t\t\tCansancio="
				+ cansancio + ",\n\t\t\tTemp. Corporal=" + tempCorporal + "]\n";
	}
}
