package defaultmethods;

public interface Vehicle1 {
    public default void produce(){
        System.out.println("BN Motors");
    }
}
