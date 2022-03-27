package com.systematic.workshop.coderefactoring.cleancode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class WriteAStoryTest {
    private final WriteAStory writeAStory = new WriteAStory();

    private Random dice;

    @BeforeEach
    void resetDice() {
        dice = new Random();
    }

    @Test
    @Disabled
        // REMOVE THE DISABLED ANNOTATION
    void testThatTheLuckyAlgorithmIsWorking() {
        // Prepare
        AtomicBoolean iFeelLucky = new AtomicBoolean(false);

        // Execute and assert
        assertThat(writeAStory.myMethod(dice)).isNotNull();
    }
}
