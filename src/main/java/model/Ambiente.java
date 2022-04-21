package model;

import enums.NivelAmbiente;

public class Ambiente {

	NivelAmbiente nivel;

	public Ambiente(NivelAmbiente nivel) {
		super();
		this.nivel = nivel;
	}
	
	public Ambiente() {
		super();
		this.nivel = NivelAmbiente.Normal;
	}

	public NivelAmbiente getNivel() {
		return nivel;
	}

	public void setNivel(NivelAmbiente nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "[nivel=" + nivel + "]";
	}
}
