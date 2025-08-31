package co.devfoundry.fabryki;

import co.devfoundry.unit.InfantryUnit;
import co.devfoundry.unit.MechanizedUnit;
import co.devfoundry.Rifleman;
import co.devfoundry.unit.AirUnit;
import co.devfoundry.unit.UnitType;

public class InfantryUnitFactory extends Factory {


    public Rifleman createUnit(UnitType unitType) {

        switch (unitType) {
            case RIFLEMAN:
                return new Rifleman(100, 0, 10);
            case SAPER:
                return new Rifleman(50, 0, 15);
            default:
                throw new UnsupportedOperationException("No such type");
        }
    }

    @Override
    public InfantryUnit createInfantryUnit(UnitType type) {
        return null;
    }

    @Override
    public MechanizedUnit createMechanizedUnit(UnitType type) {
        return null;
    }

    @Override
    public AirUnit createAirUnit(UnitType type) {
        return null;
    }
}
