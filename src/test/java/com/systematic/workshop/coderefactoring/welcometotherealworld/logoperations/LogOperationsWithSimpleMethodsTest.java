package com.systematic.workshop.coderefactoring.welcometotherealworld.logoperations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class LogOperationsWithSimpleMethodsTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private LogOperationsWithSimpleMethods logOperations = new LogOperationsWithSimpleMethods();

    @BeforeEach
    void setupMocks() {
        openMocks(this);
    }

    @Nested
    class WithDebugEnabled {

        @BeforeEach
        void setupLogger() {
            doReturn(true).when(logger).isDebugEnabled();
        }

        @Test
        void testSum() {
            // Prepare
            long x = 1;
            long y = 2;

            // Execute
            long z = logOperations.sum(x, y);

            // Assert
            assertThat(z).isEqualTo(3);
            verify(logger, atLeastOnce()).isDebugEnabled();
            verify(logger, times(1)).debug("Started operation sum.");
            verify(logger, times(1)).debug("Finished operation sum.");
            verifyNoMoreInteractions(logger);
        }

        @Test
        void testSquareRoot() {
            // Prepare
            double no = 9;

            // Execute
            double sqrt = logOperations.squareRoot(no);

            // Assert
            assertThat(sqrt).isEqualTo(3);
            verify(logger, atLeastOnce()).isDebugEnabled();
            verify(logger, times(1)).debug("Started operation sqrt.");
            verify(logger, times(1)).debug("Finished operation sqrt.");
            verifyNoMoreInteractions(logger);
        }

    }

    @Nested
    class WithDebugDisabled {

        @BeforeEach
        void setupLogger() {
            doReturn(false).when(logger).isDebugEnabled();
        }

        @Test
        void testSum() {
            // Prepare
            long x = 1;
            long y = 2;

            // Execute
            long z = logOperations.sum(x, y);

            // Assert
            assertThat(z).isEqualTo(3);
            verify(logger, never()).debug(anyString());
        }

        @Test
        void testSquareRoot() {
            // Prepare
            double no = 9;

            // Execute
            double sqrt = logOperations.squareRoot(no);

            // Assert
            assertThat(sqrt).isEqualTo(3);
            verify(logger, never()).debug(anyString());
        }


    }
}
