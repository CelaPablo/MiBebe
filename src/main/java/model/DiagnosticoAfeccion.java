package model;

import enums.ResultadoPreliminar;

public class DiagnosticoAfeccion {
	ResultadoPreliminar resultado;
	
	public DiagnosticoAfeccion() {
		resultado = ResultadoPreliminar.NoDeterminado;
	}

	public ResultadoPreliminar getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoPreliminar accion) {
		this.resultado = accion;
	}

	@Override
	public String toString() {
		return "DiagnosticoAfeccion [resultado=" + resultado + "]";
	}
}
