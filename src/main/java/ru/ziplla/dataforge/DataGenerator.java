package ru.ziplla.dataforge;

import ru.ziplla.dataforge.constraints.DoubleConstraint;
import ru.ziplla.dataforge.constraints.IntConstraint;
import ru.ziplla.dataforge.constraints.StringConstraint;
import ru.ziplla.dataforge.templates.Template;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

import java.util.Map;
import java.util.Random;

@ToString
@Getter
public class DataGenerator {

    private final Map<String, Object> generatedData;
    private final Map<String, StringConstraint> stringConstraints;
    private final Map<String, IntConstraint> intConstraints;
    private final Map<String, DoubleConstraint> doubleConstraints;
    private final Map<String, Template> templates;

    public DataGenerator() {
        this.generatedData = new HashMap<>();
        this.stringConstraints = new HashMap<>();
        this.intConstraints = new HashMap<>();
        this.doubleConstraints = new HashMap<>();
        this.templates = new HashMap<>();
    }

    public void addStringField(String fieldName, StringConstraint constraints) {
        stringConstraints.put(fieldName, constraints);
    }

    public void addIntegerField(String fieldName, IntConstraint constraints) {
        intConstraints.put(fieldName, constraints);
    }

    public void addDoubleField(String fieldName, DoubleConstraint constraints) {
        doubleConstraints.put(fieldName, constraints);
    }

    public void addTemplate(String fieldName, Template template) {
        templates.put(fieldName, template);
    }

    public Map<String, Object> generate() {
        for (String fieldName : stringConstraints.keySet()) {
            generatedData.put(fieldName, generateString(fieldName));
        }

        for (String fieldName : intConstraints.keySet()) {
            generatedData.put(fieldName, generateInt(fieldName));
        }

        for (String fieldName : doubleConstraints.keySet()) {
            generatedData.put(fieldName, generateDouble(fieldName));
        }

        for (String fieldName : templates.keySet()) {
            generatedData.put(fieldName, generateFromTemplate(fieldName));
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

    private double generateDouble(String fieldName) {
        DoubleConstraint constraint = doubleConstraints.get(fieldName);
        double min = constraint.getMin();
        double max = constraint.getMax();
        Random random = new Random();

        return min + (max - min) * random.nextDouble();
    }

    private Object generateFromTemplate(String fieldName) {
        Template template = templates.get(fieldName);

        return template.generate();
    }
}
