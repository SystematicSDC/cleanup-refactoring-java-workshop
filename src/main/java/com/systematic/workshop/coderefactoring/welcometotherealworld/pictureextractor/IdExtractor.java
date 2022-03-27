package com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor;

/**
 * This class reads the ID from fictional entities.
 * <p>
 * Your goal is to:
 * <li> uncomment the code here and make it compile. See step 2. </li>
 * <li> do NOT move any classes or change access modifiers (private/public/protected) to anything. ANY other code changes
 * to the com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor package and subpackage are fine.</li>
 * <li> remove the Disabled annotation of the tests in IdExtractorTest and test your solution! See what you can fix in
 * the implementation WITHOUT changing anything else in the test.</li>
 * <li> BONUS: Can the getId method have a SINGLE line of code?</li>
 * <p>
 * <p>
 * HINTS:
 * <li> Polymorphism</li>
 * <li> Open-Closed Principle</li>
 * <li> Liskov Substitution Principle</li>
 */
public class IdExtractor {

    public String getId(Object o) {
        //        if (!(o instanceof Entity)) {
        //            throw new IllegalArgumentException("Method only supports entities!");
        //        }
        //        Entity entity = (Entity) o;
        //        if (entity instanceof Person) {
        //            return CNPGenerator.generateCnp();
        //        } else if (entity instanceof Picture) {
        //            return entity.getId();
        //        } else {
        return null; // Hint: this might be a bug!
        //        }
    }

}





