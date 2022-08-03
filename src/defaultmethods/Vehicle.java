package defaultmethods;

public interface Vehicle{
    /* Without having default keyword , we can not have the body of the method*/
 public default void produce(){
     System.out.println("DF Motors");
 }

}
