package com.zeroten.javales.flow;

import org.testng.annotations.Test;

public class IfElseTest {
    @Test
    public void testIfElseTest()
    {
//      下⾯我们来做⼀个示例：给定⼀个年龄，然后判断该年龄属于⼉童、⻘年、中年还是⽼年；年龄使⽤ int 类
//       型，只⽀持整数。年龄段的划分规则如下：
//       年龄范围描述:
//        0 ~ 6岁 ⼉童
//        7 ~ 17岁 少年
//        18 ~ 40岁 ⻘年
//        41 ~ 59岁 中年
//        60及以上 ⽼年
        int age=41;
        if (age<7){
            System.out.println(age + "岁，属于儿童");
        }else if (age<18){
            System.out.println(age + "岁，属于少年");
        }else if(age<41){
            System.out.println(age + "岁，属于青年");
        }else if(age<60){
            System.out.println(age + "岁，属于中年");
        }else{
            System.out.println(age + "岁，属于老年");
        }



    }

}
