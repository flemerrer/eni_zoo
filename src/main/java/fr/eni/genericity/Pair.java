package fr.eni.genericity;

public class Pair<T, T1> {

    T a;
    T1 b;

    public Pair(T a, T1 b) {
        this.a = a;
        this.b = b;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T1 getB() {
        return b;
    }

    public void setB(T1 b) {
        this.b = b;
    }

    public void setFirst(T element) {
        setA(element);
    }

    @Override
    public String toString() {
        return "(" + getA() + ", " + getB() + ")";
    }
}
