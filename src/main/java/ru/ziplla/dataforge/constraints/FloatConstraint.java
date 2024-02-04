package ru.ziplla.dataforge.constraints;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FloatConstraint {

    private final float firstLimit;
    private final float secondLimit;
    private int decimalPlaces;

    public FloatConstraint(float firstLimit, float secondLimit, int decimalPlaces) {
        this.firstLimit = firstLimit;
        this.secondLimit = secondLimit;
        this.decimalPlaces = decimalPlaces;
    }

    public FloatConstraint(float firstLimit, float secondLimit) {
        this.firstLimit = firstLimit;
        this.secondLimit = secondLimit;
    }
}
