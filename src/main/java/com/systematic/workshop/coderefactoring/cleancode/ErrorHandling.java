package com.systematic.workshop.coderefactoring.cleancode;

/**
 * This class emphasizes some typical scenarios based on which you can clean up exception handling.
 * <p>
 * Your task:
 *
 * <li> go to ErrorHandlingTest and remove the @Disabled annotation from all tests</li>
 * <li> figure out which of the methods in NumberParser is more suited for each test scenario.</li>
 * <li> essentially, you need to "fix" the test by replacing the call to the NumberParser, without changing the expected outcome.</li>
 * <li> after you fixed the tests, discuss which of the parser implementations is the cleanest and dirtiest respectively.</li>
 */
final class ErrorHandling {

    private ErrorHandling() {

    }

    static class MyNumberRuntimeException extends RuntimeException {

        public MyNumberRuntimeException(NumberFormatException e) {

        }

    }

    static class MyNumberCheckedException extends Exception {

        public MyNumberCheckedException(NumberFormatException e) {

        }
    }

    static class NumberParser {

        static int fixMeByReplacingThisCallPlease1111(String number) throws Throwable {
            throw new Throwable("BOOM");
        }

        // HORRIBLE - it violates Open-Closed Principle as well as potentially LSP and it looks plain ugly!
        static int parseNumberWithIntegratedExceptionHandling(String number) {
            try {
                int i = parseNumberGenericCheckedException(number);
                return i;
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    throw new MyNumberRuntimeException((NumberFormatException) e);
                } else {
                    throw new RuntimeException(e);
                }
            }
        }

        /**
         * No exception handling
         */
        static int parseNumberNoException(String toParse) {
            return Integer.parseInt(toParse);
        }

        /*
         * Throws the exception as stated by the API of the method called in our implementation
         */
        static int parseNumberNFE(String toParse) throws NumberFormatException {
            return Integer.parseInt(toParse);
        }

        /*
         * This is probably the least relevant one, because ANY method in Java can throw a RuntimeException.
         */
        static int parseNumberGenericRuntimeException(String toParse) throws RuntimeException {
            return Integer.parseInt(toParse);
        }

        /*
         * Wraps the unchecked exception into a checked exception to enforce catching
         */
        static int parseNumberGenericCheckedException(String toParse) throws Exception {
            try {
                return Integer.parseInt(toParse);
            } catch (NumberFormatException e) {
                throw new Exception(e);
            }
        }

        /*
         * Wraps the unchecked exception into a checked exception to enforce catching
         */
        static int parseNumberCustomCheckedException(String toParse) throws MyNumberCheckedException {
            try {
                return Integer.parseInt(toParse);
            } catch (NumberFormatException e) {
                throw new MyNumberCheckedException(e);
            }
        }

        /*
         * Wraps the unchecked exception into a custom unchecked exception
         */
        static int parseNumberCustomRuntimeException(String toParse) throws MyNumberRuntimeException {
            try {
                return Integer.parseInt(toParse);
            } catch (NumberFormatException e) {
                throw new MyNumberRuntimeException(e);
            }
        }

    }
}
