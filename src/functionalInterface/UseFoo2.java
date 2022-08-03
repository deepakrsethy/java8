package functionalInterface;

import java.util.function.Function;

public class UseFoo2{

    public static String add(String s, Foo2 foo2) {
        return foo2.method(s);
    }

    public static String add(String s, Function<String, String> fn){
        return fn.apply(s);
    }



    public static void main(String[] args) {
        Foo2 foo2 = param -> param+" from lambda.";
        String result = add("Message", foo2);
        System.out.println(result);


        //without having the interface
        Function<String, String> fn = parameter -> parameter+ " from lambda 2.";
        String output = add("Messages", fn);
        System.out.println(output);

        Foo3 foo3 = (x,y) -> x+y;
        System.out.println(foo3.addTwoNos(10, 20));

    }
}
