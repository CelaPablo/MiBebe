package model;

import enums.ResultadoPreliminar;

public class DiagnosticoAburrimiento {
	ResultadoPreliminar resultado;
	
	public DiagnosticoAburrimiento() {
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
		return "DiagnosticoAburrimiento [resultado=" + resultado + "]";
	}
}
