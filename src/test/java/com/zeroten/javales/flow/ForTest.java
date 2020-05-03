package com.zeroten.javales.flow;

import org.testng.annotations.Test;

public class ForTest {
    @Test
    public void ForTest(){
//        练习：打印 0 ~ 100 范围内的单数并计算范围内单数的总个数;
    int total = 0;
    for(int n = 0; n < 100; n++){
        if(n % 2 != 0){
            System.out.println(n + "是一个单数");
            ++total;
        }
    }
    System.out.println("0 ~ 100范围内有" + total + "个单数");
    }

//    练习：假如你有⼀个机器⼈，你通过输⼊数字指令来指挥机器⼈，⽐如输⼊ 1 让机器⼈扫地，输⼊ 2 让机
//    器⼈打开灯。具体指令如下：
//    数字指令 执⾏命令
//    1 扫地
//    2 开灯
//    3 关灯
//    4 播放⾳乐
//    5 关闭⾳乐
//    其他数字 不能识别的指令
    @Test
    public void SwitchTest(){
        int cmdN = 3;
        switch(cmdN){
            case 1:
                System.out.println("1: 扫地");
                break;
            case 2:
                System.out.println("2: 开灯");
                break;
            case 3:
                System.out.println("3: 关灯");
                break;
            case 4:
                System.out.println("4: 播放音乐");
                break;
            case 5:
                System.out.println("5: 关闭音乐");
                break;
            default:
                System.out.println(cmdN + ": 不能识别的指令");
        }
    }
}
