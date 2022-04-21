package model;

import enums.ResultadoPreliminar;

public class DiagnosticoColicos {
	ResultadoPreliminar resultado;
	
	public DiagnosticoColicos() {
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
		return "DiagnosticoColicos [resultado=" + resultado + "]";
	}
}

