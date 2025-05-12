package fr.eni.poodrills.models;

public abstract class Shape {

	private float width;
	private float height;

	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Shape() {
	}

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

	public float computeArea() {
		return 0;
	}
	
}
