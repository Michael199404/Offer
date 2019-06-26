package Singleton;
/*
* 懒汉模式直接使用同步函数的方法效率十分低下的解决方案：
* 达到只判断一次锁，并且实现同步的目的。
*
* 假设我们现在并没有创建单例对象，即s==null，那么我们调用getInstance方法的时候，会进入if块，然后进入同步代码块，
* 此时，别的线程如果想要创建Single实例，就必须获取锁；等当前线程创建完实例对象，释放锁之后，
* 假设正巧有几个线程已经进入了if块中，它们会拿到锁，进入同步代码块，但是由于进行了判空操作，
* 所以不会创建Single实例，而是直接返回已经创建好的Single实例。如果有多个其他线程进入了if块，
* 当它们依次进入同步代码块的时候，同理也不会创建新的Single实例。而没有进入if块的线程，
* 判空操作之后不满足条件，进不了if块，而直接执行了下一条语句return s；其后的线程调用getInstance方法时，
* 只会判断一次s==null，不满足条件直接返回Single单例s，这样就大大提高了了执行效率。
*
*
* */
public class Singleton3 {

    private volatile static Singleton3 singleton3;

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        if(singleton3 == null){
            synchronized (Singleton3.class){
                /*
                * 如果有其他线程正好进入了第一个if语句块中，当其他线程获取当上一个线程释放的锁的时候，
                * 会进行依次判空，因为上一个线程已经创建好了对象，所以这个线程就不会再创建了
                 * */
                if(singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
