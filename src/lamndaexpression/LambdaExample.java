package lamndaexpression;

import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
        int x=20, y=20;
    }


    Predicate<String> stringPredicate = s -> s.isEmpty();

}
