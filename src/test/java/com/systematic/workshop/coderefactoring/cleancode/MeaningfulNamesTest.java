package com.systematic.workshop.coderefactoring.cleancode;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Math.sqrt;
import static java.math.BigDecimal.ONE;
import static java.nio.file.Files.createFile;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MeaningfulNamesTest {

    MeaningfulNames meaningfulNames = new MeaningfulNames();

    @Test
    void amIAJokeToYou() {
        // Prepare
        BigDecimal notjoke = ONE;
        BigDecimal joke = null;

        // Execute and assert
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> meaningfulNames.op1(notjoke, joke));
    }

    @Test
    void thisMeansThatOp1MethodIsASimpleMultiply() {
        // Prepare
        BigDecimal number1 = ONE;
        BigDecimal number2 = ONE;

        // Execute
        BigDecimal multiplication = meaningfulNames.op1(number1, number2);

        assertThat(multiplication).isEqualByComparingTo(ONE);
    }

    @Test
    void orIsOp1ADividerMethod() {
        BigDecimal divided = ONE;
        BigDecimal divisor = ONE;

        BigDecimal division = meaningfulNames.op1(divided, divisor);

        assertThat(division).isEqualByComparingTo(ONE);
    }

    @Test
    void testCounter() {
        final int x = 3;
        final int y = 4;
        final int expected = 5;

        double counter = meaningfulNames.op2(x, y);
        assertThat(counter).isEqualTo(expected);
    }

    @Test
    void ohDamnItsNotACounter() {
        double notACounter = meaningfulNames.op2(4, 3);
        assertThat(notACounter).isEqualTo(5);
    }

    @Test
    void whatIsOp2() {
        assertThat(meaningfulNames.op2(1, 1)).isEqualTo(sqrt(2));
    }

    @Test
    void testMyFunc1() throws IOException {
        assertThat(meaningfulNames.myfunc("123")).isFalse();
    }

    @Test
    void test2MyFunc() throws IOException {
        Path path = createFile(Paths.get("newFile.txt"));

        assertThat(meaningfulNames.myfunc(path.toString())).isTrue();
    }

}
