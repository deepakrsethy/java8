package defaultmethods;

public class VehicleImpl extends VehicleSuper implements Vehicle, Vehicle1{

    /*Without overrding and providing its own implementation it will give compilation error*/


    public static void main(String[] args) {
        Vehicle v = new VehicleImpl();
        v.produce();

    }
}
