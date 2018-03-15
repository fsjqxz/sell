package org.fsj.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wxy on 2018-2-2.
 */

public class Test {


    public static void main(String[] args) {

        List list = new ArrayList(3);
        List<String> list2 = new ArrayList<>();
        Map map = new TreeMap<>();
        System.out.println("...");
    }

        //演示一
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Java7");
            }
        }).start();
        new Thread( ()-> System.out.println("java8")).start();*/
//        System.out.println("/********************************************/");
//        //演示二
//        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        for (Object feature : features) {
//            System.out.println(feature);
//        }
//        features.forEach(n -> Strings(n));
//        features.forEach(System.out::println);
//        System.out.println("re=" +re );
//        System.out.println("/********************************************/");
//        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//
//
//
//        System.out.println("Print all languages :");
//        filter(languages, (str)->true);
//
//        System.out.println("Print no language : ");
//        filter(languages, (str)->false);
//
//        System.out.println("/********************************************/");
//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
//
//        System.out.println("/********************************************/");
//        Optional< String > fullName = Optional.ofNullable( null );
//        System.out.println( "Full Name is set? " + fullName.isPresent() );
//        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
//        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
//    }
//
//    public static String re = "";
//    private static void Strings(Object n) {
//
//        String i = (String) n;
//        re = re +i;
//    }
//
//
//    public static void filter(List<String> names, Predicate condition) {
//        for(String name: names)  {
//            if(condition.test(name)) {
//                System.out.println(name + " ");
//            }
//        }
//    }



}
