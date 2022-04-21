package model;

import enums.ResultadoPreliminar;

public class DiagnosticoGases {
	ResultadoPreliminar resultado;
	
	public DiagnosticoGases() {
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
		return "DiagnosticoGases [resultado=" + resultado + "]";
	}
}
