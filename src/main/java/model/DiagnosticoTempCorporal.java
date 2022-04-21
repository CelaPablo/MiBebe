package model;

import enums.ResultadoPreliminar;

public class DiagnosticoTempCorporal {
	ResultadoPreliminar resultado;
	
	public DiagnosticoTempCorporal() {
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
		return "DiagnosticoTempCorporal [resultado=" + resultado + "]";
	}
}
