package com.zipla.dataforge;

public class Constraints {
    public static StringConstraint length(int minLength, int maxLength) {
        return new StringConstraint(minLength, maxLength);
    }

    public static IntConstraint range(int min, int max) {
        return new IntConstraint(min, max);
    }
}
