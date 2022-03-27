package com.systematic.workshop.coderefactoring.cleancode;

import java.util.Random;

/**
 * Your goal here is to write the code cleanly enough so that you don't need comments to explain what it does.
 * <p>
 * The code itself should be self-explanatory.
 * <p>
 * Also:
 * <li> remove the @Disabled annotations in the WriteAStoryTest</li>
 * <li> test your algorithm!!</li>
 * <li> open discussion: how can you test this algorithm MORE than just checking for null?</li>
 */
public class WriteAStory {

    /**
     * This method returns.. well can you please name the method so that I don't have to read this documentation?
     * <p>
     * It has three steps:
     * 1) Gets the max value that you can get for a die roll
     * 2) Actually rolls the dice
     * 3) Checks if you're lucky today and got the max of the die roll
     */
    Boolean myMethod(Random object) {
        // identify the max number between 0 and 6.
        int max = identifyMaxNumberBetweenZeroAnd6();
        // roll the dice today
        int rnd = getRandom(object);
        // see if you're lucky.
        return seeIfYouAreLuckyToday(max, rnd);
    }

    // Can this "chapter of the story" be simplified, while still being clear what it does?
    private int identifyMaxNumberBetweenZeroAnd6() {
        for (int i = 6; i >= 0; i--) {
            return i;
        }
        return 0;
    }

    // Get the current roll of the dice
    private int getRandom(Random random) {
        return random.nextInt(6) + 1;
    }

    private Boolean seeIfYouAreLuckyToday(int max, int rnd) {
        return null;
        // IMPLEMENT ME PLEASE;
    }
}
