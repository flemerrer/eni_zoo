package fr.eni.poodrills.models;

public class Rectangle extends Shape {

    public Rectangle(int width, int height) {
        super(width, height);
    }

    public Rectangle() {
    }

    @Override
    public String toString() {
        return "Rectangle [largeur=" + getWidth() + ", hauteur=" + getHeight() + "]";
    }

    @Override
    public float computeArea() {
        return getWidth() * getHeight();
    }
}
