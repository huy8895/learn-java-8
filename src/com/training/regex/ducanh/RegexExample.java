package com.training.regex.ducanh;

public class RegexExample {
    public static void main(String[] args) {
        String input1 = "1,2";
        String input2 = "1,4.5";
        String input3 = "1,2,6";
        String input4 = "123456789";

        // 1. check regex Java  là kiểu số và có dấu ',' phân cách phần thập phân.
        String regex1 = "^[\\d]+,[\\d]+$";

//        2. check regex Java  là kiểu số và có dấu ','
//        phân cách phần thập phân và có dấu '.'
//        phân cách hàng nghìn triệu tỷ VD: 10.000,25
        String regex2 = "^[\\d]+\\.[\\d]+\\,[\\d]+$";



        System.out.println("input4.matches(regex1) = " + input4.matches(regex1));
        System.out.println("input1.matches(\".+?\") = " + input1.matches(".+?"));
    }
}
