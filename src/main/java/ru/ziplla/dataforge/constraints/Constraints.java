package ru.ziplla.dataforge.constraints;

public class Constraints {
    public static StringConstraint lengthString(int firstLimit, int secondLimit) {
        return new StringConstraint(firstLimit, secondLimit);
    }

    public static StringConstraint lengthString(int firstLimit, int secondLimit, Language language) {
        return new StringConstraint(firstLimit, secondLimit, language);
    }

    public static IntConstraint rangeInt(int firstLimit, int secondLimit) {
        return new IntConstraint(firstLimit, secondLimit);
    }

    public static DoubleConstraint rangeDouble(double firstLimit, double secondLimit, int decimalPlaces) {
        return new DoubleConstraint(firstLimit, secondLimit, decimalPlaces);
    }

    public static DoubleConstraint rangeDouble(double firstLimit, double secondLimit) {
        return new DoubleConstraint(firstLimit, secondLimit);
    }

    public static FloatConstraint rangeFloat(float firstLimit, float secondLimit, int decimalPlaces) {
        return new FloatConstraint(firstLimit, secondLimit, decimalPlaces);
    }

    public static FloatConstraint rangeFloat(float firstLimit, float secondLimit) {
        return new FloatConstraint(firstLimit, secondLimit);
    }

    public static LongConstraint rangeLong(Long firstLimit, Long secondLimit) {
        return new LongConstraint(firstLimit, secondLimit);
    }

    public static ByteConstraint rangeByte(Byte firstLimit, Byte secondLimit) {
        return new ByteConstraint(firstLimit, secondLimit);
    }

    public static ShortConstraint rangeShort(Short firstLimit, Short secondLimit) {
        return new ShortConstraint(firstLimit, secondLimit);
    }
}
