package com.systematic.workshop.coderefactoring.cleancode;

import com.systematic.workshop.coderefactoring.cleancode.ErrorHandling.MyNumberCheckedException;
import com.systematic.workshop.coderefactoring.cleancode.ErrorHandling.MyNumberRuntimeException;
import org.junit.jupiter.api.Test;

import static com.systematic.workshop.coderefactoring.cleancode.ErrorHandling.NumberParser.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ErrorHandlingTest {

    @Test
    void parsingAnActualNumberIsSuccessful() {
        String no = "1";

        // Which other parser methods will NOT work here?
        assertThat(parseNumberNoException(no)).isEqualTo(1);
    }

    @Test
    void parsingNullExpectsMyCheckedException() {
        String no = null;

        assertThatExceptionOfType(MyNumberCheckedException.class).isThrownBy(() -> parseNumberCustomCheckedException(no));
    }

    @Test
    void parsingNullExpectsMyRuntimeException() {
        String no = null;

        assertThatExceptionOfType(MyNumberRuntimeException.class).isThrownBy(() -> parseNumberCustomRuntimeException(no));
    }

    @Test
    void parsingNullExpectsSomeRuntimeException() {
        String no = null;

        // TRY TO FIND MORE SOLUTIONS THAN ONE! CAN YOU THINK OF A REASON WHY THEY ALL WORK?
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> parseNumberCustomRuntimeException(no));
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> parseNumberGenericRuntimeException(no));
    }
}
