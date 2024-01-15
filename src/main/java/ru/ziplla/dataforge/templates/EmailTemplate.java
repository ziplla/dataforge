package ru.ziplla.dataforge.templates;

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

        String prefix = PREFIXES[random.nextInt(PREFIXES.length)];
        String suffix = SUFFIXES[random.nextInt(SUFFIXES.length)];
        String provider = EMAIL_PROVIDERS[random.nextInt(EMAIL_PROVIDERS.length)];


        return prefix + suffix + "@" + provider + ".com";
    }
}
