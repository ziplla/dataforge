package com.zipla.dataforge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class IntConstraint {

    private final int min;
    private final int max;
}
