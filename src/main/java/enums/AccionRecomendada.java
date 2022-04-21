package enums;

public enum AccionRecomendada {
	NoDeterminado,
	AlimentarAlBebe,
	DarAtencionAlBebe,
	ConsolarAlBebe,
	CambiarPañalDelBebe,
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
