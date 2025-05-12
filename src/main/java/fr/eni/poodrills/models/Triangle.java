package fr.eni.poodrills.models;

import java.util.Objects;

public class Triangle extends Shape {

	public Triangle(int width, int height) {
		super(width, height);
	}

	public Triangle() {
	}

	@Override
	public float computeArea() {
		return getWidth() * getHeight() / 2;
	}

	@Override
	public String toString() {
		return "Triangle [largeur=" + getWidth() + ", hauteur=" + getHeight() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(getHeight(), getWidth());
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
		return Float.floatToIntBits(getHeight()) == Float.floatToIntBits(other.getHeight())
				&& Float.floatToIntBits(getWidth()) == Float.floatToIntBits(other.getWidth());
	}

}
