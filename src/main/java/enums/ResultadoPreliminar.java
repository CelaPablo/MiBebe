package enums;

public enum ResultadoPreliminar {
	NoDeterminado,
	BebeConHambre,
	BebeSinHambre,
	BebeLastimado,
	BebeConRasgunio,
	BebeAburrido,
	BebeSucio,
	BebeConGases,
	BebeConSuenio,
	BebeSinSuenio,
	BebeConCalor,
	BebeConFrio,
	
	SaliendoDientes,
	ConColicos,
	ConEnfermedad;
	
	public Boolean isa(ResultadoPreliminar resultado) {
		return this.toString() == resultado.toString();
	}
}
