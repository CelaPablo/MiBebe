package enums;

public enum NivelBaba {
	NoDeterminado,
	Bajo,
	Medio,
	Alto;
	
	public Boolean isa(NivelBaba recomendacion) {
		return this.toString() == recomendacion.toString();
	}
}
