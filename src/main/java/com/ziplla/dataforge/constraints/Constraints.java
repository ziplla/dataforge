package com.ziplla.dataforge.constraints;

public class Constraints {
    public static StringConstraint length(int minLength, int maxLength) {
        return new StringConstraint(minLength, maxLength);
    }

    public static IntConstraint range(int min, int max) {
        return new IntConstraint(min, max);
    }

    public static DoubleConstraint rangeDouble(double min, double max) {
        return new DoubleConstraint(min, max);
    }
}
