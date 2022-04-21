package model;

public class Pañal {
	private boolean presentaHumedad, presentaHeces;

	public Pañal(boolean presentaHumedad, boolean presentaHeces) {
		this.presentaHumedad = presentaHumedad;
		this.presentaHeces = presentaHeces;
	}

	public boolean isPresentaHumedad() {
		return presentaHumedad;
	}

	public void setPresentaHumedad(boolean presentaHumedad) {
		this.presentaHumedad = presentaHumedad;
	}

	public boolean isPresentaHeces() {
		return presentaHeces;
	}

	public void setPresentaHeces(boolean presentaHeces) {
		this.presentaHeces = presentaHeces;
	}

	@Override
	public String toString() {
		return "[presentaHumedad=" + presentaHumedad + ", presentaHeces=" + presentaHeces + "]";
	}	
}
