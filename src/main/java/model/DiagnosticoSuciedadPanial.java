package model;

import enums.ResultadoPreliminar;

public class DiagnosticoSuciedadPanial {
	ResultadoPreliminar resultado;
	
	public DiagnosticoSuciedadPanial() {
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
		return "DiagnosticoSuciedadPanial [resultado=" + resultado + "]";
	}
}
