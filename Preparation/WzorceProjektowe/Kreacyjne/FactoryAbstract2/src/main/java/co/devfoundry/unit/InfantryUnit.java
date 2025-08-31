package co.devfoundry.unit;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public abstract class InfantryUnit {

    private int hp;
    private int exp;
    private int dmgDone;

    protected InfantryUnit(int hp, int exp, int dmgDone) {
        this.hp = hp;
        this.exp = exp;
        this.dmgDone = dmgDone;
    }
}
