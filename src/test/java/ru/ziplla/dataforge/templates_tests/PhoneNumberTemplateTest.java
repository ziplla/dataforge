package ru.ziplla.dataforge.templates_tests;

import org.junit.Test;
import ru.ziplla.dataforge.templates.PhoneNumberTemplate;

import static org.junit.Assert.*;

public class PhoneNumberTemplateTest {

    @Test
    public void testGenerateRandomPhoneNumber() {
        String phoneNumber = PhoneNumberTemplate.generateRandomPhoneNumber();

        assertNotNull(phoneNumber);

        assertTrue(phoneNumber.startsWith("+7"));

        assertEquals(12, phoneNumber.length());

        assertTrue(phoneNumber.substring(2).matches("\\d+"));
    }

    @Test
    public void testGenerate() {
        PhoneNumberTemplate phoneNumberTemplate = new PhoneNumberTemplate();
        Object generatedPhoneNumber = phoneNumberTemplate.generate();

        assertNotNull(generatedPhoneNumber);

        assertTrue(generatedPhoneNumber.toString().matches("^\\+7\\d{10}$"));
    }
}

