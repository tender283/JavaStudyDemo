package com.zeroten.javales.sting;

import org.testng.annotations.Test;

public class StringTest {
    @Test
    public void test字符串的内存使用(){
        String str1 = "hello";
        String str2 = "hello";

        System.out.println("str1 = str2:" + (str1 == str2));

        String str3 = "hello world";
        String str4 = str1 + " world";
        System.out.println("str3 = str4:" + (str3 == str4));

        String str5 = new String("hello");
        String str6 = new String("hello");
        System.out.println("str5 = str6:" + (str5 == str6));

        String str7 = str6.intern();
        System.out.println("str1 = str7:" + (str1 == str7));
    }
    @Test
    public void test字符串长度的计算(){
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
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
    }
    @Test
    public void test前后缀判断(){
        String str1 = "hello";
        System.out.println(str1.startsWith("h"));
        System.out.println(str1.startsWith("he"));
        System.out.println(str1.startsWith(" h"));
        System.out.println(str1.startsWith("a"));

        System.out.println(str1.endsWith("llo"));
        System.out.println(str1.endsWith("o"));
        System.out.println(str1.endsWith("o "));
        System.out.println(str1.endsWith("a"));

        System.out.println(str1.contains("ello"));
        System.out.println(str1.contains("elo"));
        System.out.println(str1.contains("hello"));
    }
    @Test
    public void test替换查找(){
        String str1 = "hello, world. today is 2020-5-4. say hi to me.";

        int at1 = str1.indexOf("o",7);
        System.out.println(at1);
        int at2 = str1.indexOf("z");
        System.out.println(at2);

        int index = -1;
        do{
            int at3 = str1.indexOf("o",index + 1);
            if (at3 == -1){
                break;
            }
            System.out.println(String.format("第 %d 位是小写字母o", at3 + 1));
            index = at3;
        }while(true);
    }
}
