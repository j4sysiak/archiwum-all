package co.devfoundry.fabryki;

import co.devfoundry.unit.AirUnit;
import co.devfoundry.unit.InfantryUnit;
import co.devfoundry.unit.MechanizedUnit;
import co.devfoundry.unit.UnitType;

abstract public class Factory {

    abstract public InfantryUnit createInfantryUnit(UnitType type);

    abstract public MechanizedUnit createMechanizedUnit(UnitType type);

    abstract public AirUnit createAirUnit(UnitType type);
}
