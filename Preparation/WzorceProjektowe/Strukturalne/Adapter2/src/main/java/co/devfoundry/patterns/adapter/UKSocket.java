package co.devfoundry.patterns.adapter;

public class UKSocket {

    public void plugIn(IUKDevice iUKDevice) {
        iUKDevice.powerOn();
    }
}
