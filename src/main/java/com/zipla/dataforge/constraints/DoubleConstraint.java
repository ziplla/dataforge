package com.zipla.dataforge.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DoubleConstraint {
    private final double min;
    private final double max;
}
