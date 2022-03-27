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
    void averageCannotUseNullParameters() {
        // Execute and assert
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> meaningfulNames.average(ONE, null));
    }

    @Test
    void averageOfOneAndOneIsOne() {
        // Execute
        BigDecimal avg = meaningfulNames.average(ONE, ONE);

        // Assert
        assertThat(avg).isEqualByComparingTo(ONE);
    }

    @Test
    void averageOfOneAndTwoIsHalfOfOne() {
        // Execute
        BigDecimal avg = meaningfulNames.average(ONE, BigDecimal.valueOf(2));

        // Assert
        assertThat(avg).isEqualByComparingTo(new BigDecimal("1.5"));
    }

    @Test
    void testSidesThreeAndFourIsHypothenuseFive() {
        final int x = 3;
        final int y = 4;
        final int expected = 5;

        double counter = meaningfulNames.hypothenuseSize(x, y);
        assertThat(counter).isEqualTo(expected);
    }

    @Test
    void testSidesFourAndThreeIsHypothenuseFive() {
        double notACounter = meaningfulNames.hypothenuseSize(4, 3);
        assertThat(notACounter).isEqualTo(5);
    }

    @Test
    void testIsoscelesTriangleOfSideOneIsHypothenuseSquareRootOfTwo() {
        assertThat(meaningfulNames.hypothenuseSize(1, 1)).isEqualTo(sqrt(2));
    }

    @Test
    void deletingFileThatDoesNotExistReturnsFalse() throws IOException {
        assertThat(meaningfulNames.deleteFile("123")).isFalse();
    }

    @Test
    void deletingFileThatExistsReturnsTrue() throws IOException {
        Path path = createFile(Paths.get("newFile.txt"));

        assertThat(meaningfulNames.deleteFile(path.toString())).isTrue();
    }

}
