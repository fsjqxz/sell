package mianshi.interview.recursion;

import java.util.Scanner;

public class bisi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // next方式接收字符串
        System.out.println("开始输入：房屋租金，水果，钱，水果售卖");
        Integer x = 0;
        Integer f = 0;
        Integer d = 0;
        Integer p = 0;
        if (scan.hasNext()) {
            x = Integer.parseInt(scan.next());
            f = Integer.parseInt(scan.next());
            d = Integer.parseInt(scan.next());
            p = Integer.parseInt(scan.next());
            //System.out.println("输入的数据为：" + str1);
        }
        scan.close();
        Integer max  =  (d+f*p)/(x+p);
        System.out.println(max);

    }


}
