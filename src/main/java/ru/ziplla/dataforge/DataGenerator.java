package ru.ziplla.dataforge;

import ru.ziplla.dataforge.constraints.*;
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
    private final Map<String, LongConstraint> longConstraints;
    private final Map<String, FloatConstraint> floatConstraints;

    public DataGenerator() {
        this.generatedData = new HashMap<>();
        this.stringConstraints = new HashMap<>();
        this.intConstraints = new HashMap<>();
        this.doubleConstraints = new HashMap<>();
        this.templates = new HashMap<>();
        this.longConstraints = new HashMap<>();
        this.floatConstraints = new HashMap<>();
    }

    public void addStringField(String fieldName, StringConstraint constraints) {
        stringConstraints.put(fieldName, constraints);
    }

    public void addIntegerField(String fieldName, IntConstraint constraints) {
        intConstraints.put(fieldName, constraints);
    }

    public void addLongField(String fieldName, LongConstraint constraints) {
        longConstraints.put(fieldName, constraints);
    }

    public void addDoubleField(String fieldName, DoubleConstraint constraints) {
        doubleConstraints.put(fieldName, constraints);
    }

    public void addFloatField(String fieldName, FloatConstraint constraints) {
        floatConstraints.put(fieldName, constraints);
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

        for (String fieldName : longConstraints.keySet()) {
            generatedData.put(fieldName, generateLong(fieldName));
        }

        for (String fieldName : doubleConstraints.keySet()) {
            generatedData.put(fieldName, generateDouble(fieldName));
        }

        for (String fieldName : floatConstraints.keySet()) {
            generatedData.put(fieldName, generateFloat(fieldName));
        }

        for (String fieldName : templates.keySet()) {
            generatedData.put(fieldName, generateFromTemplate(fieldName));
        }

        return generatedData;
    }

    private String generateString(String fieldName) {
        StringConstraint constraint = stringConstraints.get(fieldName);
        int firstLimit = constraint.getFirstLimit();
        int secondLimit = constraint.getSecondLimit();

        MinMax minMax = selectMinMax(firstLimit, secondLimit);

        return generateRandomString(minMax.min, minMax.max);
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
        int firstLimit = constraint.getFirstLimit();
        int secondLimit = constraint.getSecondLimit();

        MinMax minMax = selectMinMax(firstLimit, secondLimit);

        return rndInt(minMax.min, minMax.max);
    }

    private Long generateLong(String fieldName) {
        LongConstraint constraint = longConstraints.get(fieldName);
        Long firstLimit = constraint.getFirstLimit();
        Long secondLimit = constraint.getSecondLimit();

        Long min;
        Long max;

        if (firstLimit >= secondLimit) {
            min = secondLimit;
            max = firstLimit;
        } else {
            min = firstLimit;
            max = secondLimit;
        }

        return rndLong(min, max);
    }

    public static int rndInt(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static Long rndLong(Long min, Long max)
    {
        max -= min;
        return (long) (Math.random() * ++max) + min;
    }

    public static double rndDouble(double min, double max)
    {
        max -= min;
        return (double) (Math.random() * ++max) + min;
    }

    public static float rndFloat(float min, float max)
    {
        max -= min;
        return (float) (Math.random() * ++max) + min;
    }

    private double generateDouble(String fieldName) {
        DoubleConstraint constraint = doubleConstraints.get(fieldName);

        double firstLimit = constraint.getFirstLimit();
        double secondLimit = constraint.getSecondLimit();
        int decimalPlaces = constraint.getDecimalPlaces();


        MinMax minMax = selectMinMax((int) firstLimit, (int) secondLimit);

        double generatedValue = rndDouble(minMax.min, minMax.max);

        double scale = Math.pow(10, decimalPlaces);
        double roundedValue = Math.round(generatedValue * scale) / scale;

        return roundedValue;
    }

    private float generateFloat(String fieldName) {
        FloatConstraint constraint = floatConstraints.get(fieldName);

        float firstLimit = constraint.getFirstLimit();
        float secondLimit = constraint.getSecondLimit();
        int decimalPlaces = constraint.getDecimalPlaces();


        MinMax minMax = selectMinMax((int) firstLimit, (int) secondLimit);

        float generatedValue = rndFloat(minMax.min, minMax.max);

        float scale = (float) Math.pow(10, decimalPlaces);
        float roundedValue = Math.round(generatedValue * scale) / scale;

        return roundedValue;
    }

    private Object generateFromTemplate(String fieldName) {
        Template template = templates.get(fieldName);

        return template.generate();
    }

    class MinMax {
        final int min;
        final int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private MinMax selectMinMax(int firstLimit, int secondLimit) {
        int min;
        int max;

        if (firstLimit >= secondLimit) {
            min = secondLimit;
            max = firstLimit;
        } else {
            min = firstLimit;
            max = secondLimit;
        }

        return new MinMax(min, max);
    }
}
