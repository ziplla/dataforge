package ru.ziplla.dataforge.constraints;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleConstraint {
    private final double firstLimit;
    private final double secondLimit;
    private int decimalPlaces;

    public DoubleConstraint(double firstLimit, double secondLimit, int decimalPlaces) {
        this.firstLimit = firstLimit;
        this.secondLimit = secondLimit;
        this.decimalPlaces = decimalPlaces;
    }

    public DoubleConstraint(double firstLimit, double secondLimit) {
        this.firstLimit = firstLimit;
        this.secondLimit = secondLimit;
    }

}
