package com.application.amrudesh.jokejava;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class MyClass {
    List<String> myJokes = asList(
            "What do you call cheese that’s not yours? It’s nacho cheese.",
            "What do you get when you put a candle in a suit of armour? A knight light.",
            "Have you heard about corduroy pillows?! They are making headlines!",
            "Two drums and a cymbal fall off a cliff. Ba-dum Tish!",
            "There were two peanuts walking down a dark alley, one was assaulted.",
            "What do you call a cow with two legs? Lean beef."
    );

    public String getJokes()
    {
        Random random = new Random();
        String jokes = myJokes.get(random.nextInt(myJokes.size()));
        return jokes;
    }
}
