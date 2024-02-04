package ru.ziplla.dataforge.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FloatConstraint {

    private final float firstLimit;
    private final float secondLimit;
    private final int decimalPlaces;
}
