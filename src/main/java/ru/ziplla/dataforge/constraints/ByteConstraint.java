package ru.ziplla.dataforge.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ByteConstraint {

    private final byte firstLimit;
    private final byte secondLimit;
}
