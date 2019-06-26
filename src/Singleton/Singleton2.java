package Singleton;
/*
* 单例模式二：懒汉式
* 懒汉式和饿汉式相比的区别就是懒汉式创建了延迟对象，但是在多线程编程中，使用懒汉式可能会造成类的对象在内存中不唯一。
*
* 懒汉式在多线程中出现的问题：
* 懒汉式由于多加了一次判断：if(instance==null)，导致了线程安全性隐患。因为CPU很有可能在执行完if语句之后切向其它线程。
* 解决线程安全性问题的关键就是加上同步锁。
* 但是直接使用同步函数的方法效率十分低下，因为每次调用此方法都需要先判断锁。
* */
public class Singleton2 {

    //类初始化时，不初始化这个对象(延时加载，真正用的时候再创建)
    private static Singleton2 instance = null;

    //构造器私有化，禁止创建新的对象
    private Singleton2(){

    }

    //方法同步，调用效率低
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
