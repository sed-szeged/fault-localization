package hu.szte.inf.sed.fl.formula.sbfl;

import hu.szte.inf.sed.fl.formula.Formula;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Formulas {

    DSTAR(new DStar()), OCHIAI(new Ochiai()), TARANTULA(new Tarantula());

    private final Formula formula;

    public Formulas fromTest(final String text) {
        switch (text) {
            case "dstar":
                return DSTAR;
            case "ochiai":
                return OCHIAI;
            case "tarantula":
                return TARANTULA;
            default:
                throw new IllegalArgumentException(String.format("Invalid formula name '%s'", text));
        }
    }

}
