package co.devfoundry.patterns.adapter;

public class UKToContinentalAdapter implements IContinentalDevice {

    IUKDevice iUKDevice;

    public UKToContinentalAdapter(IUKDevice iUKDevice) {
        this.iUKDevice = iUKDevice;
    }

    @Override
    public void on() {
        iUKDevice.powerOn(); // to uruchomi radio angielskie
    }
}

