package fr.eni.paperfactory.bo;

public class PaperBundle extends Item {

    private int grain;

    public PaperBundle(String model, String brand, String name, float price, int grain) {
        super(model, brand, name, price);
        this.grain = grain;
    }

    public int getGrain() {
        return grain;
    }

    public void setGrain(int grain) {
        this.grain = grain;
    }

    @Override
    public String toString() {
        return "        Grammage : " + getGrain() + "\n" + super.toString();
    }
}
