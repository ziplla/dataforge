package ru.ziplla.dataforge.constraints;

public class Constraints {
    public static StringConstraint length(int firstLimit, int secondLimit) {
        return new StringConstraint(firstLimit, secondLimit);
    }

    public static IntConstraint range(int firstLimit, int secondLimit) {
        return new IntConstraint(firstLimit, secondLimit);
    }

    public static DoubleConstraint rangeDouble(double firstLimit, double secondLimit, int decimalPlaces) {
        return new DoubleConstraint(firstLimit, secondLimit, decimalPlaces);
    }

    public static FloatConstraint rangeFloat(float firstLimit, float secondLimit, int decimalPlaces) {
        return new FloatConstraint(firstLimit, secondLimit, decimalPlaces);
    }

    public static LongConstraint rangeLong(Long firstLimit, Long secondLimit) {
        return new LongConstraint(firstLimit, secondLimit);
    }
}
