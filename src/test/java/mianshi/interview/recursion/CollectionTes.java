package mianshi.interview.recursion;

import java.util.*;

public class CollectionTes implements InterfaceTest{
    public static void main(String[] args) {
        List c = new LinkedList();
        c.add("w");
        c.add("o");
        c.add("r");
        c.add("l");
        c.add("d");
//        System.out.println(c);
//        Collections.shuffle(c);
//        System.out.println(c);
//        Collections.shuffle(c);
//        System.out.println(c);

//        Date date = new Date();
//        List c = new LinkedList();
//        List b = new ArrayList();
//        List a = new Vector();
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            a.add(i);
//        }
//        long endTime = System.currentTimeMillis();    //获取结束时间
//        System.out.println("Vector程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
//        long startTime1 = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            b.add(i);
//        }
//        long endTime1 = System.currentTimeMillis();    //获取结束时间
//        System.out.println("ArrayList程序运行时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间
//        long startTime2 = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            c.add(i);
//        }
//        long endTime2 = System.currentTimeMillis();    //获取结束时间
//        System.out.println("LinkedList程序运行时间：" + (endTime2 - startTime2) + "ms");    //输出程序运行时间

        Collections.rotate(c,0);
        Collections.swap(c,1,2);
        System.out.println(c);
        System.out.println(Collections.max(c));
        System.out.println(Collections.min(c));


        List m = Arrays.asList("one two three four five six siven".split(" "));
        System.out.println(m);
        List n = Arrays.asList("我 是 复制过来的哈".split(" "));
        System.out.println(n);
       // Collections.copy(m,n);
       // System.out.println(m);
        List list = Arrays.asList("one two three four five six siven three four five six".split(" "));
        System.out.println(list);
        List subList = Arrays.asList("three four five six".split(" "));
        System.out.println(Collections.indexOfSubList(list, subList));
        System.out.println(Collections.binarySearch(list,"two"));
        System.out.println(Collections.binarySearch(c,"w"));


        System.out.println(i);
    }
}
