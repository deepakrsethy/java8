package lamndaexpression;

/**
 * The expression through which we can represent an anonymous function
 * Anonymous : Nameless
 * Anonymous function : A method which don't have any name or modifier.
 *
 * Syntax : ()           ->                    Body
 *      Parameter    Expression             System.out.println("Lambda syntax")
 */
public class Lambda1 {
    //1. we can convert normal method to anonymous function
    public void m1(){
        System.out.println("Normal function");
    }

    /**
     *   here its not usable. As we can't call it. So we can write valid anonymous functions for
     *   any function.
     *   We can write anonymous function for a functional interface to make it useful.
     *   () {
     *         System.out.println("Anonymous function");
     *     }
     *
     *    Functional interfaces in java :
     *    The interface which contains only one abstract method but can have multiple default
     *    and static methods is called a functional interface.
     *    Examples:
     *    1. Runnable -------- run()
     *    2. Comparable--------compareTo()
     *    3. Callable----------call()
     *    4. Comparator---------compare()
     *
     */

    public static void main(String[] args) {
        FunctionalInterfaceDemo f = s -> s+" World";
        System.out.println(f.display("Hello"));
        FIDemo2 d2 = (x, y) -> x+y;
        System.out.println(d2.add(10, 20));

    }
}
