package ru.ziplla.dataforge.templates_tests;

import org.junit.Test;
import ru.ziplla.dataforge.templates.NameTemplate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class NameTemplateTest {

    @Test
    public void generateRandomNameShouldNotReturnNull() {
        String randomName = NameTemplate.generateRandomName();
        assertNotNull("Generated name should not be null", randomName);
    }

    @Test
    public void generateRandomNameShouldNotThrowException() {
        try {
            String randomName = NameTemplate.generateRandomName();
            assertNotNull("Generated name should not be null", randomName);
        } catch (Exception e) {
            fail("Generate random name should not throw an exception");
        }
    }

}


