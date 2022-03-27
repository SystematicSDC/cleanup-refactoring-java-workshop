package com.systematic.workshop.coderefactoring.cleancode;

import com.systematic.workshop.coderefactoring.cleancode.ErrorHandling.MyNumberCheckedException;
import com.systematic.workshop.coderefactoring.cleancode.ErrorHandling.MyNumberRuntimeException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.systematic.workshop.coderefactoring.cleancode.ErrorHandling.NumberParser.fixMeByReplacingThisCallPlease1111;
import static com.systematic.workshop.coderefactoring.cleancode.ErrorHandling.NumberParser.parseNumberNoException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ErrorHandlingTest {

    @Test
    @Disabled
        // REMOVE THE DISABLED ANNOTATION
    void parsingAnActualNumberIsSuccessful() {
        String no = "1";

        // Which other parser methods will NOT work here?
        assertThat(parseNumberNoException(no)).isEqualTo(1);
    }

    @Test
    @Disabled
        // REMOVE THE DISABLED ANNOTATION
    void parsingNullExpectsMyCheckedException() {
        String no = null;

        assertThatExceptionOfType(MyNumberCheckedException.class).isThrownBy(() -> fixMeByReplacingThisCallPlease1111(no));
    }

    @Test
    @Disabled
        // REMOVE THE DISABLED ANNOTATION
    void parsingNullExpectsMyRuntimeException() {
        String no = null;

        assertThatExceptionOfType(MyNumberRuntimeException.class).isThrownBy(() -> fixMeByReplacingThisCallPlease1111(no));
    }

    @Test
    @Disabled
        // REMOVE THE DISABLED ANNOTATION
    void parsingNullExpectsSomeRuntimeException() {
        String no = null;

        // TRY TO FIND MORE SOLUTIONS THAN ONE! CAN YOU THINK OF A REASON WHY THEY ALL WORK?
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> fixMeByReplacingThisCallPlease1111(no));
    }
}
