package fr.eni.paperfactory.bo;

public class Pen extends Item {
    private String color;

    public Pen(String model, String brand, String name, float price, String color) {
        super(model, brand, name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "        Couleur : " + getColor() + "\n" + super.toString();
    }
}
