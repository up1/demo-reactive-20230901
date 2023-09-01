package stream;

import java.util.Arrays;
import java.util.List;

public class Demo01 {

    public static void main(String[] args) {
        List<String> datas = Arrays.asList("a", "b", "c", "bx");
//        for (int i = 0; i < datas.size(); i++) {
//            if(datas.get(i).startsWith("b"))
//                System.out.println(datas.get(i));
//        }
//        for (String data : datas) {
//            System.out.println(data);
//        }
//        datas.forEach(System.out::println);

        // Stream APIs
        datas.stream()
                .filter( d -> d.startsWith("b"))
                .filter( d -> d.endsWith("x"))
                .forEach(System.out::println);

        datas.stream().forEach(System.out::println);
        datas.parallelStream().forEach(System.out::println);
    }

}
