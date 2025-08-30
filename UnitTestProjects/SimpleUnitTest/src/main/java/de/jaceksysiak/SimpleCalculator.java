package de.jaceksysiak;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SimpleCalculator {

    public int add (int numbA, int numbB) {
        return numbA + numbB;
    }

}
