package functionalInterface;

@FunctionalInterface //forces to have only one abstract method otherwise gives CE
public interface Foo {
     public abstract void display(); //abstract method

     public static void produce(){
          System.out.println("Display something.");
     }
     public default void defaultProduce(){
          produce();
     }

     public static void main(String[] args) {
          Foo foo = new Foo() {
               @Override
               public void display() {
                    System.out.println("Display");
               }
          };
          foo.defaultProduce();
     }
}
