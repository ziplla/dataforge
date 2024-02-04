package ru.ziplla.dataforge.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ShortConstraint {

    private final short firstLimit;
    private final short secondLimit;
}
