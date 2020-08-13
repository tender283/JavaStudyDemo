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


    @Test
    public void testTraverse(){
//示例：分别使⽤上述三种⽅式遍历数组 Integer[] arr = {1, 2, 3, 4, 5};
  //数组遍历的方式一：for 循环使⽤数组下标；
        Integer[] arr = {1, 2, 3, 4, 5};

        for(int index = 0; index < arr.length; index++)
        {
            //第一种输出方式：
            //System.out.println("下标：" + index + ", 存放的值是：" + arr[index]);
            //第二种输出方式：
            System.out.println(String.format("下标：%d, 存放的值是：%d", index, arr[index]));
        }

  //数组遍历的方式二：for each 循环；
        int index = 0;
        for(int val : arr){
            //两种不同的输出方式；
            //System.out.println("第" + index + "次取到" + val);
            System.out.println(String.format("第%d次取到%d", index, val));
            index++;
        }
        //数组遍历的方式三：Java 8 中新增的 Lambda 表达式；
        Arrays.asList(arr).forEach(val -> System.out.println("值是：" + val));
        System.out.println();
        //上述展示的方式是属于单独语句的时候，类似于for的单独语句形式；
        //而当语句不止一句时，其语句的表现形式为：
        Arrays.asList(arr).forEach(val -> {
            System.out.println(String.format("值是：%d", val));
            if(val % 2 == 0){
                System.out.println("    它是一个偶数");
            }else{
                System.out.println("    它是一个奇数");
            }
        });
    }

    @Test
    public void testCopy() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] arr2 = {6, 7, 8, 9, 10};
//Java 中数组拷⻉常⽤的两种⽅式：
//方式一：使⽤⼯具类 Arrays.copyOf 或 Arrays.copyOfRange（从根本上说：也是调用了System.arraycopy方法）；
        //拷贝数组arr1的前3个元素，并生成一个新的数组；
        Integer[] arr11 = new Integer[3];
        arr11[0] = arr1[0];
        arr11[1] = arr1[1];
        arr11[2] = arr1[2];
        System.out.println("arr11 = " + Arrays.toString(arr11));

        Integer[] arr12 = Arrays.copyOf(arr1, 3 );
        System.out.println("arr12 = " + Arrays.toString(arr12));

        //拷贝数组 arr1 的后 3 位的元素到一个新的数组；
        Integer arr13[] = Arrays.copyOfRange(arr1, arr1.length - 3, arr1.length);
        System.out.println("arr13 = " + Arrays.toString(arr13));

        //拷贝数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）；
        /*在下面的此次的操作中，里面的 Arrays.copyOfRange 工具类其实是调用了原方法：System.arraycopy,而在
        此方法内会有循环判断，from 是从数组的 "0" 算起，而最后的判断是 "<" 判断；
        */
        Integer[] arr14 = Arrays.copyOfRange(arr1, 0, 2);
        System.out.println("arr14 = " + Arrays.toString(arr14));

//方式二：使⽤底层⽅法 System.arraycopy；
        // 拷贝数组 arr2 的后 3 位到 arr1 到后 3 位；
        System.arraycopy(arr2, arr2.length - 3, arr1, arr1.length - 3, 3);
        System.out.println("arr1 = " + Arrays.toString(arr1));
    }
}
