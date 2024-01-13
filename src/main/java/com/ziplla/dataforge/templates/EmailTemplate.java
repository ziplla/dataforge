package com.ziplla.dataforge.templates;

import java.util.Random;

public class EmailTemplate implements Template{
    private static final String[] EMAIL_PROVIDERS = {"gmail", "yahoo", "hotmail", "outlook", "example"};
    private static final String[] PREFIXES = {"john", "alice", "bob", "emma", "david", "susan"};
    private static final String[] SUFFIXES = {"123", "456", "789", "abc", "xyz"};

    @Override
    public Object generate() {
        return generateRandomEmail();
    }

    public static String generateRandomEmail() {
        Random random = new Random();

        String prefix = PREFIXES[random.nextInt(PREFIXES.length)];
        String suffix = SUFFIXES[random.nextInt(SUFFIXES.length)];
        String provider = EMAIL_PROVIDERS[random.nextInt(EMAIL_PROVIDERS.length)];

        int randomNumber = random.nextInt(1000);

        return prefix + suffix + "@" + provider + ".com";
    }
}
