package fr.eni.paperfactory.bo;

public class CartLine {

    int id;
    int quantity;
    float price;
    int cartId;
    Item item = null;

    public Item getItem() {
        return item;
    }

    public int getCart() {
        return id;
    }

    public void setCart(int id) {
        this.id = id;
    }

    public void setId(int i) {
        id = i;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ligne (id=" + id + ")\n" +
                "    Qte : " + quantity + "\n" +
                "    Prix : " + price + "\n" +
                "    Article : " + item.getName() + "\n" +
                item.toString();
    }
}
