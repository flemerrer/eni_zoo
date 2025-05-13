package fr.eni.turtlesrace;

public class Turtle implements Comparable<Turtle> {

    private int id;
    private String name;
    private double finishTime;

    public Turtle(int id, String name, double finishTime) {
        this.id = id;
        this.name = name;
        this.finishTime = finishTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Turtle t) {
        return Double.compare(this.finishTime, t.finishTime);
    }

}
