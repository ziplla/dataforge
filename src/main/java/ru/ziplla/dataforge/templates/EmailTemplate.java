package ru.ziplla.dataforge.templates;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EmailTemplate implements Template{
    public static final String[] EMAIL_PROVIDERS = {"gmail", "yahoo", "hotmail", "outlook", "example"};
    public static final String[] PREFIXES = {"john", "alice", "bob", "emma", "david", "susan"};
    public static final String[] SUFFIXES = {"123", "456", "789", "abc", "xyz"};

    @Override
    public Object generate() {
        return generateRandomEmail();
    }

    public static String generateRandomEmail() {
        Random random = new Random();

        Yaml yaml = new Yaml();

        try (InputStream inputStream = EmailTemplate.class.getClassLoader().getResourceAsStream("email.yml")) {

            Map<String, List<String>> data = yaml.load(inputStream);

            List<String> providers = data.get("providers");
            List<String> prefixes = data.get("prefixes");
            List<String> suffixes = data.get("suffixes");

            String provider = providers.get(random.nextInt(providers.size()));
            String prefix = prefixes.get(random.nextInt(prefixes.size()));
            String suffix = suffixes.get(random.nextInt(suffixes.size()));

            return prefix + suffix + "@" + provider + ".com";
        } catch (IOException e) {
            e.printStackTrace();
            return "Exception";
        }

    }
}
