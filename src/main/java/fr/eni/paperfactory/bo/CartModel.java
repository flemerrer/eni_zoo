package fr.eni.paperfactory.bo;

public abstract class CartModel {
    static int id = 0;

    public CartModel() {
        CartModel.id++;
    }

    public abstract boolean equals(int id);
}
