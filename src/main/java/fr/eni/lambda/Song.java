package fr.eni.lambda;


import java.util.Collections;
import java.util.Comparator;

public class Song {
    private String title;
    private String singer;
    private double duration;

    public Song() {
    }

    public Song(String title, String singer, double duration) {
        super();
        this.title = title;
        this.singer = singer;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format(singer + ": " + title + " - " + duration + " min");
    }

}
