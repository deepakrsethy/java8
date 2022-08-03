package streamapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("dee", "pee", "kkk", "dma");
        list.stream().filter(x -> x.startsWith("d")).forEach(s -> System.out.println(s));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        int n = Integer.MAX_VALUE;

        map.entrySet().stream().filter(obj -> obj.getKey()%2 == 0)
                .forEach(obj -> System.out.println(obj.getKey()+ " : "+obj.getValue()));
    }
}
