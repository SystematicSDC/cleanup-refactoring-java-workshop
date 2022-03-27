package com.systematic.workshop.coderefactoring.cleancode;

/**
 * This class has a bunch of bad practices on how to declare members.
 * <p>
 * Your goal is to identify the members of the class that do not follow naming conventions - and fix them all; although,
 * try to not delete them just because they're unused :)
 * Try to clean up the code as much as possible.
 * <p>
 * Keep in mind that depending on what IDE or plugins you're using, you may or may not see suggestions related to naming conventions.
 * <p>
 * Tips:
 * <li> rename field</li>
 * <li> rename method</li>
 * <li> inline variable</li>
 * <p>
 * See https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html
 */
public class NamingConventionNightmare {
    static final int A = 2;
    static final int B = 1;

    static int x;
    String xY;
    String y;
    long thisIsNotAFinalField;


    public void someMethod() {
        int x = 2;
    }

    public void anotherMethod() {
    }

    public String thisReturnsSomething() {
        int x;
        int y = 3;
        return String.valueOf(3);

    }

    static class FunkyClass {

    }

    class X {

    }


}
