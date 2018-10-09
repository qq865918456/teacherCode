package com.qf.load;

/**
 * ----------类加载机制-----------------
 * 1、触发StaticTest类加载过程
 * 2、加载StaticTest时
 *      准备：
 *      st = null;
 *      b = 0;
 *
 *      初始化：
 *      stu = new StaticTest();
 *          StaticTest无参构造方法：
 *          调用构造方法前的隐式三步：
 *              1）调用父类构造方法
 *              2）初始化非静态成员 a=110
 *              3）调用非静态代码块
 *      b=112
 *
 *
 * 2
 * 3
 * a=110,b=0
 * 1
 * 4
 */
public class StaticTest
{
    public static void main(String[] args)
    {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}