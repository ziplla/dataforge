package com.zipla.dataforge;

import lombok.ToString;

import java.util.HashMap;

import java.util.Map;
import java.util.Random;

@ToString
public class DataGenerator {

    private final Map<String, Object> generatedData;
    private final Map<String, StringConstraint> stringConstraints;
    private final Map<String, IntConstraint> intConstraints;

    public DataGenerator() {
        this.generatedData = new HashMap<>();
        this.stringConstraints = new HashMap<>();
        this.intConstraints = new HashMap<>();
    }

    public void addStringField(String fieldName, StringConstraint constraints) {
        stringConstraints.put(fieldName, constraints);
    }

    public void addIntegerField(String fieldName, IntConstraint constraints) {
        intConstraints.put(fieldName, constraints);
    }

    public Map<String, Object> generate() {
        for (String fieldName : stringConstraints.keySet()) {
            generatedData.put(fieldName, generateString(fieldName));
        }

        for (String fieldName : intConstraints.keySet()) {
            generatedData.put(fieldName, generateInt(fieldName));
        }

        return generatedData;
    }

    private String generateString(String fieldName) {
        StringConstraint constraint = stringConstraints.get(fieldName);
        int minLength = constraint.getMinLength();
        int maxLength = constraint.getMaxLength();

        return generateRandomString(minLength, maxLength);
    }
    public static String generateRandomString(int minLength, int maxLength) {
        if (minLength < 0 || maxLength < 0 || minLength > maxLength) {
            throw new IllegalArgumentException("Incorrect string length parameters");
        }

        Random random = new Random();
        int length = minLength + random.nextInt(maxLength - minLength + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }

        return sb.toString();
    }

    private int generateInt(String fieldName) {
        IntConstraint constraint = intConstraints.get(fieldName);
        int min = constraint.getMin();
        int max = constraint.getMax();

        return min + (int)(Math.random() * max);
    }
}
