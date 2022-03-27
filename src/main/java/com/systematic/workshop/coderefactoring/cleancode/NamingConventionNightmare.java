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

    static final int A = 2, b = 1;
    static int x;
    String Xy;
    String y;
    long THIS_IS_NOT_A_FINAL_FIELD;


    public void some_METHOD() {
        int x = 2;
        x = x;
    }

    public void ANOTher_Method() {
    }

    public String THISreturnsSomething() {
        int x, y = 3;

        String string = String.valueOf(3);

        return String.valueOf(3);

    }

    static class FUNKY_class_O_o {

    }

    class x {

    }


}
