package com.ziplla.dataforge.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StringConstraint {
    private final int minLength;
    private final int maxLength;
}
