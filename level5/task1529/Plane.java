package level5.task1529;

public class Plane implements CanFly {
    private int passengersNumber;
    @Override
    public void fly() {}
    Plane(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }
    public int getPassengersNumber() {
        return passengersNumber;
    }   
}