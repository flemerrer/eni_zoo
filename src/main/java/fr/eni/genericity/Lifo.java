package fr.eni.genericity;

import java.util.ArrayList;
import java.util.List;

public class Lifo<T> {

    List<T> list = new ArrayList<T>();

    public void add(T element) {
        list.add(element);
    }

    public void remove() {
        list.removeLast();
    }

    public boolean getStack() {
        return !list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        list.forEach(str::append);
        return str.toString();
    }
}
