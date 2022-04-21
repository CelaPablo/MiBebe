package model;

import enums.ResultadoPreliminar;

public class DiagnosticoCansancio {
	ResultadoPreliminar resultado;
	
	public DiagnosticoCansancio() {
		resultado = ResultadoPreliminar.NoDeterminado;
	}

	public ResultadoPreliminar getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoPreliminar resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "DiagnosticoCansancio [resultado=" + resultado + "]";
	}
}
