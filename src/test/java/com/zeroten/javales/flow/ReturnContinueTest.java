package com.zeroten.javales.flow;

import org.testng.annotations.Test;

import java.util.Random;

public class ReturnContinueTest {
    @Test
    public void BreakTest(){
//      练习1：还是前边的练习，我们来改写⼀下。随机⽣成⼀个 0 ～ 1000 范围的整数，如果不能被30整除，则
//      打印出数字，如果能被30整除则退出循环
        int total = 0;
        while(true){
            int r = new Random().nextInt(1000);
            if(r % 30 == 0){
                System.out.println(r + "能被30整除，退出");
                break;
            }else{
                System.out.println(r + "不能被30整除，继续");
                total++;
            }
        }
        System.out.println("随机产生了" + total +"个不能被30整除的数");
    }
    int getMaxNumRem7(int n1, int n2){
        for(int n =n2; n >= 0; n--){
            if(n % n1 == 7)
                return n;
        }
        return -1;
    }
    @Test
    public void ReturnTest(){
//       练习2：编写⼀个⽅法 int getMaxNumRem7(int n1, int n2) 找出 0 ~ n2 范围内除以 n1 余 7 的最⼤的
//       数，找到则返回该数，如果找不到则返回 -1。
        int r1 = getMaxNumRem7(8, 100);
        System.out.println(r1);
    }
    @Test
    public void ContinueTest(){
//        练习3：找出 0 ~ 100 范围内能被7整除的数，并计算它们累计相加的结果。
        int total = 0;
        for(int n = 0; n < 100; n++){
            if (n % 7 != 0){
                continue;
            }
            System.out.println(n + "能被7整除");
            total++;
        }
        System.out.println("0~100之间总共有" + total + "个数能被7整除");
    }
}
