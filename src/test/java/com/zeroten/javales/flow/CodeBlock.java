//代码块的使用：
package com.zeroten.javales.flow;

import org.testng.annotations.Test;

public class CodeBlock {
    @Test
    public void testBlockScope()
    {
        //代码块的规则是：小括号里面的变量可以访问大括号的变量，而大括号里面的变量访问不到小括号里面的变量
        int n1=100;
        System.out.println(n1);
        {
            //int n1=101;
            int n2=200;
            System.out.println(n1);
            {
                System.out.println(n2);
            }
        }
        //System.out.println(n2);
        int n2=201;
        System.out.println(n2);
    }
}
