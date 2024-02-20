package ru.ziplla.dataforge.templates_tests;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import ru.ziplla.dataforge.templates.EmailTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmailTemplateTest {

    @Test
    public void testGenerateRandomEmail() {
        String email = EmailTemplate.generateRandomEmail();

        assertNotNull(email);

        assertTrue(email.contains("@"));

        Yaml yaml = new Yaml();

        try (InputStream inputStream = EmailTemplate.class.getClassLoader().getResourceAsStream("email.yml")) {

            Map<String, List<String>> data = yaml.load(inputStream);

            List<String> providers = data.get("providers");
            List<String> prefixes = data.get("prefixes");
            List<String> suffixes = data.get("suffixes");


            boolean isValidProvider = false;
            for (String provider : providers) {
                if (email.contains(provider)) {
                    isValidProvider = true;
                    break;
                }
            }
            assertTrue(isValidProvider);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGenerate() {
        EmailTemplate emailTemplate = new EmailTemplate();
        Object generatedEmail = emailTemplate.generate();

        assertNotNull(generatedEmail);

        assertTrue(generatedEmail.toString().matches("^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+$"));
    }

}
