package fr.eni.paperfactory.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart extends CartModel {

    int id;
    float totalPrice;
    List<CartLine> lines =  new ArrayList<CartLine>();

    public Cart() {
        super();
        id = CartModel.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        totalPrice = lines.stream().map(CartLine::getPrice).reduce(Float::sum).orElse(0f);
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartLine> getLines() {
        return lines;
    }

    public void setLines(List<CartLine> lines) {
        this.lines = lines;
    }

    public void addLine(CartLine line) {
        line.setCart(this.getId());
        this.lines.add(line);
    }

    @Override
    public String toString() {
        return "Panier (id="+getId()+")\n"+
                "Montant Total : " + getTotalPrice() + "\n" +
                "Lignes :" + printLines();
    }

    private String printLines() {
        return "\n- "+lines.stream().map(CartLine::toString).collect(Collectors.joining("\n- "));
    }

    @Override
    public boolean equals(int id) {
        return getId() == id;
    }
}
