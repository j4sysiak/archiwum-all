package co.devfoundry.deliverybox;

public class DeliveryBoxFacade {

    private DeliveryBoxSystem2 deliveryBoxSystem2;
    private DeliveryBoxSystem1 deliveryBoxSystem1;

    public DeliveryBoxFacade() {
        deliveryBoxSystem1 = new DeliveryBoxSystem1();
        deliveryBoxSystem2 = new DeliveryBoxSystem2();
    }

    public void pickupPackage() {

        deliveryBoxSystem2.getUserData();
        if(deliveryBoxSystem1.isUserDataValidated() && deliveryBoxSystem1.isPaymentSecured()) {
            deliveryBoxSystem2.openBox();
        }

    }

}
