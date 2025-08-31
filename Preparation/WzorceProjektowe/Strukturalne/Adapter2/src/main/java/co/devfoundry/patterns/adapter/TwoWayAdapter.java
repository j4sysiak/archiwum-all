package co.devfoundry.patterns.adapter;

public class TwoWayAdapter implements IUKDevice, IContinentalDevice  {

    IUKDevice iUKDevice;
    IContinentalDevice iContinentalDevice;

    public TwoWayAdapter(IUKDevice iUKDevice, IContinentalDevice iContinentalDevice) {
        this.iUKDevice = iUKDevice;
        this.iContinentalDevice = iContinentalDevice;
    }

    public void on() {
        iUKDevice.powerOn();
    }

    public void powerOn() {
        iContinentalDevice.on();
    }
}
