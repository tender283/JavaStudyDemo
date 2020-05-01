package com.zeroten.javales.flow;

import org.testng.annotations.Test;

import java.util.Random;

public class WhileTest {
    @Test
    public void testWhile(){
//        练习：随机⽣成⼀个 0 ～ 1000 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除
//        则退出循环。⽣成 0 ~ 1000 范围的整数使⽤语句 int r = new Random().nextInt(1000) 。
        boolean isContinue=true;
        int times =0;
        while(isContinue){
            int r = new Random().nextInt(1000);
            if (r % 30 == 0){
                isContinue = false;
                System.out.println(r + "能被30整除，退出");
            }else{
                System.out.println(r + "不能被30整除，继续");
                times ++;
            }
        }
        System.out.println("随机产生了" + times +"不能被30整除的数");
    }
    @Test
    public void testDoWhile(){
        int times = 0;
        boolean isContinue = true;
        do{
            int r = new Random().nextInt(1000);
            if(r % 30 == 0){
                System.out.println(r + "能被30整除，退出");
                isContinue = false;
            }else{
                System.out.println(r + "不能被30整除，继续");
                times += 1;
            }
        }while(isContinue);
        System.out.println("随机产生了" + times + "个不能被30整除的数");
    }
}
