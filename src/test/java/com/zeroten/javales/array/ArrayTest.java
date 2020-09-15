package com.zeroten.javales.array;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

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


//数组的遍历；
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


//数组的拷贝
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



//数组的填充
    @Test
    public void testFill(){
//示例：定义⼀个⼤⼩为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；
// 然后将数组后 3 为赋值为 3，再次打印数组。
//方式一：使用普通的方式来实现数组的填充；
        int[] arr = new int[10];
        for(int index = 0;index < arr.length; index++){
            arr[index] = 5;
        }
        System.out.println(Arrays.toString(arr));
        for(int index = arr.length - 3; index < arr.length; index++){
            arr[index] = 3;
        }
        System.out.println(Arrays.toString(arr));
//方式二：使用Fill方法来实现数组的填充；
        int[] arr1 = new int[10];
        Arrays.fill(arr1,5);
        System.out.println(Arrays.toString(arr1));
        Arrays.fill(arr1,arr1.length - 3, arr1.length, 3);
        System.out.println(Arrays.toString(arr1));
//在fill方法中，Arrays.fill(arr1,fromIndex,toIndex,val)中，一定要注意fromIndex的范围 >= 0,
//而toIndex <= arr1.length;    此外toIndex的值一定也大于fromIndex;   否则将会报错。
    }


//数组的排序;
    @Test
    public void testSort(){
        //示例：
        //1、定义⼀个⼤⼩为 100 的 int 数组;
        //2、随机给每⼀位赋值⼀个 0 ~ 100 之间的数值;
        //3、然后对该数组进⾏排序;
        //4、并打印排序结果;
        int[] arr = new int[100];
        for(int index = 0; index < arr.length; index++){
            arr[index] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

//数组的多维数组和不规则数组；
    @Test
    //在Java中其实只有一维数组，而多维数组可以被理解为“数组的数组”,
    // 因此要在数组的第一维度中注明范围；
    //多维数组的同⼀个维可以有不同的⻓度，因此也可以称为不规则数组;
    //声明时使⽤多个 [] 标识来声明;
    public void testDuoWeiShuZu(){
        //示例：
        //1、定义⼀个⼆维数组;
        //2、第⼀维表示⽤户;
        //3、第⼆维表示⽤户的具体信息（1. 编码, 2. 姓名, 3.性别, 4.年龄）;
        //4、定义赋值并打印;
        String[][] users = new String[5][];
        users[0] = new String[4];
        users[0][0] = "001";
        users[0][1] = "张三";
        users[0][2] = "男";
        users[0][3] = "25";


        //如下：当users[1] = new String[3];时，如果再输入users[0][3]的值就会因超出边界而报错；
        //因此也从另一个方面看出，在Java中只有一维数组且存在不规则数组；
        users[1] = new String[3];
        users[1][0] = "002";
        users[1][1] = "李四";
        users[1][2] = "女";

        //System.out.println(Arrays.toString(users));
        //如果以上述方法进行输出之后，会发现只是一个地址性符号，因此可以证明在Java中只有一维数组；
//输出的方式之一：for循环
        for (int index = 0; index < users.length; index++){
            System.out.println(Arrays.toString(users[index]));
    }
//输出的方式之二：for each循环
        for (String[] user : users){
            System.out.println(Arrays.toString(user));
        }
//输出的方式之三： Java 8 中新增的 Lambda 表达式；
        Arrays.asList(users).forEach(user -> System.out.println(Arrays.toString(user)));
    }

}

