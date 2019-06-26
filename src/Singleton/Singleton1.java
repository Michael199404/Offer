package Singleton;
/*
* 单例模式一：饿汉式（雏形）
* */
public class Singleton1 {

    //使用private修饰，其他的类不能直接使用该变量
    private static Singleton1 instance = new Singleton1();

    //private修饰的构造函数，其他类不能直接调用构造函数创建一个该类的对象
    private Singleton1(){

    }

    /*
    *1.提供一个public修饰的方法，用于获取这个唯一被创建出来的变量
    *2.方法为什么是静态的？
    *不能new对象却想调用类方法，方法必然是静态的，静态方法只能调用静态成员，所以对象也是静态的
    *3.为什么对象的访问修饰符是private？
    *因为如果对象修饰符是public，那么调用Single1.instance也可以得到该对象，这样就造成了不可控
    */
    public Singleton1 getInstance(){
        return instance;
    }
}
