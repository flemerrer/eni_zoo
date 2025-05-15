package fr.eni.paperfactory.bo;

public abstract class Item {
    private String model;
    private String brand;
    private String name;
    private float price;
    private int id;

    public Item(Integer id, String model, String brand, String name, float price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "        Référence : " + getModel() + "\n" +
               "        Marque : " + getBrand() + "\n" +
               "        Désignation : " + getName() + "\n" +
               "        Prix unitaire : " + getPrice();
    }

    public void setId(int i) {
        this.id = i;
    }

    public boolean equals(Integer id) {
        return this.id == id;
    }
}
