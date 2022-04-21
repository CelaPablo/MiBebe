package model;


import enums.ResultadoPreliminar;

public class DiagnosticoDientes {
	ResultadoPreliminar resultado;
	
	public DiagnosticoDientes() {
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
		return "DiagnosticoDientes [resultado=" + resultado + "]";
	}
}
