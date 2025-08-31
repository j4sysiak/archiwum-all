package co.devfoundry.fabryki;

import co.devfoundry.unit.InfantryUnit;
import co.devfoundry.unit.MechanizedUnit;
import co.devfoundry.Helicopter;
import co.devfoundry.Rifleman;
import co.devfoundry.Tank;
import co.devfoundry.unit.AirUnit;
import co.devfoundry.unit.UnitType;

public class BlueFactory extends Factory {

    @Override
    public InfantryUnit createInfantryUnit(UnitType type) {
        switch (type) {
            case RIFLEMAN:
                return new Rifleman(25, 0, 5);
            default:
                throw new UnsupportedOperationException("Nieznany typ");
        }
    }

    @Override
    public MechanizedUnit createMechanizedUnit(UnitType type) {
        switch (type) {
            case TANK:
                return new Tank(100, 0, 25);
            default:
                throw new UnsupportedOperationException("Nieznany typ");
        }
    }


    @Override
    public AirUnit createAirUnit(UnitType type) {
        switch (type) {
            case HELICOPTER:
                return new Helicopter(50, 0, 25);
            default:
                throw new UnsupportedOperationException("Nieznany typ");
        }
    }
}
