package ru.ziplla.dataforge.constraints;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StringConstraint {
    private final int firstLimit;
    private final int secondLimit;
    private Language language;

    public StringConstraint(int firstLimit, int secondLimit, Language language) {
        this.firstLimit = firstLimit;
        this.secondLimit = secondLimit;
        this.language = language;
    }

    public StringConstraint(int firstLimit, int secondLimit) {
        this.firstLimit = firstLimit;
        this.secondLimit = secondLimit;
    }
}
