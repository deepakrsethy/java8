package parallelStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamDemoWithPrimitive {
    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        List<Integer> list = Arrays.asList(1, 12, 3, 14, 9);

        startTime = System.currentTimeMillis();
        IntStream.range(1, 100)
                .forEach(n->
                        System.out.println("Thread"+(Thread.currentThread().getName())+"Prints:"+n));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with normal stream: "+(endTime-startTime));

        startTime = System.currentTimeMillis();
        IntStream.range(1, 100).parallel()
                .forEach(n->
                        System.out.println("Thread"+(Thread.currentThread().getName())+"Prints:"+n));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: "+(endTime-startTime));

    }
}
