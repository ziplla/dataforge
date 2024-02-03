package ru.ziplla.dataforge.constraints;

public class Constraints {
    public static StringConstraint length(int minLength, int maxLength) {
        return new StringConstraint(minLength, maxLength);
    }

    public static IntConstraint range(int firstLimit, int secondLimit) {
        return new IntConstraint(firstLimit, secondLimit);
    }

    public static DoubleConstraint rangeDouble(double firstLimit, double secondLimit, int decimalPlaces) {
        return new DoubleConstraint(firstLimit, secondLimit, decimalPlaces);
    }
}
