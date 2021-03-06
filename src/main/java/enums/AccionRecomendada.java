package enums;

public enum AccionRecomendada {
	NoDeterminado,
	AlimentarAlBebe,
	DarAtencionAlBebe,
	ConsolarAlBebe,
	CambiarPaĆ±alDelBebe,
	EjercitarPiernasDelBebe,
	HacerDormirAlBebe,
	SacarAbrigoDelBebe,
	PonerAbrigoAlBebe,
	FrotarYenfriarEncias,
	ConsultarPediatra;
	
	public Boolean isa(AccionRecomendada recomendacion) {
		return this.toString() == recomendacion.toString();
	}
}
