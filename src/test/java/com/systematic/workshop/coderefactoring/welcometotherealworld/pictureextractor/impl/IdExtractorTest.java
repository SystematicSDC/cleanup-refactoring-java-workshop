package com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.impl;

import com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.Entity;
import com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.IdExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.impl.Person.CNPGenerator.MY_CNP;
import static org.assertj.core.api.Assertions.assertThat;

class IdExtractorTest {

    private IdExtractor idExtractor;

    @BeforeEach
    void resetExtractor() {
        idExtractor = new IdExtractor();
    }

    @Test
    @Disabled
        // REMOVE ME
    void testACustomEntityWithANullId() {
        // Prepare
        Entity entity = new Entity() {
            @Override
            public String getId() {
                return null;
            }
        };

        // Execute
        String personIdentifier = idExtractor.getId(entity);

        // Verify
        assertThat(personIdentifier).isNull();
    }

    // This test fails because there's a bug in the implementation!
    @Test
    @Disabled
    // REMOVE ME
    void testACustomEntityWithACustomId() {
        // Prepare
        Entity entity = new Entity() {
            @Override
            public String getId() {
                return "myCustomId";
            }
        };

        // Execute
        String personIdentifier = idExtractor.getId(entity);

        // Verify
        assertThat(personIdentifier).isEqualTo("myCustomId");
    }

    @Test
    @Disabled
        // REMOVE ME
    void testPersonCNP() {
        // Prepare
        Person person = new Person();

        // Execute
        String personIdentifier = idExtractor.getId(person);

        // Verify
        assertThat(personIdentifier).isEqualTo(MY_CNP);
    }

    @Test
    @Disabled
        // REMOVE ME
    void testPictureName() {
        // Prepare
        Picture picture = new Picture();

        // Execute
        String personIdentifier = idExtractor.getId(picture);

        // Verify
        assertThat(personIdentifier).isEqualTo("picture.png");
    }
}
