package enums;

public enum NivelAmbiente {
	Frio,
	Normal,
	Caliente;
	
	public Boolean isa(NivelAmbiente recomendacion) {
		return this.toString() == recomendacion.toString();
	}
}
