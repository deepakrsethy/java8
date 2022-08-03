package lamndaexpression;

public class CalculatorImpl {
    public static void main(String[] args) {
        Calculator c = () -> System.out.println("Switched on");
        c.switchOn();

        CalculatorAdd add = (x, y) -> x+y;
        System.out.println(add.add(10, 20));
    }
}
