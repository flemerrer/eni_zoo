package fr.eni.poodrills.models;

public class Rectangle extends Shape {
    // Attributs
    private float width;
    private float height;

    // Constructeurs
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
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

    @Override
    public String toString() {
        return "Rectangle [largeur=" + getWidth() + ", hauteur=" + getHeight() + "]";
    }

    @Override
    public float computeArea() {
        return getWidth() * getHeight();
    }
}
