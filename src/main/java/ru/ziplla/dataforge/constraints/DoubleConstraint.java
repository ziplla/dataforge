package ru.ziplla.dataforge.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DoubleConstraint {
    private final double firstLimit;
    private final double secondLimit;
    private final int decimalPlaces;
}
