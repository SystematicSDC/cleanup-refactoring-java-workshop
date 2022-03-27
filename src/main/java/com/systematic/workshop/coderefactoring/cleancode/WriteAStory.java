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

    Boolean isPlayerLuckyToday(Random player) {
        int maxDieRoll = 6;
        int dieRoll = rollDie(player);
        return assertLuckBasedOnDieRoll(maxDieRoll, dieRoll);
    }

    private int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }

    private Boolean assertLuckBasedOnDieRoll(int maxDieRoll, int dieRoll) {
        return maxDieRoll == dieRoll;
    }
}
