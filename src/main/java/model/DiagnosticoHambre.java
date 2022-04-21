package model;

import enums.ResultadoPreliminar;

public class DiagnosticoHambre {

	ResultadoPreliminar resultado;
	
	public DiagnosticoHambre() {
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
		return "DiagnosticoHambre [resultado=" + resultado + "]";
	}
}
