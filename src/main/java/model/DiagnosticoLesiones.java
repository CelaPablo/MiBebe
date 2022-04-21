package model;

import enums.ResultadoPreliminar;

public class DiagnosticoLesiones {
	ResultadoPreliminar resultado;
	
	public DiagnosticoLesiones() {
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
		return "DiagnosticoLesiones [resultado=" + resultado + "]";
	}
}
