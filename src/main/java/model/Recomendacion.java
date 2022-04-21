package model;

import enums.AccionRecomendada;

public class Recomendacion {

	public AccionRecomendada accion;
	public RecomendacionPreliminar preliminar;
	public DiagnosticoColicos colicos;
	public DiagnosticoAfeccion afeccion;
	public DiagnosticoDientes dientes;
	
	public Recomendacion() {
		accion = AccionRecomendada.NoDeterminado;
		preliminar = new RecomendacionPreliminar();
		colicos = new DiagnosticoColicos();
		afeccion = new DiagnosticoAfeccion();
		dientes = new DiagnosticoDientes();
	}

	public AccionRecomendada getAccion() {
		return accion;
	}

	public void setAccion(AccionRecomendada accion) {
		this.accion = accion;
	}
	
	@Override
	public String toString() {
		return "Diagnosticos["
				+ "\n\t\t Diagnostico Preliminar=" + preliminar + "\t\t Diagnostico Colicos=" + colicos
				+ ",\n\t\t Diagnostico Afeccion=" + afeccion + ",\n\t\t Diagnostico Dientes=" + dientes
				+ "]\n\t\t Recomendacion Final: " + accion + "\n\t]";
	}
}
