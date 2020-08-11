package com.zeroten.javales.array;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayTest {
    @Test
    //数组的定义有如下两类；比较推荐的是int [] arr1;这种类型，数组类型指代明确；
    public void testArrayDeclare(){
        int[] arr1;
        String[] arr2;
        int arr3[];
        String arr4[];
    }
    @Test
    public void testArrayInitialization(){
//初始化方式一：使⽤ new 操作符创建的数组；
// 而用new创建数组时，基本数据类型每个值会初始化为⼆进制的0；⽽引⽤类型会初始化为null；
        int[] arr1 = new int[5];
        System.out.println("arr1 = " + Arrays.toString(arr1));

        boolean[] arr2 = new boolean[3];
        System.out.println("arr2 = " + Arrays.toString(arr2));

        String[] arr3 = new String[5];
        System.out.println("arr3 = " + Arrays.toString(arr3));

        Object[] arr4 = new Object[3];
        System.out.println("arr4 = " + Arrays.toString(arr4));

        //在使用数组的过程中可以先定义再初始化，也可以在定义的同时也初始化；
        int[] arr5;
        System.out.println();
        arr5 = new int[5];
        System.out.println("arr5 = " + Arrays.toString(arr5));


//初始化的方式二：使⽤ new 操作符创建数组时，直接使⽤⼤括号⽅法赋值；
// 1）、数组的⻓度为⼤括号内元素的个数，但不能在 []内指定⻓度，否则编译器会报错。
//2）、使⽤第 2 种⽅式创建数组时，可以省略前边的 new 操作符⽽直接使⽤⼤括号。
        int[] arr6 = new int[]{1,2,3};
        System.out.println("arr6 = " + Arrays.toString(arr6));

        int[] arr7 = {4,5,6};
        System.out.println("arr7 = " + Arrays.toString(arr7));

        String[] arr8 = new String[]{"字符串1", null, "", "字符串2"};
        System.out.println("arr8 = " + Arrays.toString(arr8));

        String[] arr9 = {"字符串3", "", null, "字符串4"};
        System.out.println("arr9 = " + Arrays.toString(arr9));

        Integer[] arr10 = {2, 9, 7, null, 0, 5};
        System.out.println("arr10 = " + Arrays.toString(arr10));

    }
    
}
