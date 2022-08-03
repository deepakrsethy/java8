package staticmethod;

public class VehicleImpl extends VehicleClass implements Vehicle, Vehicle2
        /*extends VehicleClass: CE: Extends come before implements */
{
    //Overridding not possible as the interface method is static method. Treated as ordinary method

    public void producer(){
        System.out.println("Ford Motors: From Impl");
    }

    public static void main(String[] args) {
        /* static methods can be accessed through Class Name */
        Vehicle.producer();
        /*can have same static method in diff interface */
        /* No ambiguity error as the methods are static and accessed through Class Name*/
        Vehicle2.produce();
         Vehicle vehicle = new VehicleImpl();

        /* Can not access static methods in interface through instance */
        //vehicle.producer(); // CE
        /*We can same method signature in child class*/
        VehicleImpl vehicleImpl = new VehicleImpl();
        vehicleImpl.producer(); //Print

        /*Normal method overriding*/
        VehicleClass vehicleClass = new VehicleImpl();
        vehicleClass.produce();


    }

}
