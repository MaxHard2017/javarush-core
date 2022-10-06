package level5.task1529;

import java.security.PublicKey;

public class Plane implements CanFly {
    private int passengersNumber;
    @Override
    public void fly() {}
    Plane(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }
}