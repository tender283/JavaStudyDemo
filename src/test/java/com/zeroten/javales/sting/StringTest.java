package com.zeroten.javales.sting;

import org.testng.annotations.Test;

public class StringTest {
    @Test
    public void test字符串的内存使用(){

        String str1 = "hello";
        String str2 = "hello";
//判断两个对象是否指向同一个内存地址，且只有双引号赋值的变量才会在变量池中判断，首先判断在(字符串)
// 常量池中是否存在，str1的常量池肯定没有需创建，而str2在常量池中已经存在，因此其内存地址相等；true
        System.out.println("str1 = str2:" + (str1 == str2));

//由于str4是一个变量和加号连接符的方式赋值，因此不会在常量池中进行检测，会在堆中分配一个内存，然后
//将其放入，再返回引用；内存地址不相同；false
        String str3 = "hello world";
        String str4 = str1 + " world";
        System.out.println("str3 = str4:" + (str3 == str4));

        String str5 = new String("hello");
        String str6 = new String("hello");
//在使用new创建字符串，都会在堆中分配内存，即使是相同的字符串；然后再返回引用，因此尽管str5和str6
//的字符串值相同但其返回的地址不同。false
        System.out.println("str5 = str6:" + (str5 == str6));

        String str7 = str6.intern();
//而调用intern()方法，会先在常量池中寻找str6.intern()的值是否存在，若存在则直接返回引用，若不存在
//则再重新分配地址以及返回引用；虽然str6是在堆中分配的地址，但仍然需要在常量池中先寻找判断！true
        System.out.println("str1 = str7:" + (str1 == str7));
    }
    @Test
    public void test字符串长度的计算(){
//char是采用了UTF-16编码表示给定字符串所需要的代码单元数量(正常的)，而代码点是指实际字符的长度；
//而length返回的是字符数组的长度；而代码点数也有想要结果的计算方法(合二归一);
        String str1 = "hello, world";
        System.out.println(str1);
        System.out.println(str1.length());
        System.out.println(str1.codePointCount(0,str1.length()));

        String str2 = "hello, \uD835\uDD5D\uD835\uDD60\uD835\uDD60\uD835\uDD5C";
        System.out.println(str2);
        System.out.println(str2.length());
        System.out.println(str2.codePointCount(0,str2.length()));
    }
    @Test
    public void test子串(){
        String str1 = "hello, China.";
        String str2 = str1.substring(7, str1.length());
        String str3 = str1.substring(7);
        System.out.println(str2);
        System.out.println(str3);
        String str4 = str1.substring(7, str1.length() - 1);
        System.out.println(str4);
    }
    @Test
    public void test字符串的拼接(){
        String str1 = "hello" + ",world";
        str1 += "." + "2020";
        System.out.println(str1);
    }
    @Test
    public void test字符串的格式化(){
        //下面的语句为什么会报错？
        //System.out.println("大写a: %c %n", 'A');
        String str1 = "大写a:" + 'A' + "" + "\n";
        System.out.println(str1);

        String str2 = String.format("大写a: %c, 它的 ASCII 码值是：%d %n",'A',(int)'A');
        System.out.println(str2);
    }
    @Test
    public void test相等判断(){
        String str1 = "Hello";
        String str2 = "hello";
        //不忽略大小写的比较；
        System.out.println(str1.equals(str2));
        //忽略大小写的比较；
        System.out.println(str1.equalsIgnoreCase(str2));
    }
    @Test
    public void test前后缀判断(){
        String str1 = "hello";
        //判断字符串是否以指定字符开始的；
        System.out.println(str1.startsWith("h"));
        System.out.println(str1.startsWith("he"));
        System.out.println(str1.startsWith(" h"));
        System.out.println(str1.startsWith("a"));

        //判断字符串是否以指定字符结束的；
        System.out.println(str1.endsWith("llo"));
        System.out.println(str1.endsWith("o"));
        System.out.println(str1.endsWith("o "));
        System.out.println(str1.endsWith("a"));

        //判断字符串中是否包含指定字符；
        System.out.println(str1.contains("ello"));
        System.out.println(str1.contains("elo"));
        System.out.println(str1.contains("hello"));
    }
    @Test
    public void test查找(){
        String str1 = "hello, world. today is 2020-5-4. say hi to me.";

 //操作是从前往后寻找；从第7个位置开始从前往后寻找'o',并返回地址；
        int at1 = str1.indexOf("o",7);
        System.out.println(at1);

        //由于字符串中没有字符'z',因此其返回值为-1；
        int at2 = str1.indexOf("z");
        System.out.println(at2);

        //str1.indexOf的作用是从字符串的第一位判断到字符串的最后一位；
        int index = -1;
        do{
            int at3 = str1.indexOf("o",index + 1);
            if (at3 == -1){
                break;
            }
            //at3+1的原因：字符串在数组中的位置是从0开始的，而返回的地址需要符合自己看到的位置；
            System.out.println(String.format("第 %d 位是小写字母o", at3 + 1));
            index = at3;
        }while(true);

//操作是从后往前寻找；从后往前在字符串中寻找'o'，并返回地址；
        int at4 = str1.lastIndexOf("o");
        System.out.println(at4);

        int index2 = str1.length();
        do{
            int at5 = str1.lastIndexOf("o",index2 - 1);
            if (at5 == -1){
                break;
            }
            System.out.println(String.format("第 %d 位是小写字母o",at5 + 1));
            index2 = at5;
        }while(true);
    }

    //replace与replaceAll是有区别的，什么正则表达式,然而在此情况下的输出结果是相同的；
    @Test
    public void test替换(){
        System.out.println("hello, world!".replace("o","O"));
        System.out.println("hello, world!".replaceAll("o","O"));
    }

    @Test
    public void test去空格(){
        String str1 = "     hello,World   ";
        //去空格是指：无论多少前后空格都能去除；
        System.out.println(str1.trim());
        //将字符串全转换为大写；
        System.out.println(str1.trim().toUpperCase());
        //将字符串全转换为小写；
        System.out.println(str1.trim().toLowerCase());

        //指的是空串；
        String strEmpty = "";
        //指的String变量存放的是空值，没有指向任何对象；
        String strNull = null;

    }
}
