package co.devfoundry;

import co.devfoundry.fabryki.BlueFactory;
import co.devfoundry.fabryki.Factory;
import co.devfoundry.fabryki.RedFactory;
import co.devfoundry.unit.AirUnit;
import co.devfoundry.unit.InfantryUnit;
import co.devfoundry.unit.MechanizedUnit;
import co.devfoundry.unit.UnitType;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        Factory redFactory = new RedFactory();
        MechanizedUnit redTank = redFactory.createMechanizedUnit(UnitType.TANK);
        InfantryUnit redInfantry = redFactory.createInfantryUnit(UnitType.RIFLEMAN);
        AirUnit redHelicopter = redFactory.createAirUnit(UnitType.HELICOPTER);

        Factory blueFactory = new BlueFactory();
        MechanizedUnit blueTank = blueFactory.createMechanizedUnit(UnitType.TANK);
        InfantryUnit blueInfantry = blueFactory.createInfantryUnit(UnitType.RIFLEMAN);
        AirUnit blueHelicopter = blueFactory.createAirUnit(UnitType.HELICOPTER);
    }
}