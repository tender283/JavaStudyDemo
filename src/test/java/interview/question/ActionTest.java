package interview.question;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ActionTest {
    //数组面试问题二；
    public void plus1ForEvenIndex(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            if ((index + 1) % 2 == 0) {
                arr[index] = arr[index] + 1;
            }
        }
    }
    @Test
    public void test数组面试(){
    //问题一：下列代码的执⾏结果的报错原因；
        /*
        int[] n = new int[3]{1, 2, 3};
        System.out.println(n[1]);
        */
       /*
       解答：编译时报错，数组声明时如果使⽤⼤括号赋值，不能在 [] 内指定数组的⻓度，数组的⻓度为⼤括号内元
       素的个数。
       */

    //问题二：下列代码的执⾏结果：
        int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        plus1ForEvenIndex(n);
        System.out.println(Arrays.toString(n));
        /*
        其分析过程为：
               index：0, 1, 2, 3, 4, 5, 6, 7, 8, 9；
             index+1：1, 2, 3, 4, 5, 6, 7, 8, 9, 10；
                 arr: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10；
                输出:arr[0],arr[1]+1;arr[2];arr[3]+1;arr[4];arr[5]+1;arr[6];arr[7]+1;arr[8];arr[9]+1;
        即数组输出为: 1, 3, 3, 5, 5, 7, 7, 9, 9, 11;
         */
        /*
        执⾏结果：[1, 3, 3, 5, 5, 7, 7, 9, 9, 11];
        Java ⽅法参数是值传递，⽅法得到是参数的拷⻉，所以⽅法内代码不会改变所传参数的值。但对于引⽤类型，
        虽然不能改变引⽤类型的引⽤，却可以修改引⽤类型指向的对象的值。
         */
    //问题三：下面代码的执行结果
        /*在编译时，会自动给它赋初值：
        基本类型：二进制的0；
          int，long: 0；  float、double: 0.0；   Boolean: false(在存储过程中也是二进制的0);
        引用类型：
         */
        int[] a = new int[3];
        String[] s = new String[3];
        System.out.println(a[1]);
        System.out.println(s[1]);
        /*
        执⾏结果：0 和 null;
        数组声明时未进⾏赋值时，对于基本数据类型，将每⼀个元素赋值为⼆进制0；⽽对于引⽤类型，则将每⼀个元素
        赋值为 null;
         */
    //问题四：数组的遍历方式有哪些？
        /*
        1、for循环使用数组下标；
        2、for each循环；
        3、Java8 新增的Lambda;
         */
    //问题五：举例说明Arrrays工具类的常用方法及说明：
        /*
        copyOf
        copyOfRange
        fill
        sort
        toString
        equals
        asList
        binarySearch
         */


    }

}
