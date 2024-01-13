package com.ziplla.dataforge.templates;

import java.util.Random;

public class PhoneNumberTemplate implements Template {

    public static String generateRandomPhoneNumber() {
        Random random = new Random();

        String countryCodeAndFirstDigit = "+7" + (random.nextInt(9) + 1);

        long phoneNumberRemainingDigits = 1000000000L + Math.abs(random.nextLong()) % 9000000000L;

        String formattedPhoneNumber = countryCodeAndFirstDigit + phoneNumberRemainingDigits;

        return formattedPhoneNumber;
    }

    @Override
    public Object generate() {
        return generateRandomPhoneNumber();
    }
}
