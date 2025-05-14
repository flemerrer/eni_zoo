package fr.eni.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.eni.lambda.Song;

public class LambdaExpressionTest {

    public static void main(String[] args) {
        List<Song> songs = new ArrayList<Song>(List.of(new Song("Space Oddity", "David Bowie", 5.17),
                new Song("Paint It, Black", "The Rolling Stones", 3.22),
                new Song("Smoke On The Water", "Deep Purple", 5.40),
                new Song("Cocaine", "Eric Clapton", 3.36),
                new Song("Englishman In New York", "Sting", 4.26),
                new Song("Mojo", "M", 3.16),
                new Song("Battez-vous", "Brigitte", 4.04),
                new Song("Frida", "Sanseverino", 4.08),
                new Song("Demons", "Imagine Dragons", 2.57),
                new Song("Supersonic", "Oasis", 4.44),
                new Song("Boulevard of Broken Dreams", "Green Day", 4.21),
                new Song("Come Out and Play", "The Offspring", 3.17),
                new Song("Under the Bridge", "Red Hot Chili Peppers", 4.25),
                new Song("Come As You Are", "Nirvana", 3.38),
                new Song("Nothing Else Matters", "Metallica", 6.28),
                new Song("Sympathy For The Devil", "Motorhead", 5.26),
                new Song("You Really Got Me", "Van Halen", 2.36),
                new Song("Knockin' On Heaven's Door", "Guns N' Roses", 5.36)));

        //Enoncés
        // Afficher la liste des chansons (titre + duree)

        System.out.println("*".repeat(10));
        songs.forEach(s -> System.out.println(s.getSinger() + ": " + s.getTitle()));

        // Trier la liste des chansons par ordre alphabétique
/*
        songs.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        */

        songs.sort((s1, s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle()));

        // Afficher la liste des chansons (toString)

        System.out.println("\n" + "*".repeat(10));
        songs.forEach(System.out::println);
        // Supprimer les chansons trop longues (>5 minutes)

        songs.removeIf(s -> s.getDuration() > 5);

        // Trier la liste des chansons par durée croissante

        List<Song> sortedList = songs.stream().sorted((s1, s2) -> {
                    if (s1.getDuration() == s2.getDuration()) {
                        return 0;
                    } else if (s1.getDuration() < s2.getDuration()) {
                        return 1;
                    }
                    return -1;
                }
        ).toList();

        System.out.println("\n" + "*".repeat(10));
        sortedList.forEach(System.out::println);

    }

}
