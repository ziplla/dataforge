package ru.ziplla.dataforge.templates_tests;

import ru.ziplla.dataforge.templates.EmailTemplate;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmailTemplateTest {

    @Test
    public void testGenerateRandomEmail() {
        String email = EmailTemplate.generateRandomEmail();

        assertNotNull(email);

        assertTrue(email.contains("@"));

        boolean isValidProvider = false;
        for (String provider : EmailTemplate.EMAIL_PROVIDERS) {
            if (email.contains(provider)) {
                isValidProvider = true;
                break;
            }
        }
        assertTrue(isValidProvider);
    }

    @Test
    public void testGenerate() {
        EmailTemplate emailTemplate = new EmailTemplate();
        Object generatedEmail = emailTemplate.generate();

        assertNotNull(generatedEmail);

        assertTrue(generatedEmail.toString().matches("^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+$"));
    }

}
