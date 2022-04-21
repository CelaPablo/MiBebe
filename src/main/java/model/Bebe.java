package model;

import enums.NivelBaba;

public class Bebe {
	public Pañal pañal;
	public int alimentoIngerido;
	public boolean zonaColorada, marcaRoja, desvelado;
	public boolean movimientoIntensoPiernas, estaCaliente;
	public boolean malaReaccionTacto, conErupciones, conInflamacion;
	public NivelBaba nivelBaba;
	public float ultimaSiesta, tempCorporal;
	public Recomendacion recomendacion;
	
	public Bebe() {
		this.pañal = new Pañal(false, false);
		this.alimentoIngerido = 0;
		this.zonaColorada = false;
		this.marcaRoja = false;
		this.desvelado = false;
		this.movimientoIntensoPiernas = false;
		this.estaCaliente = false;
		this.malaReaccionTacto = false;
		this.conErupciones = false;
		this.conInflamacion = false;
		this.nivelBaba = NivelBaba.NoDeterminado;
		this.ultimaSiesta = 0;
		this.tempCorporal = 0;
		recomendacion = new Recomendacion();
	}
	
	public Bebe(int alimentoIngerido, boolean zonaColorada, boolean marcaRoja,
			boolean desvelado, boolean movimientoIntensoPiernas, boolean estaCaliente,
			boolean malaReaccionTacto, boolean conErupciones, boolean conInflamacion,
			NivelBaba baba, float ultimaSiesta, float tempCorporal,boolean panS, boolean panH) {
		this.pañal = new Pañal(panH, panS);
		this.alimentoIngerido = alimentoIngerido;
		this.zonaColorada = zonaColorada;
		this.marcaRoja = marcaRoja;
		this.desvelado = desvelado;
		this.movimientoIntensoPiernas = movimientoIntensoPiernas;
		this.estaCaliente = estaCaliente;
		this.malaReaccionTacto = malaReaccionTacto;
		this.conErupciones = conErupciones;
		this.conInflamacion = conInflamacion;
		this.nivelBaba = baba;
		this.ultimaSiesta = ultimaSiesta;
		this.tempCorporal = tempCorporal;
		recomendacion = new Recomendacion();
	}
	
	public Recomendacion getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(Recomendacion recomendacion) {
		this.recomendacion = recomendacion;
	}
	public Pañal getPañal() {
		return pañal;
	}
	public void setPañalHeces(boolean heces) {
		this.pañal.setPresentaHeces(heces);
	}
	public void setPañalHumedad(boolean humedad) {
		this.pañal.setPresentaHumedad(humedad);
	}
	public int getAlimentoIngerido() {
		return alimentoIngerido;
	}
	public void setAlimentoIngerido(int alimentoIngerido) {
		this.alimentoIngerido = alimentoIngerido;
	}
	public Boolean getZonaColorada() {
		return zonaColorada;
	}
	public void setZonaColorada(Boolean zonaColorada) {
		this.zonaColorada = zonaColorada;
	}
	public Boolean getMarcaRoja() {
		return marcaRoja;
	}
	public void setMarcaRoja(Boolean marcaRoja) {
		this.marcaRoja = marcaRoja;
	}
	public Boolean getDesvelado() {
		return desvelado;
	}
	public void setDesvelado(Boolean desvelado) {
		this.desvelado = desvelado;
	}
	public Boolean getMovimientoIntensoPiernas() {
		return movimientoIntensoPiernas;
	}
	public void setMovimientoIntensoPiernas(Boolean movimientoIntensoPiernas) {
		this.movimientoIntensoPiernas = movimientoIntensoPiernas;
	}
	public Boolean getEstaCaliente() {
		return estaCaliente;
	}
	public void setEstaCaliente(Boolean estaCaliente) {
		this.estaCaliente = estaCaliente;
	}
	public Boolean getMalaReaccionTacto() {
		return malaReaccionTacto;
	}
	public void setMalaReaccionTacto(Boolean malaReaccionTacto) {
		this.malaReaccionTacto = malaReaccionTacto;
	}
	public Boolean getConErupciones() {
		return conErupciones;
	}
	public void setConErupciones(Boolean conErupciones) {
		this.conErupciones = conErupciones;
	}
	public Boolean getConInflamacion() {
		return conInflamacion;
	}
	public void setConInflamacion(Boolean conInflamacion) {
		this.conInflamacion = conInflamacion;
	}
	public NivelBaba getNivelBaba() {
		return nivelBaba;
	}
	public void setNivelBaba(NivelBaba nivelBaba) {
		this.nivelBaba = nivelBaba;
	}
	public float getUltimaSiesta() {
		return ultimaSiesta;
	}
	public void setUltimaSiesta(float ultimaSiesta) {
		this.ultimaSiesta = ultimaSiesta;
	}
	public float getTempCorporal() {
		return tempCorporal;
	}
	public void setTempCorporal(float tempCorporal) {
		this.tempCorporal = tempCorporal;
	}

	@Override
	public String toString() {
		return "Bebe ["
				+ "\n\tPañal=" + pañal + ",\n\tAlimento Ingerido=" + alimentoIngerido + ",\n\tZona Colorada=" + zonaColorada
				+ ",\n\tMarca Roja=" + marcaRoja + ",\n\tDesvelado=" + desvelado + ",\n\tMovimiento Intenso Piernas="
				+ movimientoIntensoPiernas + ",\n\tEsta Caliente=" + estaCaliente + ",\n\tMala Reaccion Tacto="
				+ malaReaccionTacto + ",\n\tCon Erupciones=" + conErupciones + ",\n\tCon Inflamacion=" + conInflamacion
				+ ",\n\tNivel Baba=" + nivelBaba + ",\n\tUltima Siesta=" + ultimaSiesta + ",\n\tTemp. Corporal=" + tempCorporal
				+ ",\n\tRecomendacion=" + recomendacion + "\n]";
	}
}
