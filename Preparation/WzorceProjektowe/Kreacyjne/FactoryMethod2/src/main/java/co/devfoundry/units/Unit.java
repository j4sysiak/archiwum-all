package co.devfoundry.units;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public abstract class Unit {

    private int hp;
    private int exp;
    private int dmgDone;

    protected Unit(int hp, int exp, int dmgDone) {
        this.hp = hp;
        this.exp = exp;
        this.dmgDone = dmgDone;
    }
}
