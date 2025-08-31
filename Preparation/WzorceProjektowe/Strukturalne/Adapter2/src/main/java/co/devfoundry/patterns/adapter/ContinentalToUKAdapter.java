package co.devfoundry.patterns.adapter;

public class ContinentalToUKAdapter implements IUKDevice {

    IContinentalDevice iContinentalDevice;

    public ContinentalToUKAdapter(IContinentalDevice iContinentalDevice) {
        this.iContinentalDevice = iContinentalDevice;
    }

    @Override
    public void powerOn() {
        iContinentalDevice.on();
    }
}
