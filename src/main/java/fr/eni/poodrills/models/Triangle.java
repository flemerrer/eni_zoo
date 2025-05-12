package fr.eni.poodrills.models;

import java.util.Objects;

public class Triangle extends Shape {
	// Attributs
	private float width;
	private float height;

	// Constructeurs
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// Méthodes
	@Override
	public float computeArea() {
		return getWidth() * getHeight() / 2;
	}

	// Getters et Setters
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Triangle [largeur=" + getWidth() + ", hauteur=" + getHeight() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
				&& Float.floatToIntBits(width) == Float.floatToIntBits(other.width);
	}

}
