package ru.ziplla.dataforge.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LongConstraint {

    private final Long firstLimit;
    private final Long secondLimit;
}
