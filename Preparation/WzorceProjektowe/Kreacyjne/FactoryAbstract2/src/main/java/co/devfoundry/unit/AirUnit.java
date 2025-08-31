package co.devfoundry.unit;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
abstract public class AirUnit {

    private int hp;
    private int exp;
    private int dmgDone;

    protected AirUnit(int hp, int exp, int dmgDone) {
        this.hp = hp;
        this.exp = exp;
        this.dmgDone = dmgDone;
    }
}
