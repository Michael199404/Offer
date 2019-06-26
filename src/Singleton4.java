/*
* 单例模式：静态内部类实现
* */
public class Singleton4 {

    //私有化构造器
    private Singleton4(){

    }

    //对外提供公共的访问方法
    public static Singleton4 getInstance(){
        return SingletonInner.instance;
    }

    //写一个静态类，里面实例化外部类
    private static class SingletonInner{
        private static final Singleton4 instance = new Singleton4();
    }
}